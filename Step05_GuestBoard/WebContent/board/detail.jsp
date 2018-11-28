<%@page import="test.board.dao.BoardDao"%>
<%@page import="test.board.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. get 방식 전달되는 글 번호를 읽어온다.
	int num=Integer.parseInt(request.getParameter("num"));
	//2. BoardDao 객체를 이용해서 글번호에 해당되는 글 정보를 얻어온다.
	BoardDto dto=BoardDao.getInstance().getData(num);
	//3. 글정보를 응답한다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/detail.jsp</title>
</head>
<body>
<h3>상세 글 정보 입니다.</h3>
<table>
	<tr>
		<th>글번호</th>
		<td><%=dto.getNum() %></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><%=dto.getWriter() %></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><%=dto.getTitle() %></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea cols="30" rows="5" disabled><%=dto.getContent() %></textarea></td>
	</tr>
	<tr>
		<th>등록일</th>
		<td><%=dto.getRegdate() %></td>
	</tr>
</table>
<a href="updateform.jsp?num=<%=dto.getNum() %>">수정</a>
<a href="javascript:deleteConfirm()">삭제</a>
<script>
	function deleteConfirm(){
		var isDelete=confirm("글을 삭제 하시 겠습니까?");
		if(isDelete){
			location.href="delete.jsp?num=<%=dto.getNum()%>";
		}
	}
</script>
</body>
</html>




















