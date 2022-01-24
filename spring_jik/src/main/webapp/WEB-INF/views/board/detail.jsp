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
		<hr class="mt-3">
		<div class="comment-list mt-3">
			<div class="comment-box">
				<div class="co_me_id">qwe</div>
				<div class="co_contents mt-2">댓글 내용</div>
				<div class="co_reg_date mt-2">2022-01-24</div>
				<button class="btn-reply-comment btn btn-outline-success">답글</button>
			</div>
		</div>
		<div class="comment-pagination mt-3">
			<ul class="pagination justify-content-center">
		    <li class="page-item"><a class="page-link" href="javascript:void(0);" data-page="">이전</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:void(0);" data-page="1">1</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:void(0);" data-page="2">2</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:void(0);" data-page="">다음</a></li>
		  </ul>
		</div>
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
				
				if(co_contents == ''){
					alert('댓글 내용을 입력하세요.');
					return;
				}
					
				
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
							readComment(co_bd_num, 1);
						}else{
							alert('댓글 등록에 실패했습니다.');
						}
					}
				});
			});
		});
		//요소에 이벤트를 등록하는게 아니라 document에 등록해서 요소가 나중에 추가되도
		//해당 선택자만 맞으면 이벤트가 실행됨
		$(document).on('click','.comment-pagination .page-link', function(){
			var co_bd_num = '${board.bd_num}';
			var page = $(this).data('page');
			readComment(co_bd_num, page);
		});
		
		//댓글 삭제
		$(document).on('click','.comment-list .btn-del-comment', function(){
			var co_num = $(this).data('num');
			if(co_num != ''){
				$.ajax({
					async:false,
					type:'get',
					url:"<%=request.getContextPath()%>/comment/delete?co_num="+co_num,
					dataType:"json",
					success : function(res){
						var co_bd_num = '${board.bd_num}';
						readComment(co_bd_num, 1);
					}
				});
			}
		});
		
		
		//화면 로딩 후 댓글과 댓글 페이지네이션 배치
		var co_bd_num = '${board.bd_num}';
		readComment(co_bd_num, 1);
		
		
		
		
		//함수들 모음
		
		//Date 객체를 yyyy-MM-dd hh:mm형태의 문자열로 변환하는 함수
		function getDateStr(date){
			var year = date.getFullYear();
			var month = date.getMonth() + 1;
			var day = date.getDate();
			var hour = date.getHours();
			var minute = date.getMinutes();
			return year + "-" + month + "-" + day + " " + hour + ":" + minute;
		}
		function createCommentStr(co_me_id, co_contents, co_reg_date, co_num){
			var str =  
			'<div class="comment-box">' +
				'<div class="co_me_id">'+co_me_id+'</div>' +
				'<div class="co_contents mt-2">'+co_contents+'</div>' + 
				'<div class="co_reg_date mt-2">'+co_reg_date+'</div>' +
				'<button class="btn-reply-comment btn btn-outline-danger">답글</button>';
				if('${user.me_id}' == co_me_id){
					str +=
						'<button class="btn-mod-comment btn btn-outline-warning ml-2" data-num="'+co_num+'">수정</button>'+
						'<button class="btn-del-comment btn btn-outline-info ml-2" data-num="'+co_num+'">삭제</button>';
				}
				
				str+=
				'<hr>'+
			'</div>';
			return str;
		}
		function readComment(co_bd_num, page){
			if(co_bd_num != ''){
				$.ajax({
					async:false,
					type:'get',
					url:"<%=request.getContextPath()%>/comment/list?co_bd_num="+co_bd_num + '&page='+page,
					dataType:"json",
					success : function(res){
						var str = '';
				    for(tmp of res.list){
				    	var date = new Date(tmp.co_reg_date);
				    	str +=
				    		createCommentStr(tmp.co_me_id, tmp.co_contents, getDateStr(date), tmp.co_num );
				    }
				    $('.comment-list').html(str);
				    //페이지네이션 생성
				    var paginationStr = createCommentPagination(res.pm);
				    $('.comment-pagination').html(paginationStr);
					}
				});
			}
		}
		function createCommentPagination(pm){
			var str = ''
			str +=
			'<ul class="pagination justify-content-center">';
			var startDisabled = pm.prev ? '' : 'disabled';
			var endDisabled = pm.next ? '' : 'disabled';
			
		  str += '<li class="page-item '+startDisabled+'"><a class="page-link" href="javascript:void(0);" data-page="'+(pm.criteria.page-1)+'">이전</a></li>';
	    for(i = pm.startPage; i<= pm.endPage; i++){
	    	var currentActive = pm.criteria.page == i ? 'active' : '';
		    str += '<li class="page-item '+currentActive+'"><a class="page-link" href="javascript:void(0);" data-page="'+i+'">'+i+'</a></li>';
	    }
	    str += '<li class="page-item '+endDisabled+'"><a class="page-link" href="javascript:void(0);" data-page="'+(pm.criteria.page+1)+'">다음</a></li>';
		  str +='</ul>';
		  return str;
		}
	</script>
</body>
</html>