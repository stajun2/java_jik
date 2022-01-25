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
			
			//등록 버튼(댓글등록)을 클릭
			$('.btn-comment').click(function(){
				//로그인한 회원만 댓글 등록이 가능하게 하기 위해
				//회원 아이디를 가져옴
				var user = '${user.me_id}';
				//아이디가 없으면 로그인 안한 상태이기 때문에 로그인하라고 알려줌
				if(user == ''){
					alert('로그인 후 댓글 등록이 가능합니다.')
					return;
				}	
				//댓글 내용 가져오기
				var co_contents = $('.text-comment').val();
				//게시글 번호를 가져오기
				var co_bd_num = '${board.bd_num}';
				//댓글 원본 번호(나중에)
				
				//댓글 내용이 없는 경우 알림창 띄우고 등록하지 않음
				if(co_contents == ''){
					alert('댓글 내용을 입력하세요.');
					return;
				}
					
				//ajax로 댓글 정보를 보내기 위해 객체를 만듬
				//이 때 만들어지는 객체의 속성명을 CommetVO의 멤버 변수 이름과 일치시킴
				var comment = {
					co_contents : co_contents,
					co_bd_num : co_bd_num
				};
				//댓글을 등록하기 위해 ajax로 서버에 데이터를 전송
				$.ajax({
					//동기화 : 다 끝날때까지 기다림
					async:false,
					type:'POST',
					//서버로 보낸 객체가 VO에 잘 달김게 하기 위해 변형
					data: JSON.stringify(comment),
					url:"<%=request.getContextPath()%>/comment/insert",
					//서버에서 보낸 데이터의 타입
					dataType:"json",
					//화면이 서버로 보낸 데이터의 타입
					contentType:"application/json; charset=UTF-8",
					//ajax 성공시
					success : function(res){
						//댓글 등록에 성공하면
						if(res == true){
							//입력한 댓글을 지워줌
							$('.text-comment').val('');
							alert('댓글 등록이 완료되었습니다.');
							//새로고침(전체가 아닌 댓글부분만)을 해서 1페이지에 맞는 댓글을 가져옴
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
			//삭제할 댓글 번호는 삭제 버튼에 data-num속성값으로 입력되어 있음
			//삭제할 댓글 번호를 가져옴. data()를 이용
			//data()메소드는 data-xxx인 속성들의 값을 가져올 때 사용
			//data(xxx)로 하면 data-xxx와 일치하는 속성의 값을 가져옴
			var co_num = $(this).data('num');
			//삭제할 댓글 번호가 있는 경우만 삭제
			if(co_num != ''){
				$.ajax({
					async:false,
					//삭제할 댓글 번호는 url에 노출되도 큰 문제가 없음. 그래서 get으로 보냄
					type:'get',
					url:"<%=request.getContextPath()%>/comment/delete?co_num="+co_num,
					dataType:"json",
					success : function(res){
						//삭제가 완료되면 댓글을 새로고침(1페이지)
						var co_bd_num = '${board.bd_num}';
						readComment(co_bd_num, 1);
					}
				});
			}
		});
		
		
		//댓글 수정 버튼
		$(document).on('click','.comment-list .btn-mod-comment', function(){
			//이전에 생긴(댓글 수정버튼을 클릭해서 생긴) textarea태그와 등록버튼을 제거하고,
			//감춘 답글, 수정, 삭제 버튼을 추가함
			$('.co_contents2').each(function(){
				//수정하기전 댓글을 다시 보여줌
				$(this).siblings('.co_contents').show();
				//답변, (수정, 삭제)버튼을 보여줌
				$(this).parent().children('button').show();
				//등록 버튼을 없앰(댓글 수정을 위한 등록 버튼)
				$(this).siblings('.btn-mod-comment2').remove();
				//textarea태그를 제거(수정하기 위한 입력창)
				$(this).remove();
			});
			//등록된 댓글 내용을 가져옴(수정 전). textarea태그 안에 넣어주기 위해
			var contents = $(this).siblings('.co_contents').text();
			//textarea태그를 꾸며주기 위한 html
			var str = 
				'<div class="form-group co_contents2 mt-2">'+ 
					'<textarea class="form-control">'+contents+'</textarea>' +
				'</div>';
			//등록 버튼을 위한 html(수정 완료를 위한 버튼)
			var btnStr = 
				'<button class="btn-mod-comment2 btn btn-outline-warning ml-2">'+
					'등록'+
				'</button>'
			//기존 댓글을 감춤
			$(this).siblings('.co_contents').hide();
			//답글, 수정, 삭제 버튼을 감춤
			$(this).parent().children('button').hide();
			//textarea태그를 아이디 밑에 배치
			$(this).siblings('.co_me_id').after(str);
			//등록 버튼을 날짜 밑에 배치
			$(this).siblings('.co_reg_date').after(btnStr);
		});
		
		
		//수정 버튼 눌렀을 때 생기는 등록 버튼 클릭이벤트
		$(document).on('click','.comment-list .btn-mod-comment2', function(){
			//수정된 댓글 내용
			var co_contents = $(this).siblings('.co_contents2').children().val();
			
			//수정할 댓글 번호
			var co_num = $(this).siblings('[name=co_num]').val();
			//수정된 댓글 내용과 번호를 이용하여 객체를 만듬. 서버로 전송하기 위해
			var comment ={
					co_num : co_num,
					co_contents : co_contents
			}
			$.ajax({
				async:false,
				type:'POST',
				data: JSON.stringify(comment),
				url:"<%=request.getContextPath()%>/comment/modify",
				dataType:"json",
				contentType:"application/json; charset=UTF-8",
				success : function(res){
					//수정에 성공하면
					if(res){	
				    var page = $('.comment-pagination .active').text();
				    var co_bd_num = '${board.bd_num}';
				    //현재 페이지와 게시글 번호에 맞게 댓글을 새로고침
						readComment(co_bd_num, page);
					}else{
						alert('댓글 수정이 실패했습니다.');
					}
				}
			});
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
		function createCommentStr(comment, co_reg_date){
			var str =  
			'<div class="comment-box">' +
				'<input type="hidden" name="co_num" value="'+comment.co_num+'">'+
				'<div class="co_me_id">'+comment.co_me_id+'</div>' +
				'<div class="co_contents mt-2">'+comment.co_contents+'</div>' + 
				'<div class="co_reg_date mt-2">'+co_reg_date+'</div>' +
				'<button class="btn-reply-comment btn btn-outline-danger">답글</button>';
				if('${user.me_id}' == comment.co_me_id){
					str +=
						'<button class="btn-mod-comment btn btn-outline-warning ml-2" data-num="'+comment.co_num+'">수정</button>'+
						'<button class="btn-del-comment btn btn-outline-info ml-2" data-num="'+comment.co_num+'">삭제</button>';
				}
				
				str+=
				'<hr>'+
			'</div>';
			return str;
		}
		//게시글에 댓글 중 page 번호에 맞는 댓글을 가져와서 화면에 배치하는 함수
		function readComment(co_bd_num, page){
			//게시글 번호가 없으면 가져올 게시글이 없어서 작업하지 않음
			if(co_bd_num != ''){
				$.ajax({
					async:false,
					//get방식으로 url에 정보를 다 포함해서 보냄
					type:'get',
					url:"<%=request.getContextPath()%>/comment/list?co_bd_num="+co_bd_num + '&page='+page,
					//서버에서 보낸 데이터의 타입
					dataType:"json",
					//ajax가 성공적으로 완료되면 서버에서 보낸 댓글 리스트와 페이지메이커를 res에 담음
					success : function(res){
						//res.list : 댓글 리스트(페이지번호에 맞는)
						//res.pm : 댓글의 페이지메이커
						var str = '';
						//댓글을 하나씩 가져와서 html로 이루어진 문자열을 만든 후 이어 붙임
				    for(tmp of res.list){
				    	//정수로 넘어온 댓글 날짜를 날짜타입으로 변환 
				    	var date = new Date(tmp.co_reg_date);
				    	//댓글정보를 html로 만들어진 문자열로 만든 후 이어 붙임
				    	str +=
				    		createCommentStr(tmp, getDateStr(date));
				    }
						//html로 된 댓글들을 지정된 위치에 배치
				    $('.comment-list').html(str);
				    //서버에서 보낸 페이지메이커를 이용하여 html로 이루어진 페이지네이션을 만듬 
				    var paginationStr = createCommentPagination(res.pm);
				    //만들어진 html 페이지네이션을 배치
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