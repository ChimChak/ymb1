package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
/*
 *  회원 가입 폼을 출력해주는 액션 
 */
public class SignupFormAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//수행할 비즈니스 로직은 현재 없는 상태 
		
		// view 페이지로 forward 이동해서 회원가입 폼 출력하기 
		return new ActionForward("/views/users/signup_form.jsp");
	}

}













