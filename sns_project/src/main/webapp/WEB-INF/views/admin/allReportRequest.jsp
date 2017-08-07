<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>sns</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/reset.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/admin_3.css?ver=3">
<script type="text/javascript" src = "http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/index.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/admin.js"></script>
<script type="text/javascript">

function complete_report() {
	document.report_form.submit();
}


</script>


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
				 	
					<li><a href="${pageContext.request.contextPath }/admin/reportListByNum.do?board_num=${r.board_num}"><span>${r.report_date }</span> <span>${r.reporter}</span>님이 <span>${r.board.writer }</span>님이 올리신 글을 신고하였습니다.
					</a></li>
				 </ul>
				 </c:forEach>
			</div>
      	   <div class="right">
      	    <c:forEach var="r" items="${ListByNum}">
      	   		<ul>
					<li class="profile_img"><img src="img/user.png" alt="">${r.board.writer }</li>
				</ul>
				<p>${r.board.content }</p>
				<form name="report_form" action="${pageContext.request.contextPath }/admin/restrictionComment.do" method="post" id="f">
				<input type="hidden" name="id" value="${r.board.writer }"/>
				<input type="hidden" name="num" value="${r.num }"/>
				<ul>
				<li class="profile_img">관리자 답변</li>
				<p><textarea cols=30 rows=10 name="admin_response_comment"></textarea></p>
				</ul>
       			<ul class="btn">
<%--        				<a href="${pageContext.request.contextPath }/admin/restrictionMember.do?id=${r.board.writer}&num=${r.num }"><li>계정정지</li></a> --%>
					<input type="button" value="계정정지" onclick="complete_report();" id="button"/>
       				<a href="#"><li id="color">글삭제</li></a>
       			</ul>
       			</form>
       			</c:forEach>
       		</div>
        </div>
            
       
	</section>
	
	<footer>
		
	</footer>
</body>
</html>