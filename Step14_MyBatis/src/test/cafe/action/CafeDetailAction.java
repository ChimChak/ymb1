package test.cafe.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeCommentDao;
import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeCommentDto;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeDetailAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//글번호
		int num=Integer.parseInt(request.getParameter("num"));
		//검색과 관련된 파라미터를 읽어와 본다.
		String keyword=request.getParameter("keyword");
		String condition=request.getParameter("condition");
		//검색과 관련된 정보를 CafeDto 객체에 선택적으로 담는다.
		CafeDto dto=new CafeDto();
		if(keyword != null) {//검색 키워드가 전달된 경우
			if(condition.equals("titlecontent")) {//제목+내용 검색
				dto.setTitle(keyword);
				dto.setContent(keyword);
			}else if(condition.equals("title")) {//제목 검색
				dto.setTitle(keyword);
			}else if(condition.equals("writer")) {//작성자 검색
				dto.setWriter(keyword);
			}
			//request 에 검색 조건과 키워드 담기
			request.setAttribute("condition", condition);
			/*
			 *  검색 키워드에는 한글이 포함될 가능성이 있기 때문에
			 *  링크에 그대로 출력가능하도록 하기 위해 미리 인코딩을 해서
			 *  request 에 담아준다.
			 */
			String encodedKeyword=null;
			try {
				encodedKeyword=URLEncoder.encode(keyword, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			//인코딩된 키워드와 인코딩 안된 키워드를 모두 담는다.
			request.setAttribute("encodedKeyword", encodedKeyword);
			request.setAttribute("keyword", keyword);
		}		
		//CafeDto 에 글번호도 담기
		dto.setNum(num);
		
		//글정보 얻어오기
		//CafeDto 객체를 getData() 의 인자로 전달해서 글정보를 얻어온다. 
		CafeDto resultDto=CafeDao.getInstance().getData(dto);
		//글 조회수 올리기
		CafeDao.getInstance().addViewCount(num);
		//request 에 글정보를 담고
		request.setAttribute("dto", resultDto);
		//댓글 목록을 얻어온다. (자세히 보기할 글번호가 댓글의 ref_group 번호)
		List<CafeCommentDto> commentList=
				CafeCommentDao.getInstance().getList(num);
		//request 에 댓글 목록을 담는다.
		request.setAttribute("commentList", commentList);
		//view 페이지로 forward 이동해서 응답
		return new ActionForward("/views/cafe/detail.jsp");
	}

}













