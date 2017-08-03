<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>sns</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/reset.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/block_list.css?ver=2">
<script type="text/javascript" src = "http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/index.js"></script>
</head>

<body>
	<!--상단바 시작-->
	<header>
		<h1>신고내역</h1>
		
	</header>
	<!--상단바 끝-->
	
	
	<section>
       <div class="frends_wrap">
			<div class="frends_1">
				 <p class="p_1">차단내역</p>
				 <ul>
				  <c:forEach var="list" items="${blockList }">	
				 	<li id="user"><img src="/sns/resources/images/member_img/${list.member.img }"></li>
				 	<li><a href="#">${list.target }</a></li>
				 	<a href="${pageContext.request.contextPath }/member/unblock.do?num=${list.num}"><li id="btn_1">해제</li></a>
				 </c:forEach>
				 </ul>
			</div>
        </div>
       
	</section>
	
	<footer>
		
	</footer>
</body>
</html>