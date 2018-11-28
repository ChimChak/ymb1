<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test6/popup_page.jsp</title>
<style>
	body{
		background-color: yellow;
	}
</style>
</head>
<body>
<h3>팝업된 페이지 입니다.</h3>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quos fugit ducimus quidem neque veritatis tempora facere inventore pariatur aspernatur doloribus odit ut officiis eveniet aliquam dolor earum dolorem voluptas praesentium?</p>
<a href="javascript:self.close();">닫기</a>
<input type="text" id="inputMsg" placeholder="메세지 입력"/>
<button id="sendBtn">전송</button>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script>
	$("#sendBtn").click(function(){
		var msg=$("#inputMsg").val();
		//부모창에 문자열 전달 
		window.opener.getData(msg);
		//창닫기
		self.close();
	});
</script>
</body>
</html>














