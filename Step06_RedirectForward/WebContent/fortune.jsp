<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/fortune.jsp</title>
</head>
<body>
<h3>오늘의 운세 페이지</h3>
<%
	//request 에 담긴 String type 얻어내기
	String fortuneToday=(String)request.getAttribute("fortuneToday");
%>
<p> 오늘의 운세 : <strong><%=fortuneToday %></strong></p>
<p> 오늘의 운세 : <strong>${fortuneToday }</strong></p>
</body>
</html>










