var InputImage = 
 (function loadImageFile() {
    if (window.FileReader) {
        var ImagePre; 
        var ImgReader = new window.FileReader();
        var fileType = /^(?:image\/bmp|image\/gif|image\/jpeg|image\/png|image\/x\-xwindowdump|image\/x\-portable\-bitmap)$/i; 
 
        ImgReader.onload = function (Event) {
            if (!ImagePre) {
                var newPreview = document.getElementById("imagePreview");
                ImagePre = new Image();
                ImagePre.style.width = "250px";
                ImagePre.style.height = "320px";
                newPreview.appendChild(ImagePre);
            }
            ImagePre.src = Event.target.result;
            
        };
 
        return function () {
         
            var img = document.getElementById("image").files;
           
            if (!fileType.test(img[0].type)) { 
             alert("이미지 파일을 업로드 하세요"); 
             return; 
            }
            
            ImgReader.readAsDataURL(img[0]);
        }
 
    }
   
    var time = new Date().getTime();
    var img_src = document.getElementById("image").value;
    var new_src = img_src + time;
   
    document.getElementById("imagePreview").src = new_src;
 
      
})();