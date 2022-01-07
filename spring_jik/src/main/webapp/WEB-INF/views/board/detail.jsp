<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="body container">
		<h1>게시글 상세</h1>
		<div class="form-group">
		  <input type="text" class="form-control" name="bd_title" readonly value="${board.bd_title}">
		</div>
		<div class="form-group">
		  <input type="text" class="form-control" name="bd_me_id" readonly value="${board.bd_me_id}">
		</div>
		<div class="form-group">
		  <input type="text" class="form-control" name="bd_reg_date" readonly value="${board.bd_reg_date_str}">
		</div>
		<div class="form-group">
		  <textarea class="form-control" name="bd_contents" rows="10" readonly>${board.bd_contents}</textarea>
		</div>
	</div>
</body>
</html>