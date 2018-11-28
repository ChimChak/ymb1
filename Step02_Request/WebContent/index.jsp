<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
<h3>Request 테스트</h3>
<ul>
	<li><a href="fortune">오늘의 운세</a></li>
	<li><a href="fortune.jsp">오늘의 운세2</a></li>
	<li><a href="detail?num=1">1번글 자세히 보기</a></li>
	<li><a href="detail?num=2">2번글 자세히 보기</a></li>
	<li><a href="detail?num=3">3번글 자세히 보기</a></li>
	<li><a href="detail.jsp?num=1">1번글 자세히 보기(jsp)</a></li>
	<li><a href="detail.jsp?num=2">2번글 자세히 보기(jsp)</a></li>
	<li><a href="detail.jsp?num=3">3번글 자세히 보기(jsp)</a></li>
	<li><a href="example/test.jsp">NEXT 예제</a></li>
</ul>
<button id="fortuneBtn">오늘의 운세</button>
<button id="fortuneBtn2">오늘의 운세(Ajax)</button>
<button id="detailBtn">1번글 자세히 보기</button>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script>


	$("#detailBtn").on("click", function(){
		$.ajax({
			url:"detail",
			method:"get",
			data:{num:1}, // {num:1} 혹은 "num=1"
			success:function(data){
				alert(data);
			}
		});
	});

	$("#fortuneBtn2").on("click", function(){
		// ajax 요청하기
		$.ajax({
			url:"fortune.jsp",
			method:"get",
			success:function(data){
				//alert(data);
				console.log(data);
			}
		});
	});
	
	$("#fortuneBtn").on("click", function(){
		//javascript 로 페이지 이동 시키기
		//location.href="fortune";
		location.href="fortune.jsp";
	});
	
</script>
</body>
</html>
















