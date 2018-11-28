<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/signup_form.jsp</title>
<!-- Google reCaptcha 에 관련된 자바 스크립트 로딩 -->
<script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<body>
<h3>회원 가입 페이지 입니다.</h3>
<form action="signup.do" method="post" id="signupForm">
	<label for="id">아이디</label>
	<input type="text" name="id" id="id"/>
	<span id="checkResult"></span>
	<br/>
	<label for="pwd">비밀번호</label>
	<input type="text" name="pwd" id="pwd"/><br/>
	<label for="email">이메일</label>
	<input type="text" name="email" id="email"/><br/>
	<button class='g-recaptcha'
        data-sitekey='6LdnY3YUAAAAAO3OrZK25kCshgkfdP_24tQCpQ-p'
        data-callback='onSubmit'>가입</button>
</form>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.min.js"></script>
<script>
	var formValid=false;
	
	function onSubmit(e){
		console.log("onSubmit()");
		if(formValid==false){
			alert("아이디 중복을 확인 하세요.");
			e.preventDefault();
			return;
		}
		document.getElementById("signupForm").submit();
	}
	
	//아이디 입력란에 입력했을때 실행할 함수 등록 
	$("#id").on("input", function(){
		//현재까지 입력한 아이디를 ajax 요청을 통해서 서버에 전송해서
		//사용가능 여부를 리턴 받는다.
		var inputId=$(this).val();
		
		$.ajax({
			url:"checkid.do",
			method:"get",
			data:{inputId:inputId},
			success:function(responseData){
				//콘솔에 테스트 출력
				console.log(responseData);
				if(responseData.canUse){
					$("#checkResult")
					.text("사용가능")
					.css("color","#00ff00");
					
					formValid=true;
				}else{
					$("#checkResult")
					.text("사용불가")
					.css("color","#ff0000");
					
					formValid=false;
				}
			}
		});
	});
</script>

</body>
</html>





















