package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeInsertAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//새글 정보를 추출해서 CafeDto 객체에 담아서 
		String writer=(String)request.getSession().getAttribute("id");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		CafeDto dto=new CafeDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		//DB 에 저장한다.
		CafeDao.getInstance().insert(dto);
		//글 목록보기로 리다일렉트 응답
		return new ActionForward("/cafe/list.do", true);
	}

}






