package test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session_scope/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//세션 객체의 참조값 얻어오기
		HttpSession session=request.getSession();
		//session 영역에 문자열 저장하기
		session.setAttribute("id", "gura");
		
		//리다일렉트 이동
		String cPath=request.getContextPath();
		response.sendRedirect(cPath+"/login_result.jsp");
	}
}

















