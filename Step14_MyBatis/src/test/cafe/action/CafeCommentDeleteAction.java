package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeCommentDao;
import test.controller.Action;
import test.controller.ActionForward;
/*
 *  ajax 요청 파라미터를 받아서 해당 댓글 삭제 처리를 하는 액션
 */
public class CafeCommentDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//삭제할 댓글번호 읽어오기 
		int num=Integer.parseInt(request.getParameter("num"));
		boolean isSuccess=CafeCommentDao.getInstance().delete(num);
		request.setAttribute("isSuccess", isSuccess);
		return new ActionForward("/views/cafe/comment_delete.jsp");
	}

}








