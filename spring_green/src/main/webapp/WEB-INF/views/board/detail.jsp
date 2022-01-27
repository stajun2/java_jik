<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="<%=request.getContextPath()%>/resources/js/comment.js"></script>
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
	
	<div class="comment-list">
		
	</div>
	<div class="comment-pagination">
		
	</div>
	
	<div class="input-group mb-3 mt-3">
	  <textarea class="form-control co_contents" rows="3"></textarea>
	  <div class="input-group-append">
	    <button class="btn btn-success btn-comment-insert">등록</button>
	  </div>
	</div>
	
	<script type="text/javascript">
	var contextPath = '<%=request.getContextPath()%>';
	commentService.setContextPath(contextPath);
	$(function(){
		$('.btn-comment-insert').click(function(){
			var co_me_id = '${user.me_id}';
			if(co_me_id == ''){
				alert('댓글은 로그인한 회원만 작성 가능합니다.');
				return;
			}
			var co_contents = $('textarea.co_contents').val();
			var co_bd_num = '${board.bd_num}';
			var comment = {
					co_me_id    : co_me_id,
					co_contents : co_contents,
					co_bd_num   : co_bd_num
			};
			
			if(co_contents == ''){
				alert('댓글을 입력하세요.');
				return;
			}
			
			commentService.insert(comment, '/comment/insert',insertSuccess);
		});
		
		$(document).on('click', '.comment-pagination .page-item', function(){
			
			if($(this).hasClass('disabled')){
				return;
			}
			var page = $(this).data('page');
			//댓글 새로고침
			var listUrl = '/comment/list?page='+page+'&bd_num='+'${board.bd_num}';
			commentService.list(listUrl,listSuccess);
		});
		
		$(document).on('click', '.btn-del-comment',function(){
			var co_num = $(this).data('num');
			var deleteUrl = '/comment/delete?co_num=' + co_num;
			commentService.delete(deleteUrl, deleteSuccess);
		});
		
		$(document).on('click', '.btn-mod-comment',function(){
			//댓글 초기화
			commentInit();
			$(this).parent().children('button').hide();
			$(this).siblings('.co_contents').hide();
			var text = $(this).siblings('.co_contents').text();
			var textarea 
				= '<textarea class="form-control co_contents2">'+text+'</textarea>';
			$(this).siblings('.co_contents').after(textarea);
			var button
				= '<button class="btn btn-outline-info btn-mod-insert">댓글 수정</button>'
			$(this).siblings('.co_reg_date').after(button);
		});
		
		//화면 로딩 준비가 끝나면 댓글 불러옴
		var listUrl = '/comment/list?page=1&bd_num='+'${board.bd_num}';
		commentService.list(listUrl,listSuccess);
	});
	
	function getDateToString(date){
		return "" + 
			date.getFullYear()  + "-" + 
			(date.getMonth()+1) + "-" +
			date.getDate()      + " " +
			date.getHours()     + ":" +
			date.getMinutes();
	}
	
	function commentInit(){
		$('.comment-box').each(function(){
			$(this).find('.co_contents2').remove();
			$(this).find('.btn-mod-insert').remove();
			$(this).find('button').show();
			$(this).find('.co_contents').show();
		});
	}
	
	function deleteSuccess(res){
		if(res){
			alert('댓글을 삭제했습니다.')
			var listUrl = '/comment/list?page=1&bd_num='+'${board.bd_num}';
			commentService.list(listUrl,listSuccess);
		}else{
			alert('댓글 삭제에 실패했습니다.')
		}
	}
	
	function listSuccess(res){
		var str = '';
    var me_id = '${user.me_id}';
    if(res.list.length == 0){
    	$('.comment-list').html('');
    	$('.comment-pagination').html('');
    	return;
    }
    for(tmp of res.list){
    	str += createComment(tmp, me_id);
    }
    $('.comment-list').html(str);
    
    var paginationStr = createPagenation(res.pm);
    $('.comment-pagination').html(paginationStr);
	}
	function insertSuccess(res){
		if(res){
	   	alert('댓글 등록이 완료 되었습니다.');
	   	$('.co_contents').val('');
	   	var listUrl = '/comment/list?page=1&bd_num='+'${board.bd_num}';
			commentService.list(listUrl,listSuccess);
   	}else{
	   	alert('댓글 등록에 실패 했습니다.');
   	}
	}
	function createComment(comment, me_id){
		var co_reg_date = getDateToString(new Date(comment.co_reg_date));
		var str = '';
		str+=	'<div class="comment-box clearfix">'
		
		if(comment.co_ori_num != comment.co_num){
		str+=		'<div class="float-left" style="width:24px">└</div>'
		str+=		'<div class="float-left" style="width: calc(100% - 24px)">'
		}else{
		str+=		'<div class="float-left" style="width: 100%">'
		}
		str+=			'<div class="co_me_id">'+comment.co_me_id+'</div>'
		str+=			'<div class="co_contents">'+comment.co_contents+'</div>'
		str+=			'<div class="co_reg_date">'+co_reg_date+'</div>'
		if(comment.co_ori_num == comment.co_num)
		str+=			'<button class="btn btn-outline-success btn-rep-comment mr-2">답글</button>'
		if(comment.co_me_id == me_id){
		str+=			'<button class="btn btn-outline-dark btn-mod-comment mr-2" data-num="'+comment.co_num+'">수정</button>'
		str+=			'<button class="btn btn-outline-danger btn-del-comment" data-num="'+comment.co_num+'">삭제</button>'
		}
		str+=		'</div>'
		str+=		'<hr class="float-left" style="width:100%">'
		str+=	'</div>'
		return str;
	}
	function createPagenation(pm){
		var str = '';
		var prevDisabled = pm.prev ? '' : 'disabled';
		var nextDisabled = pm.next ? '' : 'disabled';
		var page = pm.criteria.page;
		
		str+=	'<ul class="pagination justify-content-center">'
		str+=    '<li class="page-item '+prevDisabled+'" data-page="'+(pm.startPage - 1)+'"><a class="page-link" href="javascript:;">이전</a></li>'
		for(i = pm.startPage; i<= pm.endPage; i++){
			var active = page == i ? 'active' : '';
		str+=    '<li class="page-item '+ active +'" data-page="'+i+'"><a class="page-link" href="javascript:;">'+i+'</a></li>'
		}
		str+=    '<li class="page-item '+nextDisabled+'" data-page="'+(pm.endPage + 1)+'"><a class="page-link" href="javascript:;">다음</a></li>'
		str+=  '</ul>'
		return str;
	}
	</script>
</body>
</html>