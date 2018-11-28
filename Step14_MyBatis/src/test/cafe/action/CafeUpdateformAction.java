package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeUpdateformAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 수정할 글번호를 읽어온다.
		int num=Integer.parseInt(request.getParameter("num"));
		//2. 수정할 글의 정보를 얻어온다.
		CafeDto dto=CafeDao.getInstance().getData(num);
		//3. 수정할 글정보를 request 에 담고
		request.setAttribute("dto", dto);
		//4. view 페이지로 forward 이동해서 글 수정폼 응답
		return new ActionForward("/views/cafe/updateform.jsp");
	}

}








