<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String thisPage=(String)request.getAttribute("thisPage");
%>    
<div class="navbar navbar-inverse">
	<a class="navbar-brand" href="#">acorn</a>
	<p class="navbar-text"><%=thisPage %></p>
</div>