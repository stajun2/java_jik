<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>로그인</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <!-- Brand/logo -->
	  <a class="navbar-brand" href="/spring">HOME</a>
	  
	  <!-- Links -->
	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link" href="/spring/test">test</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="/spring/test2">test2</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="/spring/test/form">데이터 전송 예제</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="/spring/test3">test3</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="/spring/login">로그인</a>
	    </li>
	  </ul>
	</nav>
	<div class="container">
		<h1 class="text-center">회원가입</h1>
		<form action="/spring/login" method="post">
			<div class="form-group">
			  <input type="text" class="form-control" name="id">
			</div>
			<div class="form-group">
			  <input type="password" class="form-control" name="pw">
			</div>
			<button class="btn btn-outline-success col-12">로그인</button>
		</form>
	</div>
</body>
</html>
