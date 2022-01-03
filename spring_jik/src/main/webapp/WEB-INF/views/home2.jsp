<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<!-- ${serverTime}는 서버에서 화면으로 보낸 데이터. 컨트롤러에서 화면으로 보낸 데이터  -->
<P>  서버에서 보낸 데이터 : ${serverTime}. </P>
<a href="/spring/test?num=1&name=홍길동">데이터 전송</a>
<form action="/spring/test/form" method="get">
	<h1>Get방식으로 전송</h1>
	<input type="text" name="num" placeholder="번호"> <br>
	<input type="text" name="name" placeholder="이름"> <br>
	<button type="submit">전송</button>
</form>
<form action="/spring/test/form" method="post">
	<h1>Post방식으로 전송</h1>
	<input type="text" name="num" placeholder="번호"> <br>
	<input type="text" name="name" placeholder="이름"> <br>
	<button type="submit">전송</button>
</form>
</body>
</html>
