<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test6/study.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<%
	request.setAttribute("thisPage", "study");
%>
<jsp:include page="navbar.jsp"/>
<div class="container">
	<h3>study.jsp 페이지 입니다.</h3>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto omnis reiciendis esse minus beatae laborum rerum nostrum dolorum maiores deleniti maxime distinctio provident veritatis explicabo reprehenderit odio in inventore totam.</p>
</div>

</body>
</html>









