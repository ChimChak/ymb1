package test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 	비즈니스 로직을 수행할 액션 클래스가 상속받아야할 클래스 정의하기 
 */

//추상 클래스 
public abstract class Action {
	
	//추상 메소드
	public abstract ActionForward execute(HttpServletRequest request,
			HttpServletResponse response);
	
}








