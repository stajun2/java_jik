<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<style >
	.box, .box:hover{
		width : 100px; height : 100px; border : 1px solid red;
		color : red; line-height: 100px; text-align: center;
		font-weight: bold; font-size: 50px; display: block;
		text-decoration: none;
	}
	.thumb-image{
		width : 300px; 
	}
	
	</style>
</head>
<body>
<div class="body container">
	
	<a class="box" href="javascript:;">+</a>
	<div id="image-holder">
		<input type="file" accept="image/*" style="display: none" name="files">
	</div>
</div>
<script>
$(document).on('change','#image-holder input[type=file]:last', function () {
	console.log(123);
    //Get count of selected files
    var countFiles = $(this)[0].files.length;

    var imgPath = $(this)[0].value;
    //확장자 체크
    var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
    var image_holder = $("#image-holder");
    

    if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
        if (typeof (FileReader) != "undefined") {

            //loop for each file selected for uploaded.
            for (var i = 0; i < countFiles; i++) {

                var reader = new FileReader();
                reader.onload = function (e) {
                    $("<img />", {
                        "src": e.target.result,
                            "class": "thumb-image"
                    }).appendTo(image_holder);
                    var str = '<input type="file" accept="image/*" style="display: none" name="files">';
                    $(str).appendTo(image_holder);
                }

                image_holder.show();
                reader.readAsDataURL($(this)[0].files[i]);
            }

        } else {
            alert("This browser does not support FileReader.");
        }
    } else {
        alert("Pls select only images");
    }
    
});
$('.box').click(function(){
	$('#image-holder input[type=file]:last').click();
})

$(document).on('click','.thumb-image', function(){
	if(confirm('이미지를 삭제하겠습니까?')){
		$(this).prev().remove();
		$(this).remove();
	}
});

</script>
</body>
</html>
