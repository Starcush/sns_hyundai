<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>

<c:choose>

	<c:when test="${empty member.id }">
		<body onload="loginFail()">
			<script type="text/javascript">
				function loginFail() {
					alert("로그인실패.. 아이디나 암호를 확인해주십쇼");
					location.replace("${pageContext.request.contextPath}/member/loginPage.do");
				}
			</script>
		</body>
	</c:when>
	
	<c:otherwise>
	
		<body onload="loginFail_ban()">
			<script type="text/javascript">
				function loginFail_ban() {
					alert('${member.id}' + " 님은 현재 비매너로 접속제한 상태 입니다");
					location.replace("${pageContext.request.contextPath}/member/loginPage.do");
				}
			</script>
		</body>
		
	</c:otherwise>
</c:choose>
</html>