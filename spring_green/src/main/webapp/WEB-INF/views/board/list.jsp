<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글</h1>
	<form class="input-group mb-3" action="<%=request.getContextPath()%>/board/list">
	  <input type="text" class="form-control" placeholder="검색어를 입력하세요." name="search" value="${pm.criteria.search}">
	  <div class="input-group-append">
	    <button class="btn btn-success" type="submit">Go</button>
	  </div>
	</form>
	<table class="table table-hover table-success">
    <thead class="thead-dark">
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach var="board" items="${list}">
	      <tr>
	        <td>${board.bd_num}</td>
	        <c:if test="${board.bd_num == board.bd_ori_num }">
	        	<td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">${board.bd_title}</a></td>
	        </c:if>
	        <c:if test="${board.bd_num != board.bd_ori_num }">
	        	<td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">└답변:${board.bd_title}</a></td>
	        </c:if>
	        <td>${board.bd_me_id}</td>
	        <td>${board.bd_reg_date_str}</td>
	      </tr>
      </c:forEach>
    </tbody>
  </table>
  <c:if test="${pm.criteria.page == i}">active</c:if>
  <ul class="pagination justify-content-center">
    <li class="page-item <c:if test="${!pm.prev}">disabled</c:if>">
    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}&search=${pm.criteria.search}">이전</a>
   	</li>
   	<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
	    <li class="page-item <c:if test="${pm.criteria.page == i}">active</c:if>">
	    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${i}&search=${pm.criteria.search}">${i}</a>
	   	</li>
   	</c:forEach>
    <li class="page-item <c:if test="${!pm.next}">disabled</c:if>">
    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}&search=${pm.criteria.search}">다음</a>
   	</li>
  </ul>
  <a href="<%=request.getContextPath()%>/board/register">
  	<button class="btn btn-outline-success">등록</button>
 	</a>
</body>
</html>