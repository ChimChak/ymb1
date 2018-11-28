package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeCommentDao;
import test.cafe.dto.CafeCommentDto;
import test.controller.Action;
import test.controller.ActionForward;
/*
 *  댓글을 추가 하는 액션
 */
public class CafeCommentInsertAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//댓글 작성자
		String writer=(String)request.getSession().getAttribute("id");
		//댓글의 그룹번호
		int ref_group=Integer.parseInt(request.getParameter("ref_group"));
		//댓글의 대상자 아이디
		String target_id=request.getParameter("target_id");
		//댓글의 내용
		String content=request.getParameter("content");
		//댓글 내에서의 그룹번호 (null 이면 원글의 댓글이다)
		String comment_group=request.getParameter("comment_group");
		//저장할 댓글의 primary key 값을 미리 얻어낸다. 
		int seq=CafeCommentDao.getInstance().getSequence();
		//댓글 정보를 CafeCommentDto 객체에 담는다.
		CafeCommentDto dto=new CafeCommentDto();
		dto.setNum(seq);
		dto.setWriter(writer);
		dto.setTarget_id(target_id);
		dto.setRef_group(ref_group);
		dto.setContent(content);
		if(comment_group == null) { //원글의 댓글인경우
			//댓글의 글번호가 댓글 내에서의 그룹번호가 된다. 
			dto.setComment_group(seq);
		}else {//댓글의 댓글인 경우 
			//전달된 comment_group 번호를 새로 추가될 댓글의 그룹번호로 부여한다.
			dto.setComment_group(Integer.parseInt(comment_group));
		}
		//댓글 정보를 DB 에 저장한다.
		CafeCommentDao.getInstance().insert(dto);
		//원글 자세히 보기로 리다일렉트 시킨다 
		return new ActionForward("/cafe/detail.do?num="+ref_group, true);
	}

}







