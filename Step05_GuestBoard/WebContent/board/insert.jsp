<%@page import="test.board.dao.BoardDao"%>
<%@page import="test.board.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글 깨지지 않도록
	request.setCharacterEncoding("utf-8");

	//1. 폼 전송되는 글 내용을 읽어온다.
	String writer=request.getParameter("writer");
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	//2. DB 에 저장한다.
	//BoardDto 객체를 생성해서 글정보를 담는다. 
	BoardDto dto=new BoardDto();
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);
	//BoardDao 객체를 이용해서 글정보 저장 
	boolean isSuccess=BoardDao.getInstance().insert(dto);
	//3. 응답한다
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/insert.jsp</title>
</head>
<body>
<%if(isSuccess){ %>
	<p> <strong><%=writer %></strong> 님이 작성한 글을 저장했습니다.</p>
	<a href="list.jsp">글 목록 보기</a>
<%}else{ %>
	<p> 글 저장 실패</p>
	<a href="insertform.jsp">다시 작성하기</a>
<%} %>
</body>
</html>










