package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;
/*
 *  글 수정 요청 처리하는 액션 
 */
public class CafeUpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 수정할 글정보를 읽어온다.
		int num=Integer.parseInt(request.getParameter("num"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		//2. DB 에 수정반영
		CafeDto dto=new CafeDto();
		dto.setNum(num);
		dto.setTitle(title);
		dto.setContent(content);
		CafeDao.getInstance().update(dto);
		//3. 응답(상세글 보기로 리다일렉트 시키기)
		return new ActionForward("/cafe/detail.do?num="+num, true);
	}

}













