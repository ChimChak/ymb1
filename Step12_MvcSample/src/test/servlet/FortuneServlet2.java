package test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sub/fortune")
public class FortuneServlet2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//1. 오늘의 운세를 얻어오는 비즈니스 로직을 수행한다.
		String fortuneToday="동쪽으로 가면 귀인을 만나요~";
		//2. 비즈니스 로직 수행결과로 얻어낸 데이터(Model) 을 request 에 담는다.
		request.setAttribute("fortuneToday", fortuneToday);
		//3. 클라이언트에게 응답할 view 페이지로 forward 이동시킨다 
		RequestDispatcher rd=
				request.getRequestDispatcher("/views/fortune.jsp");
		rd.forward(request, response);
	}
}


















