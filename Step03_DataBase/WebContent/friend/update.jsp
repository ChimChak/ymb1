<%@page import="test.friend.dao.FriendDao"%>
<%@page import="test.friend.dto.FriendDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 한글 깨지지 않도록
	request.setCharacterEncoding("utf-8");
	// 1. 폼전송된 수정할 친구의 정보를 읽어와서 
	int num=Integer.parseInt(request.getParameter("num"));
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	// 2. FrinedDao 객체를 이용해서 DB 에 수정 반영하고
	FriendDto dto=new FriendDto(num, name, phone);
	boolean isSuccess=FriendDao.getInstance().update(dto);
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
		alert("<%=num%> 번 친구의 정보를 수정 했슴다");
		location.href="list.jsp";
	</script>
<%}else{ %>
	<script>
		alert("친구 정보 수정 실패!");
		location.href="list.jsp";
	</script>
<%} %>
</body>
</html>







