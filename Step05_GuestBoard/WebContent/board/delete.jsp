<%@page import="test.board.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 삭제할 글번호 읽어오기
	int num=Integer.parseInt(request.getParameter("num"));
	//2. BoardDao 객체를 이용해서 DB 에서 삭제
	boolean isSuccess=BoardDao.getInstance().delete(num);
	//3. 응답 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/delete.jsp</title>
</head>
<body>
<%if(isSuccess){ %>
	<script>
		alert("삭제 했습니다.");
		location.href="list.jsp";
	</script>
<%}else{ %>
	<script>
		alert("삭제 실패!");
		location.href="list.jsp";
	</script>
<%} %>
</body>
</html>














