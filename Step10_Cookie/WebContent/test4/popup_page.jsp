<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test4/popup_page.jsp</title>
<style>
	body{
		background-color: yellow;
	}
</style>
</head>
<body>
<h3>겨울 맞이 파격 세일</h3>
<p>아이다스 패딩 99,000 원</p>
<p>전기 장판 30,000원</p>
<form action="save.jsp" method="post">
	<label>
		<input type="checkbox" name="canPopup" value="no"/>
		1 분동안 팝업 띄우지 않기
	</label>
	<button type="submit">닫기</button>
</form>
</body>
</html>









