<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test3/popup.jsp</title>
</head>
<body>

<script>
	/*	
		[ 팝업 옵션 문자열 ]
		
		yes나 no로 지정하면 됩니다.
		toolbar = 상단 도구창 출력 여부 
		menubar = 상단 메뉴 출력 여부
		location = 메뉴아이콘 출력 여부
		directories = 제목 표시줄 출력 여부
		status = 하단의 상태바 출력 여부
		scrollbars = 스크롤바 사용 여부
		resizable = 팝업창의 사이즈 변경 가능 여부
		
		사이즈 정의(픽셀 px)
		width = 팝업창의 가로 길이 설정
		height = 팝업창의 세로 길이 설정
		top = 팝업창이 뜨는 위치(화면 위에서부터의 거리 지정)
		left = 팝업창이 뜨는 위치(화면 왼쪽에서부터의 거리 지정)
	*/
	
	//팝업 띄우는 함수 
	function showPopup(){
		window.open("popup_page.jsp","팝업창","width=400,height=300,top=100,left=100");
	}
	
	//팝업을 중앙에 띄우는 함수 
	function showPopup2(){
		PopupCenter("popup_page.jsp","팝업창", 800, 500);
	}
	
	//팝업을 중앙에 원하는 페이지를 원하는  크기로 띄우는 함수 
	function PopupCenter(url, title, w, h) {
		// Fixes dual-screen position                         Most browsers      Firefox
		var dualScreenLeft = window.screenLeft != undefined ? window.screenLeft : screen.left;
		var dualScreenTop = window.screenTop != undefined ? window.screenTop : screen.top;
		
		width = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth ? document.documentElement.clientWidth : screen.width;
		height = window.innerHeight ? window.innerHeight : document.documentElement.clientHeight ? document.documentElement.clientHeight : screen.height;
		
		var left = ((width / 2) - (w / 2)) + dualScreenLeft;
		var top = ((height / 2) - (h / 2)) + dualScreenTop;
		var newWindow = window.open(url, title, 'scrollbars=yes, width=' + w + ', height=' + h + ', top=' + top + ', left=' + left);
		
		// Puts focus on the newWindow
		if (window.focus) {
		    newWindow.focus();
		}
	}
</script>
<h3>팝업 테스트 페이지 입니다.</h3>
<p>Gura 홈 쇼핑</p>
<p>겨울을 미리 미리 준비 하세요</p>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quod dolore odit omnis qui sapiente vitae aspernatur ipsa assumenda laudantium quasi. Asperiores quos incidunt aliquid odio repellat sint quibusdam molestias soluta!</p>
<%
	//팝업창을 띄울지 여부
	boolean canPopup=true;
	//모든 쿠키를 배열로 얻어낸다.
	Cookie[] cooks=request.getCookies();
	if(cooks!=null){
		for(Cookie tmp:cooks){
			// "canPopup" 이라는 키값으로 저장된 쿠키가 존재하면 
			if(tmp.getName().equals("canPopup")){
				//팝업을 띄우지 않도록
				canPopup=false;
			}
		}
	}
%>
<%if(canPopup){ %>
	<script>
		showPopup2();
	</script>
<%} %>
</body>
</html>














