<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 이 페이지가 어디에 include 되는지에 대한 정보를 읽어온다.
	String thisPage=(String)request.getAttribute("thisPage");	
%> 
<%if(thisPage.equals("home")){ %>
	<div class="navbar navbar-inverse">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">index</a>
		<ul class="nav navbar-nav">
			<li class="active"><a href="home.jsp">home</a></li>
			<li><a href="game.jsp">game</a></li>
			<li><a href="study.jsp">study</a></li>
		</ul>
	</div>
<%}else if(thisPage.equals("game")){ %>
	<div class="navbar navbar-inverse">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">index</a>
		<ul class="nav navbar-nav">
			<li><a href="home.jsp">home</a></li>
			<li class="active"><a href="game.jsp">game</a></li>
			<li><a href="study.jsp">study</a></li>
		</ul>
	</div>
<%}else if(thisPage.equals("study")){ %>
	<div class="navbar navbar-inverse">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">index</a>
		<ul class="nav navbar-nav">
			<li><a href="home.jsp">home</a></li>
			<li><a href="game.jsp">game</a></li>
			<li class="active"><a href="study.jsp">study</a></li>
		</ul>
	</div>
<%} %>   

