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
	    	<c:forEach items="${list}" var="board">
		      <tr>
		        <td>${board.bd_num}</td>
		        <td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">${board.bd_title}</a></td>
		        <td>${board.bd_me_id}</td>
		        <td>${board.bd_reg_date_str}</td>
		      </tr>
	      </c:forEach>
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