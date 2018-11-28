<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test1/main.jsp</title>
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
<!-- 
	include 디렉티브를 이용해서 jsp 페이지를 포함 시키면 
	포함 시킨 jsp 페이지의 내용과 main.jsp 페이지의 내용을 합쳐서
	하나의 jsp 페이지를 만들어서 동작된다. 
 -->
<%@include file="header.jsp" %>
<div>
	<h3>main 컨텐츠 입니다.</h3>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iusto totam incidunt deleniti nisi. Vel error adipisci blanditiis voluptates recusandae cupiditate assumenda repellat odit! Omnis nisi eos cupiditate repellat magni minima.</p>
</div>
<%@include file="footer.jsp" %>
</body>
</html>














