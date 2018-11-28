package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;
/*
 *  폼 전송되는 수정할 회원의 정보를 읽어와서 DB 에 반영하고 응답하는 액션
 */
public class UsersUpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//수정할 회원의 아이디
		String id=(String)request.getSession().getAttribute("id");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		UsersDto dto=new UsersDto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setEmail(email);
		//DB 에 반영
		boolean isSuccess=UsersDao.getInstance().update(dto);
		// 성공 실패 여부를 request 에 담고 
		request.setAttribute("isSuccess", isSuccess);
		// view 페이지로 forward 이동해서 응답
		return new ActionForward("/views/users/update.jsp");
	}
}








