<%@page import="test.users.dao.UsersDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. ajax 요청 파라미터 추출
	String inputId=request.getParameter("inputId");
	//2. 사용 가능 여부를 UsersDao 로 부터 리턴 받는다.
	boolean canUse=UsersDao.getInstance().canUseId(inputId);
	//3. 사용 가능 여부를 json 형식으로 응답한다.
%>
{"canUse":<%=canUse %>}