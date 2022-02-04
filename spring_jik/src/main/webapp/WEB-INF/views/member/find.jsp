<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.find ul{
	list-style: none; padding:0; margin:0;
}
.find .box-tabs li{
	border : 1px solid #dee2e6; border-top : none;
	min-height : 300px;
}
</style>
</head>
<body>
<div class="container find body">
	<ul class="nav nav-tabs">
	  <li class="nav-item">
	    <a class="nav-link active" href="javascript:;" data-target="#idBox">아이디 찾기</a>
	  </li>
	  <li class="nav-item" >
	    <a class="nav-link" href="javascript:;" data-target="#pwBox">비밀번호 찾기</a>
	  </li>
	</ul>
	<ul class="box-tabs">
		<li id="idBox">
			<h1>아이디 찾기</h1>
			<div class="form-group">
			  <input type="text" class="form-control" placeholder="이메일" name="me_email">
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" placeholder="이름" name="me_name">
			</div>
			<button class="btn btn-outline-success col-12 btn-find-id">찾기</button>
		</li>
		<li id="pwBox">
			<h1>비밀번호 찾기</h1>
			<div class="form-group">
			  <input type="text" class="form-control" placeholder="이메일" name="me_email">
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" placeholder="아이디" name="me_id">
			</div>
			<button class="btn btn-outline-success col-12 btn-find-pw">찾기</button>
		</li>
	</ul>
</div>
<script>
$('.find .nav-tabs a').click(function(){
	$('.find .nav-tabs a').removeClass('active');
	$(this).addClass('active');
	var target = $(this).data('target');
	$('.find .box-tabs li').hide();
	$(target).show();
});

$('.btn-find-id').click(function(){
	var me_email = $(this).parents('li').find('[name=me_email]').val();
	var me_name = $(this).parents('li').find('[name=me_name]').val();
	var member = {
			me_email : me_email,
			me_name : me_name
	}
	$.ajax({
		async:false,
		type:'POST',
		data: JSON.stringify(member),
		url: '<%=request.getContextPath()%>/member/find/id',
		contentType:"application/json; charset=UTF-8",
		success : function(res){
			if(res == ''){
				alert('일치하는 정보가 없습니다.');
			}else{
				alert('아이디는 '+res+' 입니다.');
			}
		}
	});
});

$('.find .nav-tabs a').first().click();

</script>
</body>
</html>