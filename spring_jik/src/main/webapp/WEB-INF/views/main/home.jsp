<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<div class="body">
	<input type="text" id="input">
	<button id="btn">확인</button>
</div>
<script>
	var idRegex = /^[A-z]\w{4,7}$/g;
	$('#btn').click(function(){
		var id = $('#input').val();
		if(idRegex.test(id)){
			alert('정규표현식에 맞습니다.');
		}else{
			alert('정규표현식에 맞지 않습니다.');
		}
	});
</script>
</body>
</html>
