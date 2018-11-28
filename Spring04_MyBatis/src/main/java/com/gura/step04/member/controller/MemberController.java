package com.gura.step04.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step04.member.dto.MemberDto;
import com.gura.step04.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	//회원 정보 수정 요청 처리
	@RequestMapping("/member/update")
	public String update(@ModelAttribute MemberDto dto) {
		//폼전송된 파라미터가 추출되어서 MemberDto 객체에 담겨서 전달된다.
		service.updateMember(dto);
		return "redirect:/member/list.do";
	}
	
	//회원정보 수정폼 요청처리
	@RequestMapping(value="/member/updateform", method=RequestMethod.GET)
	public ModelAndView updateform(@RequestParam int num) {
		ModelAndView mView=new ModelAndView();
		service.getMember(num, mView);
		//ModelAndView 객체에 view 페이지의 정보를 담아서 
		mView.setViewName("member/updateform");
		return mView; //리턴한다. 
	}
	
	//회원 삭제 요청 처리
	@RequestMapping(value="/member/delete", method=RequestMethod.GET)
	public String delete(@RequestParam int num) {
		//MemberService 객체를 이용해서 회원정보를 삭제하는 작업을 한다. 
		service.deleteMember(num);
		return "redirect:/member/list.do";
	}
	
	//회원 추가 폼 요청 처리
	@RequestMapping("/member/insertform")
	public String insertform() {
		//처리할 비즈니스 로직은 없다
		return "member/insertform";
	}
	
	@RequestMapping("/member/insert")
	public String insert(HttpServletRequest request) {
		//MemberService 객체를 이용해서 회원 정보를 추가하고 
		service.addMember(request);
		//회원 목록 보기로 리다일렉트 응답하기 
		return "redirect:/member/list.do";
	}
	@RequestMapping("/member/list")
	public ModelAndView getList() {
		//서비스에 전달할 ModelAndView 객체를 생성해서 
		ModelAndView mView=new ModelAndView();
		//서비스 객체에 전달하고 (회원목록이 ModelAndView 객체에 담긴다)
		service.getMemberList(mView);
		//ModelAndVie 객체에 view 페이지 정보를 담고 
		mView.setViewName("member/list");
		//리턴해 준다. 
		return mView;
	}
}































