package test.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

// 회원추가 폼을 출력주는 액션 
public class MemberInsertformAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 수행할 비즈니스 로직은 없음요
		
		ActionForward af=new ActionForward("/views/member/insertform.jsp");
		return af;
	}

}






