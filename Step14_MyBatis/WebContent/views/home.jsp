<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
</head>
<body>
<c:if test="${not empty id }">
	<strong><a href="users/private/info.do">${id }</a></strong> 님 로그인중...
	<a href="users/logout.do">로그아웃</a>
</c:if>
<h3>인덱스(home) 페이지 입니다.</h3>
<ul>
	<li><a href="member/list.do">회원 목록 보기</a></li>
	<li><a href="users/loginform.do">로그인</a></li>
	<li><a href="users/signup_form.do">회원가입</a></li>
	<li><a href="cafe/list.do">카페 글 목록 보기</a></li>
	<li><a href="file/list.do">자료실 목록 보기</a></li>
</ul>
<h4>오늘의 공지 사항</h4>
<ul>
	<c:forEach items="${noticeList }" var="tmp">
		<li>${tmp }</li>
	</c:forEach>
</ul>
</body>
</html>
















