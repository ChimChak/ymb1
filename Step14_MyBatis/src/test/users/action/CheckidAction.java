package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
/*
 *  입력한 id 의 사용가능 여부 ajax 요청에 대한 JSON 응답을
 *  수행하는 액션 
 */
public class CheckidAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//입력한 아이디를 읽어온다.
		String inputId=request.getParameter("inputId");
		//사용가능 여부 확인
		boolean canUse=UsersDao.getInstance().canUseId(inputId);
		//사용가능 여부를 request 에 담고
		request.setAttribute("canUse", canUse);
		//view 페이지로 forward 이동해서 JSON 응답
		return new ActionForward("/views/users/checkid.jsp");
	}

}

















