<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/logout.jsp</title>
</head>
<body>
<%
	//세션에서 id 라는 키값으로 저장된 값 삭제하기
	//session.removeAttribute("id");
	//세션 초기화
	session.invalidate();
%>
<script>
	alert("로그아웃 되었습니다.");
	location.href="${pageContext.request.contextPath}/";
</script>
</body>
</html>









