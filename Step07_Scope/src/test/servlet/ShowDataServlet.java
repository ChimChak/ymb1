package test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.member.dto.MemberDto;

@WebServlet("/request_scope/showdata")
public class ShowDataServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		MemberDto dto=new MemberDto(2, "해골", "행신동");
		// request scope (request 영역) 에 담기
		request.setAttribute("dto", dto);
		
		// request 영역에 담으면 응답하기 전까지 유지 된다.
		// 즉 forward 이동된 showdata.jsp 페이지에서 사용할수 있다. 
		RequestDispatcher rd=
				request.getRequestDispatcher("/path1/showdata.jsp");
		rd.forward(request, response);
	}
}




















