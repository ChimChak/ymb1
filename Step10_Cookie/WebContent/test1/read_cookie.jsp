<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test1/read_cookie.jsp</title>
</head>
<body>
<%
	Cookie[] cooks=request.getCookies();
	//읽어온 문자열을 저장할 변수
	String savedMsg=null;
	if(cooks!=null){//쿠키가 존재 한다면
		//반복문 돌면서 원하는 쿠키를 찾는다.
		for(Cookie tmp:cooks){
			//저장된 쿠키의 키값을 읽어온다. 
			String key=tmp.getName();
			if(key.equals("savedMsg")){//키값이 "savedMsg" 라면
				//해당 value 를 읽어온다. 
				savedMsg=tmp.getValue();
			}
		}
	}	
%>
<p> "savedMsg" 라는 키값으로 저장된 문자열 : <strong><%=savedMsg %></strong></p>
</body>
</html>






