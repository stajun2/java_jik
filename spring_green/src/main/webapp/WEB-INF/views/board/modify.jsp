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
	<h1>게시글 수정</h1>
	<form method="post" action="<%=request.getContextPath()%>/board/modify" enctype="multipart/form-data">
		<div class="form-group">
		  <label>제목</label>
		  <input type="text" class="form-control" name="bd_title" value="${board.bd_title}">
		</div>
		<div class="form-group">
		  <label>내용</label>
		  <textarea class="form-control" rows="10" name="bd_contents">${board.bd_contents }</textarea>
		</div>
		<input type="hidden" name="bd_num" value="${board.bd_num}">
		<div class="form-group attachment">
		  <label>첨부파일</label>
		  <c:forEach items="${fileList}" var="file">
			  <div class="form-control">
			  	<span>${file.fi_ori_name }</span>
			  	<a class="btn-close" href="#">X</a>
			  	<input type="hidden" name="fileNums" value="${file.fi_num}">
			  </div>
		  </c:forEach>
		  <c:forEach begin="1" end="${3 - fileList.size()}">
		  	<input type="file" name="files2" class="form-control">
		  </c:forEach>
		</div>
		<button class="btn btn-outline-success col-12">등록</button>
	</form>
	<script type="text/javascript">
		$(function () {
			$('.attachment .btn-close').click(function(e){
				e.preventDefault();
				var str = '<input type="file" name="files2" class="form-control">';
				$('.attachment').append(str);
				$(this).parent().remove();
			});
			$('[name=bd_contents]').summernote({
	      placeholder: '내용을 작성하세요.',
	      tabsize: 2,
	      height: 400
	    });
		});
	</script>
</body>
</html>