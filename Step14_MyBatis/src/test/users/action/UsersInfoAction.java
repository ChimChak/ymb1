package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;
/*
 *  로그인된 사용자 개인 정보 보기 액션 처리 
 */
public class UsersInfoAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//세션에 저장된 아이디 불러오기
		String id=(String)request.getSession().getAttribute("id");
		//아이디를 이용해서 사용자 정보 DB 에서 얻어오기
		UsersDto dto=UsersDao.getInstance().getData(id);
		//request 에 UsersDto 를 담고
		request.setAttribute("dto", dto);
		//view 페이지로 forward 이동해서 응답
		return new ActionForward("/views/users/info.jsp");
	}
}









