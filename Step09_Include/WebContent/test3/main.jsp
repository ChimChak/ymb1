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
<%--
	jsp:include 를 이용하면 독립적인 jsp 페이지가 만들어지고
	여러개의 jsp 페이지가 공동으로 클라이언트에게 응답하는 구조가 된다.
	(서버가 해석하지 않는 주석 즉, jsp 페이지가 무시하는 주석 )
 --%>
<jsp:include page="header.jsp"/>
<div>
	<h3>main 컨텐츠 입니다.</h3>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iusto totam incidunt deleniti nisi. Vel error adipisci blanditiis voluptates recusandae cupiditate assumenda repellat odit! Omnis nisi eos cupiditate repellat magni minima.</p>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>














