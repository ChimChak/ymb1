<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test4/save.jsp</title>
</head>
<body>
<%
	// "no" 혹은 null 값이다. 
	String canPopup=request.getParameter("canPopup");
	//만일 null 이 아니면 1분동안 팝업을 띄우지 말라는 것이다.
	//쿠키 유지 시간을 1분으로 해서 표시해 놓기 
	if(canPopup != null){
		Cookie cook=new Cookie("canPopup", canPopup);
		cook.setMaxAge(60);
		//cook.setMaxAge(60*60*24); // 24 시간
		response.addCookie(cook);
	}
%>
<script>
	//팝업창 닫기 
	self.close();
</script>
</body>
</html>














