<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example2/test.jsp</title>
<link rel="stylesheet" 
	href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<h3>Post 전송 테스트</h3>
	<form action="login.jsp" method="post">
		<div class="form-group">
			<label for="id">아이디</label>
			<input class="form-control" type="text" name="id" id="id"/>
		</div>
		<div class="form-group">
			<label for="pwd">비밀번호</label>
			<input class="form-control" type="password" name="pwd" id="pwd"/>
		</div>
		<button class="btn btn-primary" type="submit">로그인</button>
		<button class="btn btn-warning" type="reset">취소</button>
	</form>
	<h3>Post 전송 테스트(Ajax)</h3>
	<form action="login_ajax.jsp" method="post" id="loginForm">
		<div class="form-group">
			<label for="id">아이디</label>
			<input class="form-control" type="text" name="id" id="id"/>
		</div>
		<div class="form-group">
			<label for="pwd">비밀번호</label>
			<input class="form-control" type="password" name="pwd" id="pwd"/>
		</div>
		<button class="btn btn-primary" type="submit">로그인</button>
		<button class="btn btn-warning" type="reset">취소</button>
	</form>
	
	<a href="../example3/test.jsp">다양한 폼 구성 예제</a>
</div>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.min.js"></script>
<script>
	// 폼에 submit 이벤트가 일어났을때 실행할 함수 등록 
	$("#loginForm").on("submit", function(event){
		//이벤트가 발생한 폼의 action 속성의 value 를 읽어온다.
		var url=$(this).attr("action");
		//이벤트가 발생한 폼의 method 속성의 value 를 읽어온다. 
		var method=$(this).attr("method");
		//폼에 입력한 내용을 query string 형식으로 읽어온다. 
		var inputData=$(this).serialize();
		//console.log(inputData);
		$.ajax({
			url:url,
			method:method,
			data:inputData,
			success:function(data){
				// data => {isValid:true} or {isValid:false}
				if(data.isValid){
					alert("로그인 되었습니다.");
				}else{
					alert("아이디 혹은 비밀번호가 틀려요!");
				}
			}
		});
		
		//폼전송 막기 
		//event.preventDefault();
		return false; 
	});
</script>
</body>
</html>








