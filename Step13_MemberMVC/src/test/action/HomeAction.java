package test.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
// 인덱스 페이지를 출력하는 액션 
public class HomeAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 공지 사항을 DB 에서 불러오는 비즈니스 로직 수행
		List<String> noticeList=new ArrayList<>();
		noticeList.add("미세 먼지를 주의 하세요");
		noticeList.add("오늘은 불금 입니다.");
		noticeList.add("어쩌구...");
		noticeList.add("저쩌구...");
		//2. Model 을 request 에 담고
		request.setAttribute("noticeList", noticeList);
		//3. view 페이지로 forward 이동
		
		return new ActionForward("/views/home.jsp");
	}

}






