package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeCommentDao;
import test.cafe.dto.CafeCommentDto;
import test.controller.Action;
import test.controller.ActionForward;
/*
 *  댓글을 수정하는 ajax 요청 처리하는 액션 
 */
public class CafeCommentUpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//수정할 댓글 번호
		int num=Integer.parseInt(request.getParameter("num"));
		//수정할 댓글 내용
		String content=request.getParameter("content");
		//DB 에 반영
		CafeCommentDto dto=new CafeCommentDto();
		dto.setNum(num);
		dto.setContent(content);
		boolean isSuccess=CafeCommentDao.getInstance().update(dto);
		//view 페이지로 forward 이동해서 응답
		request.setAttribute("isSuccess", isSuccess);
		return new ActionForward("/views/cafe/comment_update.jsp");
	}

}







