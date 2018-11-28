<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//이메일 읽어오기
	String email=request.getParameter("email");
	//비밀번호 읽어오기
	String pwd=request.getParameter("pwd");
	//성별
	String gender=request.getParameter("gender");
	//취미
	String[] hobby=request.getParameterValues("hobby");
	//좋아하는것
	String like=request.getParameter("like");
	//하고 싶은 말
	String comment=request.getParameter("comment");
	//DB 에 저장하고
	
	//응답한다. 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example3/signup.jsp</title>
</head>
<body>
<p>가입 되었습니다.</p>
</body>
</html>


