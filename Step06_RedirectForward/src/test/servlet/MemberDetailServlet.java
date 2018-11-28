package test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.member.dto.MemberDto;

@WebServlet("/member/detail")
public class MemberDetailServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// 비즈니스 로직 수행결과 얻어낸 Model 이라고 가정 
		MemberDto dto=new MemberDto(1, "김구라", "노량진");
		// Model 을 request 에 담기
		request.setAttribute("dto", dto);
		// /member/detail.jsp 페이지로 forward 이동 (응답 위임하기)
		RequestDispatcher rd=request.getRequestDispatcher("/member/detail.jsp");
		rd.forward(request, response);
	}
}































