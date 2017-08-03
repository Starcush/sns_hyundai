/**
 * member관련 함수
 */
$(document).ready(function(){
	$('#id').focus();
	$('#id').blur(function(){
		if($('#id').val() == "" || $('#id').val == null){
			$('#id').focus();
		}
	});
});

// id중복검사 함수
function idCheck(id, url) {
	if($('#id').val() == ""){
		alert("id is null");
		$('#id').focus();
	}else{
		var data = 'id=' + id;
		$.ajax({
			type : "POST",
			url : url,
			data : data,
			success : function(data) {
				//$('#id_check').text(data);
				alert(data);
			}// success
		});// ajax
	}
}// idCheck()

function joinFormGo(url){
	alert(url);
	location.replace(url);
}
