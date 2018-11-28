<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// ajax 요청으로 전송된 파라미터 추출
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	boolean isValid=false;
	if(id.equals("gura") && pwd.equals("1234")){
		isValid=true;
	}
%>
{"isValid":<%=isValid %>}



