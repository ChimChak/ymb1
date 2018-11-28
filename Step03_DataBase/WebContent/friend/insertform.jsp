<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/friend/insertform.jsp</title>
</head>
<body>
<h3>친구 추가 폼 입니다.</h3>
<form action="insert.jsp" method="post">
	<label for="num">번호</label>
	<input type="text" name="num" id="num"/>
	<br/>
	<label for="name">이름</label>
	<input type="text" name="name" id="name"/>
	<br/>
	<label for="phone">전화 번호</label>
	<input type="text" name="phone" id="phone"/>
	<br/>
	<button type="submit">저장</button>
	<button type="reset">취소</button>
</form>
</body>
</html>















