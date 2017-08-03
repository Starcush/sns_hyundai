<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>Main Page</h3>
<img alt="" src="${pageContext.request.contextPath }/resources/images/cat.jpg"><br><br>
<a href = "${pageContext.request.contextPath }/member/joinForm.do">회원가입하기</a>
<!-- 댓글영역 두 조건중에 하나의 댓글리스트들이 출력된다-->
<c:choose>
<c:when test="${sessionScope.id eq board.writer }">
내가 쓴 글 이므로 비밀댓글도 뿌려주는 쿼리문을 출력
</c:when>
<c:otherwise>
내가 쓴 글이 아니므로 비밀댓글을 제외하는 쿼리문 출력
</c:otherwise>
</c:choose>
<!-- 댓글영역 -->
</body>
</html>