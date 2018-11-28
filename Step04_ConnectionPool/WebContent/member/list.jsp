<%@page import="test.member.dao.MemberDao"%>
<%@page import="test.member.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//MemberDao 객체를 이용해서 회원 목록 불러오기
	List<MemberDto> list=MemberDao.getInstance().getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/list.jsp</title>
</head>
<body>
<a href="insertform.jsp">회원 추가</a>
<h3>회원 목록 입니다.</h3>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
	<%for(MemberDto tmp:list){ %>
		<tr>
			<td><%=tmp.getNum() %></td>
			<td><%=tmp.getName() %></td>
			<td><%=tmp.getAddr() %></td>
			<td><a href="updateform.jsp?num=<%=tmp.getNum() %>">수정</a></td>
			<td><a href="javascript:deleteConfirm(<%=tmp.getNum()%>)">삭제</a></td>
		</tr>
	<%} %>
	</tbody>
</table>
<script>
	function deleteConfirm(num){
		var isDelete=confirm(num+"번 글을 삭제 하시겠습니까?");
		if(isDelete){
			location.href="delete.jsp?num="+num;
		}
	}
</script>
</body>
</html>
















