<%@page import="test.users.dao.UsersDao"%>
<%@page import="test.users.dto.UsersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. form 전송되는 파라미터 추출 
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	String email=request.getParameter("email");
	//2. UsersDao 를 이용해서 DB 에 저장
	UsersDto dto=new UsersDto();
	dto.setId(id);
	dto.setPwd(pwd);
	dto.setEmail(email);
	boolean isSuccess=UsersDao.getInstance().insert(dto);
	//3. 응답하기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/signup.jsp</title>
</head>
<body>
<h3>회원 가입 요청 결과 페이지</h3>
<%if(isSuccess){ %>
	<p><strong><%=id %></strong> 님 가입 되었습니다.</p>
	<a href="loginform.jsp">로그인 하기</a>
<%}else{ %>
	<p>가입 실패!</p>
	<a href="signup_form.jsp">다시 가입하러 가기</a>
<%} %>
</body>
</html>

















