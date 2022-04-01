<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<style >
	.box{
		width: 100%;
		height : 500px;
		border : 1px solid black;
		overflow: hidden;
	}
	
	</style>
</head>
<body>
<div class="body container">
	<iframe class="box" src="<%=request.getContextPath()%>/board/list"></iframe>

</div>
<script>

</script>
</body>
</html>
