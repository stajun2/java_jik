<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>로그인</title>
</head>
<body>
<div class="body">
	<div class="container">
		<h1 class="text-center">회원가입</h1>
		<form action="<%=request.getContextPath()%>/login" method="post">
			<div class="form-group">
			  <input type="text" class="form-control" name="me_id">
			</div>
			<div class="form-group">
			  <input type="password" class="form-control" name="me_pw">
			</div>
			<button class="btn btn-outline-success col-12">로그인</button>
			<label>
				<input type="checkbox" name="me_auto_login" value="ok"> 자동로그인
			</label>
		</form>
		<a href="<%=request.getContextPath()%>/member/find">아이디/비번 찾기</a>
	</div>
</div>
</body>
</html>
