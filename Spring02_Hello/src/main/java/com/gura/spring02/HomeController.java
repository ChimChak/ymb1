package com.gura.spring02;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	// home.do 요청을 처리할 메소드
	@RequestMapping("/home")
	public String home(HttpServletRequest request) {
		
		// WEB-INF/views/home.jsp 페이지로 forward 이동 
		return "home";
	}
}











