package com.gura.step04.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step04.member.dao.MemberDao;
import com.gura.step04.member.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao dao;

	@Override
	public void addMember(HttpServletRequest request) {
		//폼전송된 파라미터 추출해서 
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		//DB 에 저장한다. 
		dao.insert(dto);
	}
	@Override
	public void getMemberList(ModelAndView mView) {
		//회원목록을 얻어온다.
		List<MemberDto> list=dao.getList();
		//ModelAndView 객체에 담는다.
		mView.addObject("list", list);
	}
	@Override
	public void deleteMember(int num) {
		//MemberDao 객체를 이용해서 삭제한다. 
		dao.delete(num);
	}
	@Override
	public void getMember(int num, ModelAndView mView) {
		MemberDto dto=dao.getData(num);
		//인자로 전달된 ModelAndView 객체에 회원 한명의 정보를 담는다. 
		mView.addObject("dto", dto);
	}
	@Override
	public void updateMember(MemberDto dto) {
		dao.update(dto);
	}
}










