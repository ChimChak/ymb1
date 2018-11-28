<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("game.jsp 페이지 입니다.");
	System.out.println("게임은 무슨 게임이야 공부나 해~");
	
	//특정 경로로 요청을 다시 하라고 응답하기
	
	// 컨텍스트 경로 읽어오기
	String cPath=request.getContextPath();
	// 요청을 다시 하라고 응답하기 
	response.sendRedirect(cPath+"/study.jsp");
%>
