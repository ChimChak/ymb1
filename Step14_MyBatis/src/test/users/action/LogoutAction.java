package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
/*
 *  로그아웃 처리를 하는 액션
 */
public class LogoutAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//세션에 저장된 정보를 모두 삭제한다.
		request.getSession().invalidate();
		//view 페이지로 forward 이동해서 응답
		return new ActionForward("/views/users/logout.jsp");
	}

}











