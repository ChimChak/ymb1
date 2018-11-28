package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;
/*
 *  파라미터로 전달된 아이디 비밀번호를 추출해서 맞는 정보인지 확인해서
 *  응답하는 액션 
 */
public class LoginAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. form 전송된 아이디 비밀번호를 읽어온다.
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		//2. DB 에서 맞는 정보인지 확인한다.
		UsersDto dto=new UsersDto();
		dto.setId(id);
		dto.setPwd(pwd);
		boolean isValid=UsersDao.getInstance().isValid(dto);
		if(isValid) {//유효한 정보이면 로그인 처리를 해준다.
			request.getSession().setAttribute("id", id);
		}
		//3. view 페이지에서 필요한 정보를 request 영역에 담는다.
		request.setAttribute("isValid", isValid);
		//4. view 페이지로 forward 이동해서 응답한다.
		return new ActionForward("/views/users/login.jsp");
	}

}







