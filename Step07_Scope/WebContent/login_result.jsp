<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/login_result.jsp</title>
</head>
<body>
<h3>로그인 결과 페이지</h3>
<%
	
	String id=(String)session.getAttribute("id");
%>
<p><strong><%=id %></strong> 님 로그인중...</p>
<p><strong>${id }</strong> 님 로그인중...</p>
</body>
</html>











