<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//폼 전송되는 쿠키의 이름과 쿠키값을 읽어온다.
	String name=request.getParameter("name");
	String value=request.getParameter("value");
	//해당 정보로 쿠키 객체를 생성한다.
	Cookie cook=new Cookie(name, value);
	cook.setMaxAge(60);
	//응답 객체에 담는다.
	response.addCookie(cook);
	//리다일렉트 응답
	String cPath=request.getContextPath();
	response.sendRedirect(cPath+"/test2/cookie_form.jsp");
%>







