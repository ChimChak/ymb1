<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//post 방식 전송 파라미터 추출
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	//DB 에서 아이디 비빌번호가 유효한 정보인지 확인 한다.
	boolean isValid=false;//로그인 성공 여부 
	if(id.equals("gura") && pwd.equals("1234")){
		isValid=true;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example2/login.jsp</title>
</head>
<body>
<%if(isValid){ %>
	<p>로그인 되었습니다.</p>
<%}else{ %>
	<p>아이디 혹은 비밀번호가 틀려요</p>
<%} %>
</body>
</html>












