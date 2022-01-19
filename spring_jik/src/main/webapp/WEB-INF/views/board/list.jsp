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
		<c:if test="${pm.criteria.type != null && pm.criteria.type == '일반' }">
			<h1>게시글</h1>
		</c:if>
		<c:if test="${pm.criteria.type != null && pm.criteria.type == '공지'}">
			<h1>공지사항</h1>
		</c:if>
		<form class="input-group mb-3" action="<%=request.getContextPath()%>/board/list">
		  <input type="text" class="form-control" name="search" placeholder="검색어를 입력하세요." value="${pm.criteria.search }">
		  <div class="input-group-append">
		    <button class="btn btn-success" type="submit">검색</button>
		  </div>
		  <input type="hidden" name="type" value="${pm.criteria.type }">
		</form>
		<table class="table table-warning table-hover">
	    <thead>
	      <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>작성날짜</th>
	        <th>조회수</th>
	      </tr>
	    </thead>
	    <tbody>
	    	<!-- 
	    		varStatus="vs" 일때
	    		vs.index : 0부터 시작해서 현재 반복된 횟수
	    		vs.count : 1부터 시작해서 현재 반복된 횟수
	    	-->
	    	<c:forEach items="${list}" var="board" varStatus="vs">
		      <tr>
		        <td>${pm.totalCount - pm.criteria.pageStart - vs.index }</td>
		        <c:if test="${board.bd_num == board.bd_ori_num }">
		        	<td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">${board.bd_title}</a></td>
		        </c:if>
		        <c:if test="${board.bd_num != board.bd_ori_num }">
		        	<td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">└답변:${board.bd_title}</a></td>
		        </c:if>
		        <td>${board.bd_me_id}</td>
		        <td>${board.bd_reg_date_str}</td>
		        <td>${board.bd_views}</td>
		      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
   	<ul class="pagination justify-content-center">
   		<c:if test="${pm.prev}">
		    <li class="page-item">
		    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.criteria.page-1}&search=${pm.criteria.search}&type=${pm.criteria.type}">이전</a>
		    </li>
	    </c:if>
	    <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
	    	<c:if test="${i != pm.criteria.page }">
			    <li class="page-item">
			    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${i}&search=${pm.criteria.search}&type=${pm.criteria.type}">${i}</a>
			    </li>
		    </c:if>
		    <c:if test="${i == pm.criteria.page }">
			    <li class="page-item active">
			    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${i}&search=${pm.criteria.search}&type=${pm.criteria.type}">${i}</a>
			    </li>
		    </c:if>
	    </c:forEach>
	    <c:if test="${pm.next}">
		    <li class="page-item">
		    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.criteria.page+1}&search=${pm.criteria.search}&type=${pm.criteria.type}">다음</a>
		    </li>
	    </c:if>
	  </ul>
	  <c:if test="${user != null}">
	  <a href="<%=request.getContextPath()%>/board/register?bd_type=${pm.criteria.type}">
	  	<button class="btn btn-outline-success">글쓰기</button>
	  </a>
	  </c:if>
	</div>
</body>
</html>