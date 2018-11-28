package test.member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.member.dao.MemberDao;
import test.member.dto.MemberDto;
/*
 *  회원 목록 보기 요청을 처리할 액션
 */
public class MemberListAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. DB 에서 회원 목록을 얻어온다.
		List<MemberDto> list=MemberDao.getInstance().getList();
		//2. request 에 담는다.
		request.setAttribute("list", list);
		//3. view 페이지로 forward 이동해서 목록을 출력한다. 
		ActionForward af=new ActionForward("/views/member/list.jsp");
		//af.setRedirect(false);
		
		return af;
	}

}











