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
<h3>인덱스(home) 페이지 입니다.</h3>
<ul>
	<li><a href="member/list.do">회원 목록 보기</a></li>
</ul>
<h4>오늘의 공지 사항</h4>
<ul>
	<c:forEach items="${noticeList }" var="tmp">
		<li>${tmp }</li>
	</c:forEach>
</ul>
</body>
</html>
















