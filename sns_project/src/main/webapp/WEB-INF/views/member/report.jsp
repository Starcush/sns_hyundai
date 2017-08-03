<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>sns</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/reset.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/report_list.css">
<script type="text/javascript" src = "http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/index.js"></script>
</head>

<body>
	<!--상단바 시작-->
	<header>
		<h1>신고내역</h1>
		
	</header>
	<!--상단바 끝-->
	<c:forEach var="reportList" items="${reportList }">
	<section>
       <div class="report_wrap">
			<div class="report_1">
				 <p class="p_1">${reportList.board.writer}</p>
				 <p class="p_2">${reportList.report_date}</p>
				 <div>
				 	<span class="list_img">
					<img src="/sns/resources/images/board_img/${reportList.board.path }" style="width:150px; height:100%">
				</span>
					${reportList.board.content}
				 </div>
			</div>

			<div class="report_2">
				 <p id="p_3">처리완료</p>
				 <p class="p_4">${reportList.request_completed_date}</p>
				 <div>
					${reportList.admin_response_comment}
				 </div>
        	</div>
        </div>
       
	</section>
	</c:forEach>
	
	<footer>
		
	</footer>
</body>
</html>