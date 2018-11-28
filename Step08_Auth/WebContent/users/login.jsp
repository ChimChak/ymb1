<%@page import="test.users.dao.UsersDao"%>
<%@page import="test.users.dto.UsersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 폼 전송되는 파라미터 추출 (아이디, 비밀번호)
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	//2. UsersDao 를 이용해서 유효한 정보인지 판단해서 
	UsersDto dto=new UsersDto();
	dto.setId(id);
	dto.setPwd(pwd);
	boolean isValid=UsersDao.getInstance().isValid(dto);
	//3. 응답한다 (유효한 정보이면 로그인 처리도 해야한다)
	if(isValid){
		//로그인 처리하기
		session.setAttribute("id", id);
	}
	//로그인 성공후 이동해야할 경로
	String url=request.getParameter("url");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/login.jsp</title>
</head>
<body>
<%if(isValid){ %>
	<p><strong><%=id %></strong> 님 로그인 되었심다.</p>
	<a href="<%=url%>">확인</a>
<%}else{ %>
	<p>아이디 혹은 비밀번호가 틀렸심다.</p>
	<a href="loginform.jsp?url=<%=url%>">확인</a>
<%} %>
</body>
</html>










