<%@page import="test.friend.dao.FriendDao"%>
<%@page import="test.friend.dto.FriendDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 수정할 친구의 번호 읽어오기
	int num=Integer.parseInt(request.getParameter("num"));
	//2. FriendDao 객체를 이용해서 수정할 친구의 정보 얻어오기
	FriendDto dto=FriendDao.getInstance().getData(num);
	//3. 수정할 친구의 정보를 form 에 출력해서 응답하기 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/friend/updateform.jsp</title>
</head>
<body>
<h3>친구 정보 수정 form 입니다.</h3>
<form action="update.jsp" method="post">
	<input type="hidden" name="num" value="<%=dto.getNum() %>" />
	<label for="num">번호</label>
	<input type="text" id="num" value="<%=dto.getNum()%>"  disabled/>
	<br/>
	<label for="name">이름</label>
	<input type="text" name="name" id="name" value="<%=dto.getName() %>" />
	<br/>
	<label for="addr">전화 번호</label>
	<input type="text" name="phone" id="phone" value="<%=dto.getPhone() %>"/>
	<br/>
	<button type="submit">수정 확인</button>
</form>
</body>
</html>













