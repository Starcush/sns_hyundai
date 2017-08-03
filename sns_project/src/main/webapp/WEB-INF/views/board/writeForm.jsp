<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>sns</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/reset.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/write.css">
<script type="text/javascript" src = "http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/index.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/write_upload.js"></script>
<style type="text/css">
     
   
  </style>

</head>

<body>
	<!--상단바 시작-->
	<header>
		<h1>글쓰기</h1>
		
	</header>
	<!--상단바 끝-->
	
	
	<div class="wrap">
        <form method="post" action="${pageContext.request.contextPath }/board/write.do"  enctype="multipart/form-data">
           	<div class="clearFix"><!-- form 전체 --> 
           		 <div class="sideL"> <!-- 왼쪽 부분 : select 2개, 이미지 영역, 이미지 input -->
					<input type="hidden" name="writer" value="${member.id }" />
				
					<select name="type">
						<option value="">글 공개범위</option>
						<option value="0">나만보기</option>
						<option value="1">친구만보기</option>
						<option value="2">전체공개</option>
					</select>
					
					<select name="category">
						<option value="">글종류</option>
						<option value="0">정치</option>
						<option value="1">사회</option>
						<option value="2">스포츠</option>
					</select>
					
					<div class="box1"><!-- sideL div안에 있는 box(div) -->
						<span id="imagePreview" style="background-color:#fcfcfc; size:250px 320px"></span>
						<input id="image" type="file" class="profile" name="file" onchange="InputImage();"/>
                 	 </div>
                 	 
                 </div><!-- col1 sideL -->
                 
                 <div class="box2 sideR">
                 	<textarea name="content" placeholder="글을 작성하세요..." required></textarea>
                 </div>
                 
		   </div><!-- clearFix -->
		   <div class="write_btn"><input type="submit" value="확인"/></div>      
        </form>
	</div><!-- wrap -->

	<footer>
		
	</footer>
	
</body>
</html>