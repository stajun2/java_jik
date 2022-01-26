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
	<h1>${board.typeTitle} 상세</h1>
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
	  <div class="form-control" style="height: auto; min-height: 400px">${board.bd_contents}</div>
	</div>
	<div class="form-group">
	  <label>첨부파일</label>
	  <c:forEach items="${fileList}" var="file">
	  	<a class="form-control" href="<%=request.getContextPath()%>/board/download?fileName=${file.fi_name}">${file.fi_ori_name}</a>
	  </c:forEach>
	</div>
	<c:if test="${user.me_id == board.bd_me_id }">
		<a href="<%=request.getContextPath()%>/board/modify?bd_num=${board.bd_num}">
			<button class="btn btn-outline-success">수정</button>
		</a>
		<a href="<%=request.getContextPath()%>/board/delete?bd_num=${board.bd_num}">
			<button class="btn btn-outline-success">삭제</button>
		</a>
	</c:if>
	<!-- 현재 보고 있는 게시글이 원본 게시글 -->
	<c:if test="${board.bd_num == board.bd_ori_num && (board.bd_type == '일반' || board.bd_type == '질문')}">
		<a href="<%=request.getContextPath()%>/board/register?bd_ori_num=${board.bd_num}">
			<button class="btn btn-outline-success">답변</button>
		</a>
	</c:if>
	<!-- 현재 보고 있는 게시글이 답변 게시글 -->
	<c:if test="${board.bd_num != board.bd_ori_num && (board.bd_type == '일반' || board.bd_type == '질문')}">
		<a href="<%=request.getContextPath()%>/board/register?bd_ori_num=${board.bd_ori_num}">
			<button class="btn btn-outline-success">답변</button>
		</a>
	</c:if>
	
	<div class="input-group mb-3 mt-3">
	  <textarea class="form-control co_contents" rows="3"></textarea>
	  <div class="input-group-append">
	    <button class="btn btn-success btn-comment-insert">등록</button>
	  </div>
	</div>
	
	<script type="text/javascript">
	var contextPath = '<%=request.getContextPath()%>';
	
	$(function(){
		$('.btn-comment-insert').click(function(){
			var co_me_id = '${user.me_id}';
			if(co_me_id == ''){
				alert('댓글은 로그인한 회원만 작성 가능합니다.');
				return;
			}
			var co_contents = $('.co_contents').val();
			var co_bd_num = '${board.bd_num}';
			var comment = {
					co_me_id    : co_me_id,
					co_contents : co_contents,
					co_bd_num   : co_bd_num
			};
			$.ajax({
        async:false,
        type:'POST',
        data:JSON.stringify(comment),
        url: contextPath + "/comment/insert",
        contentType:"application/json; charset=UTF-8",
        success : function(res){
	        if(res){
	        	alert('댓글 등록이 완료 되었습니다.');
	        	$('.co_contents').val('');
	        }else{
	        	alert('댓글 등록에 실패 했습니다.');
	        }
        }
    	});
		});
	});
	
	</script>
</body>
</html>