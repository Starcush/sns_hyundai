<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>sns</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/reset.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/admin_1.css">
<script type="text/javascript" src = "http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/index.js"></script>
</head>

<body>
	<!--상단바 시작-->
	<header>
		<h1>ADMIN</h1>
		
	</header>
	<!--상단바 끝-->
	
	<section>
       <div class="frends_wrap">
			<div class="frends_1">
				 <p class="p_1">회원정보보기</p>
				 <c:forEach var="m" items="${list}">
				 <ul>	
				 	<a href="#"><li id="user"></li></a>
				 	
				 	<li id="id"><a href="#" name="id" value="${m.id }">${m.id }</a></li>
				 	<li id="c_666">${m.name }</li>
				 	<li id="c_666">${m.email }</li>
				 	<a href="${pageContext.request.contextPath }/admin/deleteMember.do?id=${m.id}"><li id="btn_1">강제추방</li></a>
				 	<li id="p_sub" class="p_sub"></li>
				 	
				 </ul>
				 </c:forEach>
			</div>
        </div>
       
	</section>
	<footer>
		
	</footer>
</body>
</html>