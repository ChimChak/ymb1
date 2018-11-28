package test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//3. 
@WebServlet("/fortune")
public class FortuneServlet extends HttpServlet{//1.
	
	//2.
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// 오늘의 운세를 얻어오는 비즈니스 로직 수행
		String fortuneToday="노량진을 가면 주뎅이를 만나게 될거에요";
		//request 에 담기
		request.setAttribute("fortuneToday", fortuneToday);
		
		// "/fortune.jsp" 페이지로 응답을 위임 시키기
		RequestDispatcher rd=request.getRequestDispatcher("/fortune.jsp");
		rd.forward(request, response);
	}
}















