<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
</head>
<body>
<h3>인덱스 페이지 입니다.</h3>
<ul>
	<li><a href="shop/detail.do?num=1">1번 상품</a></li>
	<li><a href="shop/detail.do?num=2">2번 상품</a></li>
	<li><a href="shop/detail2.do?num=3">3번 상품</a></li>
	<li><a href="shop/detail3.do">기본 상품</a></li>
	<li><a href="shop/detail3.do?num=4">4번 상품</a></li>
</ul>
<form action="member/insert.do" method="post">
	번호<input type="text" name="num"/><br/>
	이름<input type="text" name="name"/><br />
	주소<input type="text" name="addr"/><br/>
	<button type="submit">추가</button>
</form>
<form action="member/insert2.do" method="post">
	번호<input type="text" name="num"/><br/>
	이름<input type="text" name="name"/><br />
	주소<input type="text" name="addr"/><br/>
	<button type="submit">추가</button>
</form>
<h4>공지 사항</h4>
<ul>
	<c:forEach var="tmp" items="${noticeList }">
		<li>${tmp }</li>
	</c:forEach>
</ul>
</body>
</html>





