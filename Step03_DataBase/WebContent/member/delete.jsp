<%@page import="test.member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 파라미터로 전달되는 삭제할 회원의 번호 읽어오기
	int num=Integer.parseInt(request.getParameter("num"));
	// 2. MemberDao 객체를 이용해서 해당 회원의 정보 삭제
	boolean isSuccess=MemberDao.getInstance().delete(num);
	// 3. 응답하기 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/delete.jsp</title>
</head>
<body>
<%if(isSuccess){%>
	<p> <strong><%=num %></strong> 번 회원의 정보를 삭제 했습니다.</p>	
	<a href="list.jsp">확인</a>
<%}else{%>
	<p> 회원 정보 삭제 실패! </p>
	<a href="list.jsp">확인</a>
<%}%>
</body>
</html>













