function reportCheck(num, url) {
	if($('#num').val() == ""){
		alert("num is null");
		$('#num').focus();
	}else{
		var data = 'num=' + num;
		$.ajax({
			type: "POST",
			url: url,
			data: data,
			success: function(data) {
				//$('#id_check').text(data);
				console.log(data);
				alert(data);
				return;
			}// success
		});// ajax
	}
}// idCheck()