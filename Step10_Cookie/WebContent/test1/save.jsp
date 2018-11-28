<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test1/save.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	//폼 전송되는 문자열 읽어오기
	String msg=request.getParameter("msg");
	
	//1. 쿠키 객체 생성 new Cookie("key", value)
	// 저장할수 있는 문자의 종류는 64가지(Base64 인코딩)만 가능하다
	// 영문자 대소문자 + 숫자 + 특수문자 일부 
	Cookie cook=new Cookie("savedMsg", msg);
	//2. 최대 유지 시간(초단위)
	cook.setMaxAge(60); //60초
	//3. response 객체에 담으면
	response.addCookie(cook);
	//응답 하는 동안에 웹브라우져에 자동 저장 된다.
%>
<p>웹 브라우저에 "savedMsg" 라는 키값으로 "<%=msg %>" 를 저장했습니다.</p>
<a href="read_cookie.jsp">저장된 쿠키 읽어와 보기</a>
</body>
</html>
















