<%@page import="test.board.dao.BoardDao"%>
<%@page import="test.board.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. BoardDao 객체를 이용해서 방명록 목록을 얻어온다.
	List<BoardDto> list=BoardDao.getInstance().getList();
	// 2. 응답하기 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/list.jsp</title>
</head>
<body>
<a href="insertform.jsp">새 방명록 작성</a>
<h3>방명록 목록입니다.</h3>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>등록일</th>
		</tr>
	</thead>
	<tbody>
	<%for(BoardDto tmp:list){ %>
		<tr>
			<td><%=tmp.getNum() %></td>
			<td><%=tmp.getWriter() %></td>
			<td><a href="detail.jsp?num=<%=tmp.getNum() %>"><%=tmp.getTitle() %></a></td>
			<td><%=tmp.getRegdate() %></td>
		</tr>
	<%} %>	
	</tbody>
</table>
</body>
</html>








