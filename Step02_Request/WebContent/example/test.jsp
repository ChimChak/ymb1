<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example/test.jsp</title>
</head>
<body>
<h3>Request 테스트</h3>
<button id="fortuneBtn">오늘의 운세(ajax)</button>
<button id="fortuneBtn2">오늘의 운세2(ajax)</button>
<p id="result"></p>
<a href="${pageContext.request.contextPath}/example2/test.jsp">POST 방식 Request 예제</a>
<script src="/Step02_Request/resources/js/jquery-3.3.1.min.js"></script>
<script>
	//$("#fortuneBtn").on("click", function(){});
	$("#fortuneBtn").click(function(){
		$.ajax({
			url:"fortune.jsp",
			method:"get",
			success:function(data){
				// data 는 JSON 문자열이다.
				console.log(data);
				// JSON 문자열을 object 로 변환 
				var obj=JSON.parse(data);
				console.log(obj);
				//오늘의 운세 출력하기
				$("#result").text(obj.fortuneToday);
			}
		});
	});
	
	$("#fortuneBtn2").click(function(){
		$.ajax({
			url:"fortune2.jsp",
			method:"get",
			success:function(data){
				// data 는 object 이다. 
				console.log(data);
				$("#result").text(data.fortuneToday);
			}
		});
	});
</script>
</body>
</html>





















