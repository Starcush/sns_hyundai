<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/reset.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/join.css?ver=1">
<script type="text/javascript" src = "http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath }/resources/js/member.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath }/resources/js/upload.js"></script>


</head>
<body>
<spring:hasBindErrors name="member" /> 
<form:errors path="member" />
	<!--상단바 시작-->
	<header>
		<h1>회원가입하기</h1>
	</header>
	<!--상단바 끝-->
	
	<section>
		<h2 class="join_text">안녕하세요?<br>
		<strong>지금 바로 SNS를 시작해보세요!</strong>
		</h2>
        <form class="join_wrap" action = "${pageContext.request.contextPath }/member/join.do" 
        method = "post" enctype="multipart/form-data">
        
        	<fieldset>
            	<div id="img">
            		<span id="imagePreview"></span>
            		<label for="image">
            			<span>
            				<input id="image" type="file" class="profile" name="file"  onchange="InputImage();">
            			</span>
            		</label>
					
                </div>
                
                <div class="join_field">
                 
<!-- 					<span id="join_dup"> -->
<!-- 						<input type="button" value="중복체크" id="dup"  -->
<%-- 						onclick = "idCheck(this.form.id.value, '${pageContext.request.contextPath}/member/idCheck.do')"> --%>
<!-- 					</span> -->
                
	                <span id="join1">	
	                    <input type="text" placeholder="  아이디" id="id" name = "id">
	                    					<span id="join_dup">
						<input type="button" value="중복체크" id="dup" 
						onclick = "idCheck(this.form.id.value, '${pageContext.request.contextPath}/member/idCheck.do')">
					</span><br>
	                    
	                  
<!-- 	                    <div class="id_check" id = "id_check">        -->
	<%--                     <form:errors path = "member.id"/> --%>
<!-- 	                    </div> -->
	                    
	                    <input type="password" placeholder="   비밀번호" name = "pwd" id = "pwd">
	                    <br><br><br><form:errors path = "member.pwd"/><br>
	                    
	                    <input type="text" placeholder="   이름" name = "name" id = "name">
	                    <br><form:errors path = "member.name"/><br>
	                    
	                    <input type="text" placeholder="   이메일" name = "email" id = "email">
	                    <br><br><form:errors path = "member.email"/><br>
	                </span>
                    
                    <input type = "hidden" name = "isban" value = "f">
                </div>
                
                <div class="join_btn">
                <input type="submit" value="회원가입" class="ok">
                <input type="button" value="취소" class="cancel">
                </div>
            </fieldset>
        </form>
	</section>
	
	<footer>
		
	</footer>
</body>
</html>