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
</head>

<body>
 <!--상단바 시작-->
	<header>
		<h1>글쓰기</h1>
		
	</header>
	<!--상단바 끝-->
<div class="write_wrap">
  <form method="post" action="${pageContext.request.contextPath }/board/update.do" class="write_wrap" enctype="multipart/form-data">
<fieldset>
<legend>글쓰기</legend>
   <div class="clearFix">
   <input type="text" name="writer" placeholder="작성자" value="${member.id }" readonly class="hiddenItem">
   <input type="hidden" name="num" value="${board.num }">
      <div class="col1 sideL">
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

         <span id="imagePreview"></span>
					<span><input id="image" type="file" class="profile" name="file" value=${board.path } onchange="InputImage();"></span>
      </div>
      <div class="box col2 sideR">
         <textarea name="content" class="txtArea" value=${board.content } placeholder="글을 작성하세요..." required></textarea>
      </div>
   </div>
   <div class="bt1"><input type="submit" value="수정" class="ok"></div>
   </fieldset>	
  </form>

</div>
</body>
</html>