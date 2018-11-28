package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// web.xml 에 서블릿 정의 및 맵핑을 대신하는 어노테이션 
@WebServlet("/showtime")
public class ShowTimeServlet extends HttpServlet{
	
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
		pw.println("<title></title>");
		pw.println("</head>");
		pw.println("<body>");
		//현재 시간 얻어내기 
		Date d=new Date();
		String now=d.toString();
		//현재 시간을 클라이언트에게 출력하기 
		pw.println("<p>현재시간:"+now+"</p>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();		
	}
}















