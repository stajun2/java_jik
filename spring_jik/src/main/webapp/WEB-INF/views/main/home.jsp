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
	<h1>메인입니다.</h1>
</div>
<script>
	$(function(){
		/* 
		async : 비동기이면 true, 동기이면 false
		비동기는 ajax가 끝나지 않아도 다음 코드가 실행.
		동기는 ajax가 완료되어야 다음 코드가 실행
		data : 서버로 보낼 데이터
		url : 데이터를 보낼 서버 url
		dataType : 서버에서 보내준 데이터의 타입
		contentType : 서버에 보낼 데이터 타입(위의 data의 타입)
		success : ajax를 이용하여 서버에 데이터 전송 후 서버에서 데이터를 처리 한 후 
		  성공했을 때 호출되는 함수
		  - res : 서버에서 화면으로 보낸 데이터
		*/
		$.ajax({
			async:false,
			type:'POST',
			data: {str : "sample"},
			url:"<%=request.getContextPath()%>/ajax/test1",
			//dataType:"json",
			//contentType:"application/json; charset=UTF-8",
			success : function(res){
			    console.log(res);
			}
		});
		$.ajax({
			async:false,
			type:'POST',
			data: "sample",
			url:"<%=request.getContextPath()%>/ajax/test2",
			//dataType:"json",
			contentType:"application/json; charset=UTF-8",
			success : function(res){
			    console.log(res);
			    console.log('주소 : ' + res.address);
			    console.log('주소 : ' + res['address']);
			}
		});
		$.ajax({
			async:false,
			type:'POST',
			data: JSON.stringify({id : "아이디", pw : "비번"}),
			url:"<%=request.getContextPath()%>/ajax/test3",
			dataType:"json",
			contentType:"application/json; charset=UTF-8",
			success : function(res){
			    console.log(res);
			    console.log('주소 : ' + res.address);
			    console.log('주소 : ' + res['address']);
			    console.log('id : ' + res.data.id);
			    console.log('pw : ' + res.data.pw);
			}
		});
	});
</script>
</body>
</html>
