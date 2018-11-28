package test.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.member.dao.MemberDao;
import test.member.dto.MemberDto;
// 회원 수정폼을 응답하는 액션 
public class MemberUpdateformAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) {
		//1. 수정할 회원의 번호를 읽어온다.
		int num=Integer.parseInt(request.getParameter("num"));
		//2. DB 에서 수정할 회원의 정보를 읽어온다.
		MemberDto dto=MemberDao.getInstance().getData(num);
		//3. request 에 담는다.
		request.setAttribute("dto", dto);
		//4. view 페이지로 forward 이동해서 폼을 출력한다.
		ActionForward af=new ActionForward("/views/member/updateform.jsp");
		return af;
	}

}







