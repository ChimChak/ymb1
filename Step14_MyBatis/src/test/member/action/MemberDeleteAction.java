package test.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.member.dao.MemberDao;

//회원 정보를 삭제하는 액션 
public class MemberDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//삭제할 회원의 primary key 를 읽어온다. 
		int num=Integer.parseInt(request.getParameter("num"));
		//삭제
		MemberDao.getInstance().delete(num);
		//뷰페이지에 전달할 정보를 request 에 담는다.
		//출력할 메세지
		request.setAttribute("msg", "회원정보를 삭제 했습니다.");
		//확인을 눌렀을때 이동할 url 
		request.setAttribute("url", "/member/list.do");
		
		ActionForward af=new ActionForward("/views/member/alert.jsp");
		return af;
	}

}







