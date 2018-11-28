package test.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MemberInsertAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//폼 전송되는 파라미터 추출
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		//DB 에 저장
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		MemberDao.getInstance().insert(dto);
		// /member/list.do 경로로 리다일렉트 이동 하도록 한다. 
		ActionForward af=new ActionForward("/member/list.do");
		af.setRedirect(true);
		return af;
	}

}







