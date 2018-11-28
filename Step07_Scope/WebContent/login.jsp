<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("id", "monkey");
	String cPath=request.getContextPath();
	response.sendRedirect(cPath+"/login_result.jsp");
%>










