<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>test2</title>
</head>
<body>
<h1>테스트2입니다.</h1>
<form action="/spring/test2">
	<input type="text" name="num1" placeholder="정수1" value="${num1}"> + 
	<input type="text" name="num2" placeholder="정수2" value="${num2}"> = 
	<input type="text" readonly value="${result}">
	<button>확인</button>
</form>
</body>
</html>
