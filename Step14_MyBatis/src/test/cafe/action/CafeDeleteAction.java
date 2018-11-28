package test.cafe.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
/*
 *  글 삭제 요청 처리를 하는 액션
 */
public class CafeDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 삭제할 글번호를 읽어온다.
		int num=Integer.parseInt(request.getParameter("num"));
		
		//삭제할 글이 로그인된 사용자의 글인지 확인
		String id=(String)request.getSession().getAttribute("id");
		CafeDto dto=CafeDao.getInstance().getData(num);
		if(!id.equals(dto.getWriter())) {//글의 작성자와 로그인된 id 가 다르면
			//삭제하면 안된다. 
			return null;
		}
		
		//2. DB 에서 삭제한다.
		CafeDao.getInstance().delete(num);
		//3. 글 목록보기로 다시 리다일렉트 시킨다. 
		return new ActionForward("/cafe/list.do", true);
	}

}













