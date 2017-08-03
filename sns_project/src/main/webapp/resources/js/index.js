$(function(){
	$(".like").click(function(){
                 $(this).toggleClass('like_c')
   });
	
    $('#id_field').keyup(function(e) {
        var inputlength= $(this).val().length;
		var remain=6 - inputlength;
		if(remain<=0){
			$('.id_check').css('background','url(img/check.png)')
			}else{
			$('.id_check').css('background','url(img/none.png)')
				}
    });
    
	$(".more").click(function(){
                 $(this).toggleClass('more_c')
                 var index = $('.more').index(this);
				 $('.sub').eq(index).slideToggle(200)
   });
    
//    $('.more').click(function() {
//    	var index = $('.more').index(this);
//    	$('.more').eq(index).slideDown();
//    });
});