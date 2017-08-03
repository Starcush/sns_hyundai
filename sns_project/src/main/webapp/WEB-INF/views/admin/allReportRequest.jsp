<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>sns</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/reset.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/admin_3.css">
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
       <div class="admin_wrap">
			<div class="left">
				 <p class="p_1">신고 내역</p>
				 <c:forEach var="r" items="${rList}">
				 <ul>	
				 	
					<li><a href="#"><span>${r.report_date }</span> <span>${r.reporter}</span>님이 <span>${r.board.writer }</span>님이 올리신 글을 신고하였습니다.</a></li>
				 </ul>
				 </c:forEach>
			</div>
      	   <div class="right">
      	    <c:forEach var="r" items="${rList}">
      	   		<ul>
					<li class="profile_img"><img src="img/user.png" alt="">${r.board.writer }</li>
					
				</ul>
				<p>${r.board.content }</p>
       			<ul class="btn">
       				<a href="#"><li>계정정지</li></a>
       				<a href="#"><li id="color">글삭제</li></a>
       			</ul>
       			</c:forEach>
       		</div>
        </div>
            
       
	</section>
	
	<footer>
		
	</footer>
</body>
</html>