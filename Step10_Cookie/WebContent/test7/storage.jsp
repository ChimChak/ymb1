<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test7/storage.jsp</title>
</head>
<body>
<input type="text" id="inputMsg" placeholder="저장할 문자열 입력..."/>
<button id="saveBtn">저장</button>
<button id="loadBtn">불러오기</button>
<button id="deleteBtn">삭제하기</button>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script>


	$("#saveBtn").click(function(){
		//서버와 상관 없이 client side 에서 문자열을 localStorage 에 저장할수 있다.
		localStorage.msg = $("#inputMsg").val();
		alert("저장 했습니다.");
	});
	
	$("#loadBtn").click(function(){
		//localStorage 에 저장된 내용을 input 요소에 넣어주기 
		$("#inputMsg").val(localStorage.msg);
	});
	
	$("#deleteBtn").click(function(){
		//delete 예약어를 이용해서 특정방을 참조하면 삭제된다. 
		delete localStorage.msg;
		alert("삭제 했습니다.");
	});
</script>
</body>
</html>









