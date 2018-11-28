package test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// .do 로 끝나는 모든 요청을 처리할 액션 서블릿 정의하기 
@WebServlet("*.do")
public class ActionServlet extends HttpServlet{
	// .을 포함한 확장자의 길이 (.do 의 길이)
	private static final int EXTENSION_LENGTH=3;
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//요청 uri
		String uri=request.getRequestURI();
		//context path
		String contextPath=request.getContextPath();
		// .do 를 제외한 요청 경로를 추출한다.
		String command=uri.substring(contextPath.length(), 
				uri.length()-EXTENSION_LENGTH);
		
		//해당 command 를 수행할 Action 객체를 팩토리로 부터 얻어온다. 
		Action action=
				UserActionFactory.getInstance().action(command);
		
		if(action != null){//처리 가능한 command 라면 
			ActionForward af=null;
			try{
				//command 에 해당되는 비즈니스로직을 수행하고 ActionForward
				//객체를 리턴받는다 (이동경로, 리다일렉트 여부)
				af=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
				//액션 수행하다가 오류가 발생하면 500 에러를 발생 시킨다. 
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				return;
			}
			if(af.isRedirect()){//redirect 이동해야 한다면
				//redirect 이동 시킨다.
				response.sendRedirect(contextPath+af.getPath());
			}else{//forward 이동해야 한다면 
				RequestDispatcher rd=
						request.getRequestDispatcher(af.getPath());
				rd.forward(request, response);
			}
		}else {
			//처리할 액션이 없으면 404 에러를 발생 시킨다. 
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		
	}
}
















