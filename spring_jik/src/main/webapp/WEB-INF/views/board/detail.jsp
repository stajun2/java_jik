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
		<c:if test="${board != null}">
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
			  <div class="form-control" style="min-height:300px; height:auto;">${board.bd_contents}</div>
			</div>
			<div class="form-group">
				<c:if test="${files != null && files.size() != 0 }">
					<label>첨부파일</label>
					<c:forEach items="${files}" var="file">
						<a href="<%=request.getContextPath()%>/board/download?fileName=${file.fi_name}" class="form-control">${file.fi_ori_name}</a>
					</c:forEach>
				</c:if>
				<c:if test="${files == null || files.size() == 0}">
					<label>첨부파일 없음</label>	
				</c:if>
			</div>
			<c:if test="${user != null && user.me_id == board.bd_me_id}">
				<a href="<%=request.getContextPath()%>/board/modify?bd_num=${board.bd_num}">
					<button class="btn btn-outline-success">수정</button>
				</a>
				<a href="<%=request.getContextPath()%>/board/delete?bd_num=${board.bd_num}">
					<button class="btn btn-outline-success">삭제</button>
				</a>
			</c:if>
			<c:if test="${board.bd_type != '공지' && board.bd_num == board.bd_ori_num }">
				<a href="<%=request.getContextPath()%>/board/register?bd_ori_num=${board.bd_num}">
					<button class="btn btn-outline-success">답변</button>
				</a>
			</c:if>
		</c:if>
		<c:if test="${board == null}">
			<h1>없는 게시글이거나 삭제된 게시글입니다.</h1>
		</c:if>
		<div class="comment-list mt-3">
			<div class="comment-box">
				<div class="co_me_id">qwe</div>
				<div class="co_contents mt-2">댓글 내용</div>
				<div class="co_reg_date mt-2">2022-01-24</div>
				<button class="btn-reply-comment btn btn-outline-success">답글</button>
			</div>
		</div>
		<div class="comment-pagination mt-3"></div>
		<div class="comment-box mt-3">
			<div class="input-group mb-3">
			  <textarea class="form-control text-comment" placeholder="댓글입력"></textarea>
			  <div class="input-group-append">
			    <button class="btn btn-outline-success btn-comment">등록</button>
			  </div>
			</div>
		</div>
	</div>
	<script>
		$(function(){
			$('.btn-comment').click(function(){
				var user = '${user}';
				if(user == ''){
					alert('로그인 후 댓글 등록이 가능합니다.')
					return;
				}	
				//댓글 내용 가져오기
				var co_contents = $('.text-comment').val();
				//게시글 번호를 가져오기
				var co_bd_num = '${board.bd_num}';
				//댓글 원본 번호(나중에)
				
				var comment = {
					co_contents : co_contents,
					co_bd_num : co_bd_num
				};
				
				$.ajax({
					async:false,
					type:'POST',
					data: JSON.stringify(comment),
					url:"<%=request.getContextPath()%>/comment/insert",
					dataType:"json",
					contentType:"application/json; charset=UTF-8",
					success : function(res){
						if(res == true){
							$('.text-comment').val('');
							alert('댓글 등록이 완료되었습니다.');
							//새로운 댓글들을 가져옴
							readComment(co_bd_num);
						}else{
							alert('댓글 등록에 실패했습니다.');
						}
					}
				});
			});
		});
		var co_bd_num = '${board.bd_num}';
		readComment(co_bd_num);
		
		//Date 객체를 yyyy-MM-dd hh:mm형태의 문자열로 변환하는 함수
		function getDateStr(date){
			var year = date.getFullYear();
			var month = date.getMonth() + 1;
			var day = date.getDate();
			var hour = date.getHours();
			var minute = date.getMinutes();
			return year + "-" + month + "-" + day + " " + hour + ":" + minute;
		}
		function createCommentStr(co_me_id, co_contents, co_reg_date){
			return '' + 
			'<div class="comment-box">' +
				'<div class="co_me_id">'+co_me_id+'</div>' +
				'<div class="co_contents mt-2">'+co_contents+'</div>' + 
				'<div class="co_reg_date mt-2">'+co_reg_date+'</div>' +
				'<button class="btn-reply-comment btn btn-outline-success">답글</button>'+
				'<hr>'+
			'</div>';
		}
		function readComment(co_bd_num){
			if(co_bd_num != ''){
				$.ajax({
					async:false,
					type:'get',
					url:"<%=request.getContextPath()%>/comment/list?co_bd_num="+co_bd_num,
					dataType:"json",
					success : function(res){
						var str = '';
				    for(tmp of res){
				    	var date = new Date(tmp.co_reg_date);
				    	str +=
				    		createCommentStr(tmp.co_me_id, tmp.co_contents, getDateStr(date) );
				    }
				    $('.comment-list').html(str);
					}
				});
			}
		}
	</script>
</body>
</html>