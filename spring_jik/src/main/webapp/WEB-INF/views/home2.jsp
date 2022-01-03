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
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
