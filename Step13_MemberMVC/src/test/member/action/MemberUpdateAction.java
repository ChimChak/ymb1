package test.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.member.dao.MemberDao;
import test.member.dto.MemberDto;
//회원정보를 수정반영하는 액션
public class MemberUpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 수정할 회원의 정보를 읽어온다.
		int num=Integer.parseInt(request.getParameter("num"));
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		//2. DB 에 수정 반영한다.
		MemberDto dto=new MemberDto(num, name, addr);
		MemberDao.getInstance().update(dto);
		//3. view 페이지로 forward 이동해서 응답
		request.setAttribute("msg", num+" 번 회원의 정보를 수정했습니다.");
		request.setAttribute("url", "/member/list.do");
		ActionForward af=new ActionForward("/views/member/alert.jsp");
		return af;
	}

}















