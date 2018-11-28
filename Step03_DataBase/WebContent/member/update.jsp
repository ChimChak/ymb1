<%@page import="test.member.dao.MemberDao"%>
<%@page import="test.member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 한글 깨지지 않도록
	request.setCharacterEncoding("utf-8");
	// 1. 폼전송된 수정할 회원의 정보를 읽어와서 
	int num=Integer.parseInt(request.getParameter("num"));
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
	// 2. MemberDao 객체를 이용해서 DB 에 수정 반영하고
	MemberDto dto=new MemberDto(num, name, addr);
	boolean isSuccess=MemberDao.getInstance().update(dto);
	// 3. 응답하기 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/update.jsp</title>
</head>
<body>
<%if(isSuccess){ %>
	<script>
		alert("<%=num%> 번 회원의 정보를 수정 했슴다");
		location.href="list.jsp";
	</script>
<%}else{ %>
	<script>
		alert("회원 정보 수정 실패!");
		location.href="list.jsp";
	</script>
<%} %>
</body>
</html>







