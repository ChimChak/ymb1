<%@page import="test.friend.dao.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 파라미터로 전달되는 삭제할 친구의 번호 읽어오기
	int num=Integer.parseInt(request.getParameter("num"));
	// 2. FriendDao 객체를 이용해서 해당 친구의 정보 삭제
	boolean isSuccess=FriendDao.getInstance().delete(num);
	// 3. 응답하기 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/friend/delete.jsp</title>
</head>
<body>
<%if(isSuccess){%>
	<p> <strong><%=num %></strong> 번 친구의 정보를 삭제 했습니다.</p>	
	<a href="list.jsp">확인</a>
<%}else{%>
	<p> 친구 정보 삭제 실패! </p>
	<a href="list.jsp">확인</a>
<%}%>
</body>
</html>













