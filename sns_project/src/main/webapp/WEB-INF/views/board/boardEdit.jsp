<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>sns</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/reset.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/write.css?ver=1">
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
               <input type="text" name="writer" placeholder="작성자" value="${member.id }" readonly class="hiddenItem"/><!-- 작성자 표시 영역 -->
               <input type="hidden" name="num" value="${board.num }"/>
               
               <div class="col1 sideL">
                  <select name="type">
                     <option value="${board.type }">${type }</option>
                     <option value="0">나만보기</option>
                     <option value="1">친구만보기</option>
                     <option value="2">전체공개</option>
                  </select>
                  
                  <select name="category">
                     <option value="${board.category }">${category }</option>
                     <option value="0">정치</option>
                     <option value="1">사회</option>
                     <option value="2">스포츠</option>
                  </select>

                  <span id="imagePreview" style="background:url('/sns/resources/images/board_img/${board.path }'); background-size:300px 400px"></span><!-- 미리보기 : 기존에 사진을 불러오자 -->
                  <span><input id="image" type="file" class="profile" name="file" value=${board.path } onchange="InputImage();"></span>
                  </div><!-- col1 sideL -->
                  
                  <div class="box col2 sideR">
                  <textarea name="content" class="txtArea" value=${board.content } placeholder="글을 작성하세요..." required>${board.content }</textarea>
                  </div><!-- box col2 sideR -->
                  
                  <div class="bt1"><input type="submit" value="수정" class="ok"></div>
         </fieldset>   
      </form>
   </div><!-- write_wrap -->
</body>
</html>