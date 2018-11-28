<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example3/test.jsp</title>
</head>
<body>
<h3>회원 가입 폼 입니다.</h3>
<form action="signup.jsp" method="post">
	<label for="email">이메일</label>
	<input type="text" name="email" id="email"/>
	<br/>
	<label for="pwd">비밀번호</label>
	<input type="password" name="pwd" id="pwd"/>
	<br/>
	<fieldset>
		<legend>성별 선택</legend>
		<label><input type="radio" name="gender" value="man" checked/>남자</label>
		<label><input type="radio" name="gender" value="woman"/>여자</label>		
	</fieldset>
	<fieldset>
		<legend>취미 선택</legend>
		<label><input type="checkbox" name="hobby" value="piano"/>피아노</label>
		<label><input type="checkbox" name="hobby" value="game"/>게임</label>
		<label><input type="checkbox" name="hobby" value="movie"/>영화</label>
		<label><input type="checkbox" name="hobby" value="etc"/>기타</label>
	</fieldset>
	<label for="like">좋아하는 것 선택</label>
	<select name="like" id="like">
		<option>선택</option>
		<option value="java">자바</option>
		<option value="python">파이선</option>
		<option value="android">안드로이드</option>
		<option value="ios">아이폰</option>
	</select>
	<br/>
	<label for="comment">하고 싶은말</label>
	<br/>
	<textarea name="comment" id="comment" cols="30" rows="10"></textarea>
	<br/>
	<button type="submit">가입</button>
</form>
</body>
</html>









