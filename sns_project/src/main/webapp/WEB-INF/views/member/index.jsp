<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>sns</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/index_reset.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/index.css?ver=5">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath }/resources/js/report.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/index.js?ver=1"></script>
<script type="text/javascript">
function check(form){
	var type = "";
	if(form.type.checked){
		type += form.type.value
	} 
}
</script>
</head>
<body>

	<!--��ܹ� ����-->
	<header>
		<h1></h1>
		<ul>
		<c:choose>
		
		<%-- ����� Header --%>
			<c:when test="${sessionScope.member.id != null && sessionScope.member.id ne 'admin'}">
				<c:set value="${totalList_login }" var="list"/>
				<li class="hd_user">
					<img src="${pageContext.request.contextPath }/resources/images/index_img/header_user.png">
					<span>${sessionScope.member.id }</span> �� ȯ���մϴ�.
				</li>
				
				<a href="${pageContext.request.contextPath }/member/searchForModify.do">
					<li><img src="${pageContext.request.contextPath }/resources/images/index_img/header_btn_1.png" alt="myInfo"></li>
				</a>
				
				<a href="${pageContext.request.contextPath }/member/myFriends.do">
					<li><img src="${pageContext.request.contextPath }/resources/images/index_img/header_btn_2.png" alt="friends"></li>
				</a>
				
				<a href="${pageContext.request.contextPath }/board/reportList.do">
					<li><img src="${pageContext.request.contextPath }/resources/images/index_img/header_btn_3.png" alt="reportList"></li>
				</a>
				
				<a href="${pageContext.request.contextPath }/member/myBlockList.do">
					<li><img src="${pageContext.request.contextPath }/resources/images/index_img/header_btn_5.png" alt="blockList"></li>
				</a>
				
				<a href="${pageContext.request.contextPath }/member/logout.do">
					<li class="logout"><img src="${pageContext.request.contextPath }/resources/images/index_img/header_btn_4.png" alt="logout"></li>
				</a>
			</c:when>
		
			<%--������ Header --%>
			<c:when test="${sessionScope.member.id != null && sessionScope.member.id eq 'admin'}">
				<c:set value="${totalList_login }" var="list"/>
				<li class="hd_admin">
					<img src="${pageContext.request.contextPath }/resources/images/index_img/header_user.png">
					<span>${sessionScope.member.id }</span> �� ȯ���մϴ�.
				</li>
				
				<a href="${pageContext.request.contextPath }/admin/MemberList.do">
					<li><img src="${pageContext.request.contextPath }/resources/images/index_img/header_btn_2.png" alt="member_All"></li>
				</a>
				
				<a href="${pageContext.request.contextPath }/admin/reportList.do">
					<li><img src="${pageContext.request.contextPath }/resources/images/index_img/header_btn_3.png" alt="report_All"></li>
				</a>
				
				<a href="${pageContext.request.contextPath }/admin/banMemberList.do">
					<li><img src="${pageContext.request.contextPath }/resources/images/index_img/header_btn_5.png" alt="blockMember_List"></li>
				</a>
				
				<a href="${pageContext.request.contextPath }/member/logout.do" >
					<li class="logout"><img src="${pageContext.request.contextPath }/resources/images/index_img/header_btn_4.png" alt="logout"></li>
				</a>
			</c:when>
			
			<c:otherwise>
			<c:set value="${totalList_noLogin }" var="list"/>
				<a href="${pageContext.request.contextPath }/member/loginPage.do"><li><img src="${pageContext.request.contextPath }/resources/images/index_img/header_btn_6.png" alt="�α���"></li></a>
			</c:otherwise>
		</c:choose>
		</ul>
	</header>
<!--��ܹ� ��-->
	
	
	<section>
		<c:if test = "${sessionScope.member.id != null && sessionScope.member.id ne 'admin'}">
	  	<div class="btn_wrap11">
	  
			<!--��ư ����-->
			<ul class="btn_wrap">
				<a href="${pageContext.request.contextPath }/board/writeForm.do"><li class="s_t_btn_1">�۾���</li></a>
				<a href="#"><li class="s_t_btn_2">btn</li></a>
				<a href="#"><li class="s_t_btn_3">btn</li>	</a>
				<a href="#"><li class="s_t_btn_4">btn</li></a>
				<a href="#"><li class="s_t_btn_5">btn</li></a>
			</ul>
		</div>
		<!--��ư ��-->
		</c:if>
		
		<!--���� ����-->
		
		<c:forEach var="totalList" items="${list }">
		<article>
			<div class="article_1"><!-- resources/css/index.css -->
			
			<ul>
				<li class="profile_img">
<!-- 					<a href="#"></a> -->
					<img src="${pageContext.request.contextPath}/resources/images/member_img/${totalList.board.member.img }" width="50px" height="50px"/>
					<a href="#">${totalList.board.writer }</a> ���� ���� �Խ��߽��ϴ�. ${totalList.board.board_date }</li>
					<li class="more"></li><!-- �ϳ��� ������ ���� �̺�Ʈ ȣ���  .. �ذᰡ���� -->
					<li class="like"></li>
					
			</ul>
			
			<ul class="sub">
					<li><a href="${pageContext.request.contextPath}/member/block.do?target=${totalList.board.writer}" class = "block_user">�����ϱ�</a></li>
					<li><a onclick = "reportCheck(${totalList.board.num}, '${pageContext.request.contextPath}/board/reportCheck.do')" href="${pageContext.request.contextPath}/board/report.do?reporter=${member.id}&board_num=${totalList.board.num}&board_rep_num=0" class = "report_user" id="report">�Ű��ϱ�</a></li>
					<li><a class = "friendRequest_user">ģ����û</a></li>	
					<c:choose>
					<c:when test="${sessionScope.member.id != null && sessionScope.member.id eq totalList.board.writer}">
					<li><a href="${pageContext.request.contextPath}/board/editForm.do?num=${totalList.board.num}" class = "updateBoard_user">�ۼ���</a></li>
					<li><a href="${pageContext.request.contextPath}/board/delete.do?num=${totalList.board.num}" class = "deleteBoard_user">�ۻ���</a></li>
					</c:when>
					<c:otherwise><li><a class = "sorry">�ۻ����� ȸ���� ����</a></li></c:otherwise>
					</c:choose>
			</ul>
			<input type="hidden" name="num" value="${totalList.board.num}">
			<!-- ������ ���� �κ� -->
			<p>
				<span class="list_img">
					<img src="${pageContext.request.contextPath}/resources/images/board_img/${totalList.board.path }" style="width:150px; height:100%">
				</span>
				<span class="list_contet">
					<textarea name="content" readOnly>${totalList.board.content }</textarea> </span>
				<br><!-- ���� --><br><!-- ���� --></p>			
			</div>
			
			<!--  -------- article_1 (div) : ���� �� �κ� ---------------------- -->
			
			<div class="article_2">
			<form method="post" action="${pageContext.request.contextPath }/">
			
		
			
			<input type="text" name="content" value="" readOnly>
			<input type="submit" value="����">
			
			</form>
				<form method="post" name="form1" action="${pageContext.request.contextPath }/board/writeRep.do" >
        			<fieldset>
        			<input type="hidden" name="writer" value="${member.id}">
        			<input type="hidden" name="board_num" value="${totalList.board.num }">
                 	<input type="checkbox" name="type" value="1" >��д��
                 		<input type="text" placeholder="����� �Է��ϼ���..." name="content" id="text">
                    	<input type="submit" value="" class="submit" onclick="check(this.form);">
           			 </fieldset>
       			 </form>
				
			</div>
			
			<!--  -------- article_2 (div) ��� �κ� ---------------------- -->
			
		</article>
		<!--���� ��-->
		
		</c:forEach>

	</section>
	
	<footer>
		
	</footer>
	
</body>
</html>