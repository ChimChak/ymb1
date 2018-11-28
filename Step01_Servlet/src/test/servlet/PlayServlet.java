package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  서블릿 정의하는 방법1
 *  
 *  - WEB-INF/web.xml 에 servlet 을 정의하고 맵핑한다.
 *  - HttpServlet 클래스를 상속 받는다.
 *  - service() 메소드를 오버라이딩한다. 
 */
public class PlayServlet extends HttpServlet{
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
		pw.println("<title>노는 페이지</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>신나게 놀아 보아요!</h3>");
		pw.println("<a href='index.html'>인덱스로 가기</a>");
		pw.println("<a href='/Step01_Servlet/index.html'>인덱스로 가기</a>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}







