package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;
/*
 *  회원정보 수정폼을 출력해주는 액션 클래스 
 */
public class UsersUpdateformAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 수정할 회원의 정보를 얻어오기
		String id=(String)request.getSession().getAttribute("id");
		UsersDto dto = UsersDao.getInstance().getData(id);
		//2. request 에 회원의 정보를 담고
		request.setAttribute("dto", dto);
		//3. view 페이지로 forward 이동해서 수정폼 출력
		return new ActionForward("/views/users/updateform.jsp");
	}
	
}














