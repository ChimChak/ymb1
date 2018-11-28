package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

public class CafeInsertformAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//수행할 비즈니스 로직은 없고
		
		//view 페이지로 forward 이동해서 응답
		return new ActionForward("/views/cafe/insertform.jsp");
	}

}






