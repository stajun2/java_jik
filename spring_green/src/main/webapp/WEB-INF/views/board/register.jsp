<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 등록</h1>
	<form method="post" action="<%=request.getContextPath()%>/board/register">
		<div class="form-group">
		  <label>제목</label>
		  <input type="text" class="form-control" name="bd_title">
		</div>
		<div class="form-group">
		  <label>내용</label>
		  <textarea class="form-control" rows="10" name="bd_contents"></textarea>
		</div>
		<button class="btn btn-outline-success col-12">등록</button>
	</form>
</body>
</html>