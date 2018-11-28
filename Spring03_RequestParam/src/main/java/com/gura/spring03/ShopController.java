package com.gura.spring03;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopController {
	/* 1. 
	 * @RequestMapping("/shop/detail") 
	 * 은 /show/detail.do 요청을 처리 하겠다는 의미
	 * 
	 * 2. 
	 * return type 에 String 은
	 * view 페이지의 정보를 문자열로 리턴하겠다는 의미 
	 * 
	 * 3. 
	 * 메소드명 detail 은 마음대로 지을수 있다. 
	 * 단 요청의 의미에 맞게 지어주면 좋다.
	 * 
	 * 4. 
	 * 메소드에 전달되는 인자 detail() 는 필요한 type 을 명시하면 전달된다.
	 * HttpServletRequest, HttpServletResponse, HttpSession, ModelAndView 등등
	 *  
	 */
	@RequestMapping("/shop/detail")
	public String detail(HttpServletRequest request) {
		// GET 방식 요청 파라미터 추출 
		String num=request.getParameter("num");
		//콘솔창에 테스트로 출력해 보기 
		System.out.println("num:"+num);
		//view 페이지로 forward 이동해서 응답
		return "shop/result";
	}
	/*
	 *  @RequestParam int num 는
	 *  요청 파라미터로 전달되는 num 을 추출해서 int 로 바꿔서 전달 받기 
	 */
	@RequestMapping("/shop/detail2")
	public String detail2(@RequestParam int num) {
		//콘솔창에 테스트로 출력해 보기 
		System.out.println("num:"+num);
		return "shop/result";
	}
	/*
	 *  @RequestParam(defaultValue="기본값")
	 */
	@RequestMapping("/shop/detail3")
	public String detail3(@RequestParam(defaultValue="0") int num) {
		//콘솔창에 테스트로 출력해 보기 
		System.out.println("num:"+num);
		return "shop/result";
	}
	
}































