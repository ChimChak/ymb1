<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test5/main.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<style>
	.header{
		background-color: yellow;
	}
	.footer{
		background-color: #cecece;
	}
</style>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<%
	//request 영역에 담아준다.
	request.setAttribute("thisPage", "home 페이지 입니다.");
%>
<jsp:include page="../include_files/navbar.jsp"/>
<jsp:include page="../include_files/header.jsp"/>
<div class="main">
	<h3>main 컨텐츠 입니다.</h3>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi consequatur quis quos cupiditate sed. Consequuntur ipsa tenetur laboriosam incidunt voluptatem ab tempore blanditiis praesentium itaque consectetur doloremque quam. Sit quidem?</p>
</div>
<jsp:include page="../include_files/footer.jsp"/>
</body>
</html>





