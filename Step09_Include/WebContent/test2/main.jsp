<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test2/main.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<%
	//request 영역에 담아준다.
	request.setAttribute("thisPage", "home 페이지 입니다.");
%>
<%@include file="navbar.jsp" %>
<div class="main">
	<h3>메인 컨텐츠 입니다.</h3>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Odio rem nostrum aliquam dolorum alias incidunt ipsam repellat vel a nisi omnis fugit iste deserunt animi iusto! Placeat illo maxime aperiam.</p>
</div>
</body>
</html>

























