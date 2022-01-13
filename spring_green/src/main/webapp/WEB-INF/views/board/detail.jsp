<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 상세</h1>
	<div class="form-group">
	  <label>제목</label>
	  <input type="text" class="form-control" value="${board.bd_title}" readonly>
	</div>
	<div class="form-group">
	  <label>작성자</label>
	  <input type="text" class="form-control" value="${board.bd_me_id}" readonly>
	</div>
	<div class="form-group">
	  <label>작성일</label>
	  <input type="text" class="form-control" value="${board.bd_reg_date_str}" readonly>
	</div>
	<div class="form-group">
	  <label>내용</label>
	  <textarea class="form-control" rows="10" readonly>${board.bd_contents}</textarea>
	</div>
</body>
</html>