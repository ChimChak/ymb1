package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;

/*
 *  회원 정보 삭제하는 액션 
 */
public class UsersDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id=(String)request.getSession().getAttribute("id");
		UsersDao.getInstance().delete(id);
		//로그 아웃 처리
		request.getSession().invalidate();
		// 탈퇴한 id 를 request 에 담고 
		request.setAttribute("id", id);
		// view 페이지로 forward 이동해서 응답
		return new ActionForward("/views/users/delete.jsp");
	}

}








