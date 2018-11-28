<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/index.jsp</title>
</head>
<body>
<%
	// session 에 "id" 라는 키값으로 담겨진 문자열을 읽어온다.
	String id=(String)session.getAttribute("id");
%>
<h3>인덱스 페이지 입니다.</h3>
<%if(id != null){ %>
	<p> <a href="users/private/info.jsp"><%=id %></a> 님 로그인중...</p>
	<a href="users/logout.jsp">로그아웃</a>
<%} %>
<ul>
	<li><a href="users/signup_form.jsp">회원가입</a></li>
	<li><a href="users/loginform.jsp?url=${pageContext.request.contextPath}/index.jsp">로그인</a></li>
	<li><a href="market/buy1.jsp">상품 구입하기 1</a></li>
	<li><a href="market/buy2.jsp">상품 구입하기 2</a></li>
	<li><a href="market/buy3.jsp">상품 구입하기 3</a></li>
	<li><a href="feedback">Google reCaptcha 테스트</a></li>
</ul>
</body>
</html>








