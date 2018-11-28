package test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/request_scope/showfortune")
public class ShowFortuneServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//request 영역에 데이터를 담고 
		request.setAttribute("fortuneToday", "동쪽으로 가면 귀인을 만나요");
		
		//리다일렉트 이동하면 request 에 담긴 내용은 없어진다.
		String cPath=request.getContextPath();
		response.sendRedirect(cPath+"/fortune.jsp");
	}
}


















