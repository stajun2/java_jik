<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="body container">
		<h1>게시글 등록</h1>
		<form action="<%=request.getContextPath()%>/board/register" method="post" enctype="multipart/form-data">
			<div class="form-group">
			  <input type="text" class="form-control" name="bd_title" placeholder="제목">
			</div>
			<div class="form-group">
			  <textarea class="form-control" name="bd_contents" placeholder="내용" rows="10"></textarea>
			</div>
			<div class="form-group">
				<label>첨부파일(최대 3개)</label>
			  <input type="file" class="form-control" name="files2">
			  <input type="file" class="form-control" name="files2">
			  <input type="file" class="form-control" name="files2">
			</div>
			<button class="btn btn-outline-success col-12">등록</button>
		</form>
	</div>
	<script>
    $('[name=bd_contents]').summernote({
      placeholder: 'Hello Bootstrap 4',
      tabsize: 2,
      height: 400
    });
  </script>
</body>
</html>