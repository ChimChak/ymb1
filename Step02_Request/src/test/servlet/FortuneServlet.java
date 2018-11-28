package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//2.  
@WebServlet("/fortune")
public class FortuneServlet extends HttpServlet{//1. 
	//3. 
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
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
		pw.println("<title>운세 페이지</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<p>동쪽으로 가면 귀인을 만나요</p>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();		
	}
}








