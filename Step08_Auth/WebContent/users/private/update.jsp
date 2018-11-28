<%@page import="test.users.dao.UsersDao"%>
<%@page import="test.users.dto.UsersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 폼전송되는 파라미터 읽어오기
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	String email=request.getParameter("email");
	//2. DB 에 수정 반영
	UsersDto dto=new UsersDto();
	dto.setId(id);
	dto.setPwd(pwd);
	dto.setEmail(email);
	boolean isSuccess=UsersDao.getInstance().update(dto);
	//3. 응답
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/private/update.jsp</title>
</head>
<body>
<%if(isSuccess){ %>
	<p> <strong><%=id %></strong> 회원님 정보를 수정했습니다.</p>
	<a href="info.jsp">확인</a>
<%}else{ %>
	<p>회원정보 수정실패</p>
	<a href="updateform.jsp">확인</a>
<%} %>
</body>
</html>
















