<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>sns</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/reset.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/login.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/index.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath }/resources/js/member.js"></script>
</head>

<body>
	<!--상단바 시작-->
	<header>
		<h1>로그인</h1>
		
	</header>
	<!--상단바 끝-->
	
	
	<section>
        <form method="post" action="${pageContext.request.contextPath }/member/login.do" class="login_wrap">
        	<fieldset class="id">
               		<legend>ID</legend>
                	<input type="text" placeholder="아이디" id="id_field" required autocomplete="on" name = "id">
			</fieldset>
			<fieldset class="pw">
                <legend>PW</legend>
                <input type="password" placeholder="비밀번호" name = "pwd">
			</fieldset>
           	<fieldset class="checkbox">
            <input type="checkbox" value="아이디저장"><p id="id_save">아이디저장</p>
			<input type="checkbox" value="비밀번호저장"><p>비밀번호저장</p>
           </fieldset>            
			<fieldset class="join_btn">
                	<input type="submit" value="로그인" class="ok">
                	<input type="button" value="회원가입" class="cancel" onclick = "joinFormGo('${pageContext.request.contextPath}/member/joinForm.do')">
			</fieldset>            
        </form>
        <a><p>아이디/비밀번호 찾기</p></a>
	</section>
	
	<footer>
		
	</footer>
</body>
</html>
