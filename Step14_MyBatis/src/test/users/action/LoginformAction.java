package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
/*
 *  로그인 폼을 출력해주는 액션 
 */
public class LoginformAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//비즈니스 로직 X
		//로그인 후 이동할 url 정보를 읽어온다.
		String url=request.getParameter("url");
		if(url==null){//만일 전달되지 않았다면 
			//최상위 경로(인덱스)로 이동 되도록 한다. 
			url=request.getContextPath()+"/home.do"; 
		}
		// view 페이지에 전달할 내용을 request 영역에 담기 
		request.setAttribute("url", url);
		// view 페이지로 forward 이동해서 로그인 폼을 출력해주는 작업 
		return new ActionForward("/views/users/loginform.jsp");
	}
}


















