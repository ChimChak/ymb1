package com.gura.step04.member.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.step04.member.dto.MemberDto;

public interface MemberService {
	//회원 정보 추가 
	public void addMember(HttpServletRequest request);
	//회원 목록 불러오기
	public void getMemberList(ModelAndView mView);
	//회원 정보 삭제
	public void deleteMember(int num);
	//회원 한명의 정보 불러오기
	public void getMember(int num, ModelAndView mView);
	//회원 한명의 정보 수정하기
	public void updateMember(MemberDto dto);
}
