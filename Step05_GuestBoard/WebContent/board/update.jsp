<%@page import="test.board.dao.BoardDao"%>
<%@page import="test.board.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	//1. 폼전송되는 수정할 글정보를 읽어온다.
	int num=Integer.parseInt(request.getParameter("num"));
	String writer=request.getParameter("writer");
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	//2. DB 에 수정 반영한다.
	BoardDto dto=new BoardDto();
	dto.setNum(num);
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);
	BoardDao.getInstance().update(dto);
	//3. 응답한다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/update.jsp</title>
</head>
<body>
<p> <%=num %> 번 글을 수정 했습니다.</p>
<a href="list.jsp">글 목록 보기</a>
</body>
</html>





