package com.gura.spring03;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	/*
	 *  @RequestParam 으로 요청 파라미터를 추출 할때 
	 *  전달된 파라미터가 존재하지 않으면 400 오류를 발생시킨다
	 *  400 오류를 발생 시키지 않으려면 defaultValue 를 설정하는 것이 좋다.
	 */
	@RequestMapping("/member/insert")
	public String insert(@RequestParam int num, 
			@RequestParam String name, @RequestParam String addr) {
		//전달된 파라미터 확인해 보기 
		System.out.println(num+"|"+name+"|"+addr);
		return "shop/result";
	}
	@RequestMapping("/member/insert2")
	public String insert2(@ModelAttribute MemberDto dto) {
		//전달된 파라미터 확인해 보기
		System.out.println(dto.getNum()+"|"+dto.getName()+"|"+dto.getAddr());
		
		return "shop/result";
	}
}















