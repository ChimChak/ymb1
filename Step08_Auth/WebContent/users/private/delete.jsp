<%@page import="test.users.dao.UsersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 세션에 저장된 아이디를 읽어온다.
	String id=(String)session.getAttribute("id");
	//2. DB 에서 삭제하고
	UsersDao.getInstance().delete(id);
	//3. 세션에서 삭제(로그아웃 처리)
	session.invalidate();
	//4. 응답
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/private/delete.jsp</title>
</head>
<body>
<p> <strong><%=id %></strong> 회원님 탈퇴 처리 되었습니다.</p>
<a href="${pageContext.request.contextPath}/">확인</a>
</body>
</html>











