<%@page import="test.member.dao.MemberDao"%>
<%@page import="test.member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청 인코딩 설정 (post 방식 인코딩 설정) 한글 깨지지 않도록 
	request.setCharacterEncoding("utf-8");

	//1. 폼 전송되는 파라미터 추출
	int num=Integer.parseInt(request.getParameter("num"));
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
	//2. DB 에 저장
	MemberDto dto=new MemberDto(num, name, addr);
	MemberDao dao=MemberDao.getInstance();
	//isSuccess 에는 작업의 성공 여부가 들어 있다. 
	boolean isSuccess=dao.insert(dto);
	//3. 응답하기 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/insert.jsp</title>
</head>
<body>
<h3>회원 추가 결과 페이지</h3>
<%if(isSuccess){ %>
	<p> <strong><%=name %></strong> 님의 정보를 DB 에 저장했습니다.</p>
	<a href="list.jsp">목록 보기</a>
<%}else{ %>
	<p>회원 정보 추가 실패!</p>
	<a href="insertform.jsp">회원추가 페이지로 다시 가기</a>
<%} %>
</body>
</html>














