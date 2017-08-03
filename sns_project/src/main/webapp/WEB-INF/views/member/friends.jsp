<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>sns</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/reset.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/frends2.css">
<script type="text/javascript" src = "http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/index.js"></script>
</head>

<body>
	<!--상단바 시작-->
	<header>
		<h1>친구뭐시기</h1>
		
	</header>
	<!--상단바 끝-->
	
	
	<section>
       <div class="frends_wrap">
			<div class="frends_1">
				 <p class="p_1">보낸 요청</p>
				 <ul>	
				 	<a href="#"><li id="user"></li></a>
				 	<li><a href="#">송중기</a></li>
				 	<a href="#"><li id="btn_1">취소</li></a>
				 	<a href="#"><li id="user"></li></a>
				 	<li><a href="#">박보검</a></li>
				 	<a href="#"><li id="btn_1">취소</li></a>
				 	<a href="#"><li id="user"></li></a>
				 	<li><a href="#">이종석</a></li>
				 	<a href="#"><li id="btn_1">취소</li></a>
				 </ul>
			</div>

			<div class="frends_2">
				 <p class="p_2">받은 요청</p>
				 <ul>
				 	<a href="#"><li id="user"></li></a>
				 	<li><a href="#">김우빈</a></li>
				 	<a href="#"><li id="btn_2">수락</li></a>
				 	<a href="#"><li id="btn_3">취소</li></a>
				 	<a href="#"><li id="user"></li></a>
				 	<li><a href="#">아이린</a></li>
				 	<a href="#"><li id="btn_2">수락</li></a>
				 	<a href="#"><li id="btn_3">취소</li></a>
				</ul>
        	</div>
        	<div class="frends_3">
				 <p class="p_3">내 친구들</p>
				 <ul>
				 	<a href="#"><li id="user"></li></a>
				 	<li><a href="#">이광수</a></li>
				 	<a href="#"><li id="btn_1">삭제</li></a>
				 	<a href="#"><li id="user"></li></a>
				 	<li><a href="#">유재석</a></li>
				 	<a href="#"><li id="btn_1">삭제</li></a>
				 	<a href="#"><li id="user"></li></a>
				 	<li><a href="#">서장훈</a></li>
				 	<a href="#"><li id="btn_1">삭제</li></a>
				 </ul>
        	</div>
        </div>
       
	</section>
	
	<footer>
		
	</footer>
</body>
</html>