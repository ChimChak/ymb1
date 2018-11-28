<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="header">
	<h3>header 입니다.</h3>
	<p>어쩌구 ... 저쩌구...</p>
	<button id="myBtn">눌러보셈</button>
</div>
<script>
	$("#myBtn").click(function(){
		alert("버튼을 눌렀네요?");
	});
</script>
