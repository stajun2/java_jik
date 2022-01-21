<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<h1>${board.typeTitle} 등록</h1>
	<form method="post" action="<%=request.getContextPath()%>/board/register" enctype="multipart/form-data">
		<input type="hidden" name="bd_type" value="${board.bd_type }">
		<c:if test="${board.bd_ori_num != null }">
			<input type="hidden" name="bd_ori_num" value="${board.bd_ori_num }">
		</c:if>
		<div class="form-group">
		  <label>제목</label>
		  <input type="text" class="form-control" name="bd_title">
		</div>
		<div class="form-group">
		  <label>내용</label>
		  <textarea class="form-control" rows="10" name="bd_contents"></textarea>
		</div>
		<div class="form-group">
		  <label>첨부파일</label>
		  <input type="file" class="form-control" name="files2">
		  <input type="file" class="form-control" name="files2">
		  <input type="file" class="form-control" name="files2">
		</div>
		<button class="btn btn-outline-success col-12">등록</button>
	</form>
	<script>
    $('[name=bd_contents]').summernote({
      placeholder: '내용을 작성하세요.',
      tabsize: 2,
      height: 400
    });
  </script>
</body>
</html>