<%@page import="test.member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/detail.jsp</title>
</head>
<body>
<h3>회원 정보 자세히 보기 페이지</h3>
<%
	// request 에 담긴 Model 얻어오기 
	MemberDto dto=(MemberDto)request.getAttribute("dto");
%>
<p>번호: <strong><%=dto.getNum() %></strong></p>
<p>이름: <strong><%=dto.getName() %></strong></p>
<p>주소: <strong><%=dto.getAddr() %></strong></p>
<h3>el 을 활용하면</h3>
<p>번호: <strong>${dto.getNum() }</strong></p>
<p>이름: <strong>${dto.getName() }</strong></p>
<p>주소: <strong>${dto.addr }</strong></p>
</body>
</html>








