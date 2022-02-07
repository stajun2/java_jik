<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <!-- Brand/logo -->
	  <a class="navbar-brand" href="<%=request.getContextPath()%>">HOME</a>
	  
	  <ul class="navbar-nav">
	  	<!-- 로그인되어 있지 않으면 => 세션에 user가 없으면-->
	  	<c:if test="${ user == null }">
		    <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/login">로그인</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/signup">회원가입</a>
		    </li>
	    </c:if>
	    <!-- 로그인 되어 있으면 => 세션에 user가 있으면 => user가 null이 아니면  -->
	    <c:if test="${ user != null }">
	    	<li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/logout">로그아웃</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/mypage">마이페이지</a>
		    </li>
	    </c:if>
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/board/list?type=공지">공지사항</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/board/list">게시글</a>
	    </li>
	    <c:if test="${user.me_authority == '슈퍼 관리자' }">
	    	<li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/admin/member/list">회원관리</a>
		    </li>
	    </c:if>
	  </ul>
	</nav>
</body>
</html>