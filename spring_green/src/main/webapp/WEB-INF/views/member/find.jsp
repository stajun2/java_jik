<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.box-tabs{
	border:1px solid #dee2e6;
	border-color : transparent #dee2e6 #dee2e6 #dee2e6; 
}
.spinner-box{
	position : absolute; top : calc(50vh - 16px); 
	left : calc(50vw - 16px); width : 32px; height : 32px;
	display: none;
}
</style>
<body>
<ul class="nav nav-tabs find-tabs">
  <li class="nav-item">
    <a class="nav-link active" href="javascript:;" data-target=".id-box">아이디 찾기</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="javascript:;" data-target=".pw-box">비밀번호 찾기</a>
  </li>
</ul>
<div class="box-tabs">
	<div class="id-box mt-5">
		<div class="form-group">
		  <input type="text" class="form-control" name="me_email" placeholder="이메일">
		</div>
		<div class="form-group">
		  <input type="text" class="form-control" name="me_name" placeholder="이름">
		</div>
		<button class="btn btn-outline-success btn-find-id col-12">아이디 찾기</button>
	</div>
	<div class="pw-box mt-5">
		<div class="form-group">
		  <input type="text" class="form-control" name="me_email" placeholder="이메일">
		</div>
		<div class="form-group">
		  <input type="text" class="form-control" name="me_id" placeholder="아이디">
		</div>
		<button class="btn btn-outline-success btn-find-pw col-12">비밀번호 찾기</button>
	</div>
</div>
<div class="spinner-box">
	<div class="spinner-border"></div>
</div>
<script>
$('.find-tabs .nav-link').click(function(){
	$('.find-tabs .nav-link').removeClass('active');
	$(this).addClass('active');
	var target = $(this).data('target');
	$('.box-tabs>div').hide();
	$(target).show();
});
$('.btn-find-id').click(function(){
	var me_email = $('.id-box [name=me_email]').val();
	var me_name = $('.id-box [name=me_name]').val();
	var member ={
			me_email : me_email,
			me_name  : me_name
	}
	$.ajax({
	  async:false,
	  type:'POST',
	  data:JSON.stringify(member),
	  url: '<%=request.getContextPath()%>/member/find/id',
	   contentType:"application/json; charset=UTF-8",
	   success : function(res){
	     if(res == ''){
	    	 alert('일치하는 정보가 없습니다.');
	     }else{
	    	 alert('회원님의 아이디는 ' + res + '입니다.');
	     }
	   }
	});
});

$('.btn-find-pw').click(function(){
	var me_email = $('.pw-box [name=me_email]').val();
	var me_id = $('.pw-box [name=me_id]').val();
	var member = {
			me_id : me_id,
			me_email : me_email
	}
	$('.spinner-box').show();
	setTimeout(() => {
		$.ajax({
		  async:false,
		  type:'POST',
		  data:JSON.stringify(member),
		  url: '<%=request.getContextPath()%>/member/find/pw',
		   contentType:"application/json; charset=UTF-8",
		   success : function(res){
			   $('.spinner-box').hide();
			   if(res == 'ok')
		    	 alert('새 비번이 입력한 메일로 전송됐습니다.');
		     else if(res == 'fail')
		    	 alert('일치하는 정보가 없습니다.');
		     else if(res == 'error')
		    	 alert('메일 전송에 실패했습니다. 관리자에게 문의하세요.');
		   }
		});
	}, 100);
	
});

$('.find-tabs .nav-link').eq(0).click();
</script>
</body>
</html>