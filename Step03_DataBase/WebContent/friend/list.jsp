
<%@page import="test.friend.dao.FriendDao"%>
<%@page import="test.friend.dto.FriendDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//MemberDao 객체를 이용해서 회원 목록 불러오기
	List<FriendDto> list=FriendDao.getInstance().getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/frined/list.jsp</title>
</head>
<body>
<a href="insertform.jsp">친구 추가</a>
<h3>친구 목록 입니다.</h3>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화 번호</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
	<%for(FriendDto tmp:list){ %>
		<tr>
			<td><%=tmp.getNum() %></td>
			<td><%=tmp.getName() %></td>
			<td><%=tmp.getPhone() %></td>
			<td><a href="updateform.jsp?num=<%=tmp.getNum() %>">수정</a></td>
			<td><a href="javascript:deleteConfirm(<%=tmp.getNum()%>)">삭제</a></td>
		</tr>
	<%} %>
	</tbody>
</table>
<script>
	function deleteConfirm(num){
		var isDelete=confirm(num+"번 친구를 삭제 하시겠습니까?");
		if(isDelete){
			location.href="delete.jsp?num="+num;
		}
	}
</script>
</body>
</html>
















