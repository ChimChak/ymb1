<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 전달된 파라미터 추출 
	String num=request.getParameter("num");
	// DB 에서 num 에 해당되는 글 내용을 불러와서 
	String content="어쩌구... 저쩌구...";
	//응답해 준다. 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 자세히 보기 페이지</title>
</head>
<body>
<p> <%=num%> 번글 : <%=content%> </p>
</body>
</html>


















