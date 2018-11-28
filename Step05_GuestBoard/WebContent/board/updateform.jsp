<%@page import="test.board.dao.BoardDao"%>
<%@page import="test.board.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 파라미터로 전달되는 수정할 글번호를 읽어온다.
	int num=Integer.parseInt(request.getParameter("num"));
	//2. 해당글의 정보를 BoardDao 객체를 이용해서 얻어온다.
	BoardDto dto=BoardDao.getInstance().getData(num);
	//3. 글 수정 폼을 응답한다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/updateform.jsp</title>
</head>
<body>
<h3>글 수정 폼입니다.</h3>
<form action="update.jsp" method="post">
	<input type="hidden" name="num" value="<%=dto.getNum() %>" />
	<label for="num">글번호</label>
	<input type="text" id="num" value="<%=dto.getNum() %>" disabled/>
	<br/>
	<label for="writer">작성자</label>
	<input type="text" name="writer" id="writer" value="<%=dto.getWriter()%>"/>
	<br/>
	<label for="title">제목</label>
	<input type="text" name="title" id="title" value="<%=dto.getTitle()%>"/>
	<br/>
	<label for="content">내용</label>
	<br/>
	<textarea name="content" id="content" cols="30" rows="5"><%=dto.getContent() %></textarea>
	<br/>
	<button type="submit">수정확인</button>
</form>
</body>
</html>
























