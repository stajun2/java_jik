<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="body container">
		<h1>게시글</h1>
		<table class="table table-warning table-hover">
	    <thead>
	      <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>작성날짜</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>1</td>
	        <td><a href="#">제목</a></td>
	        <td>abc123</td>
	        <td>2022-01-06</td>
	      </tr>
	    </tbody>
	  </table>
	  <c:if test="${user != null}">
	  <a href="<%=request.getContextPath()%>/board/register">
	  	<button class="btn btn-outline-success">글쓰기</button>
	  </a>
	  </c:if>
	</div>
</body>
</html>