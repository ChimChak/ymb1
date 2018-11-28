package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//2.
@WebServlet("/detail")
public class DetailServlet extends HttpServlet{//1.
	//3.
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 파라미터 추출
		String num=request.getParameter("num");
		// num 에 해당되는 글정보를 DB 에서 select 해서 응답한다.
		String content="어쩌구.. 저쩌구..."; //글내용
		//응답 인코딩 설정
		response.setCharacterEncoding("utf-8");
		//응답 컨텐트 type 설정
		response.setContentType("text/html;charset=utf-8");
		
		//클라이언트에게 문자열을 출력할수 있는 객체
		PrintWriter pw=response.getWriter();
		//문자열 출력하기 
		pw.println("<!doctype html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'/>");
		pw.println("<title>글 자세히 보기 페이지</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<p>"+num+" 번글 :"+content+"</p>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();	
		
		
	}
}
















