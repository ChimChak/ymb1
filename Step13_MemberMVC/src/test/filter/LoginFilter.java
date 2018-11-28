package test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 *  요청을 중간에 가로채서 특정 동작을 하는 필터 정의하기
 *  
 *  1. Filter 인터페이스를 구현한다.
 *  2. 어떤 경로 요청에 대해서 동작할지 맵핑한다.
 */
@WebFilter({"/gallery/private/*","/game/*","/users/private/*","/file/private/*"})
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}
	//필터가 동작되면 호출되는 메소드 
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, 
			FilterChain chain)
			throws IOException, ServletException {
		//1. session 영역에 로그인 정보가 있는지 확인해서 
		// 원래 type 으로 casting 
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		//HttpSession 객체의 참조값 얻어오기
		HttpSession session=request.getSession();
		//세션에 id 라는 키값으로 저장된 값이 있는지 읽어와 본다
		String id=(String)session.getAttribute("id");
		//2. 로그인 정보가 있으면 개입하지 않고 
		//3. 로그인 정보가 없으면 리다일렉트 응답하기 
		if(id != null) {
			//요청의 흐름 계속 진행 시키기(개입 안하기)
			chain.doFilter(req, res);
		}else {
			String cPath=request.getContextPath();
			//원래 요청된 목적지 정보
			String url=request.getRequestURI();
			String queryStr=request.getQueryString();
			if(queryStr==null) {
				queryStr="";
			}else {
				queryStr = "?"+queryStr;
			}
			response.sendRedirect(cPath+"/users/loginform.jsp?url="+url+queryStr);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}










