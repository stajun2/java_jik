<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원가입</title>

	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<style>

	</style>
</head>
<body>
	<form class="container signup body" action="<%=request.getContextPath()%>/signup" method="post">
		<h1 class="title text-center">회원가입</h1>
		<div class="box" style="height: 100px; border: 1px solid black;">약관내용</div>
		<div class="form-group">
			<div class="form-check-inline">
				<label class="form-check-label">
					<input type="checkbox" class="form-check-input" name="agree">동의
				</label>
			</div>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="아이디" name="me_id" value="${user.me_id}">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" placeholder="비밀번호" name="me_pw" value="${user.me_pw}">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" placeholder="비밀번호확인" name="me_pw2">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="이름" name="me_name" value="${user.me_name}">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="생년월일" name="me_birth" id="birth">
		</div>
		<div class="form-group">
			<div class="form-check-inline">
				<label class="form-check-label">
					<input type="radio" class="form-check-input" name="me_gender" value="남성">남성
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label">
					<input type="radio" class="form-check-input" name="me_gender" value="여성">여성
				</label>
			</div>
		</div>
		<div class="form-group">
			<div class="form-inline mb-2">
				<input type="text" id="postcode" placeholder="우편번호" class="form-control col-6">
				<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" class="form-control col-6">
			</div>
			<input type="text" id="address" placeholder="주소" class="form-control mb-2">
			<input type="text" id="detailAddress" placeholder="상세주소" class="form-control mb-2">
			<input type="hidden" name="me_address">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="전화번호(-를 포함하여 입력하세요.)" name="me_phone">
		</div>
		<button class="btn btn-outline-success col-12">회원가입</button>
	</form>
	<script>
		$('form').submit(function(){
			var id = $('[name=me_id]').val().trim();
			var pw = $('[name=me_pw]').val().trim();
			var pw2 = $('[name=me_pw2]').val().trim();
			var name = $('[name=me_name]').val().trim();
			var birth = $('[name=me_birth]').val().trim();
			var genderObj = $('[name=me_gender]:checked');
			var gender = genderObj.length == 0 ? '' : genderObj.val();
			var isAgree = $('[name=agree]').is(':checked');
			//동의에 체크되지 않으면
			if(!isAgree){
				alert('동의에 체크해야합니다.');
				$('[name=agree]').focus();
				return false;
			}
			if(id == ''){
				alert('아이디를 입력하세요.');
				$('[name=me_id]').focus();
				return false;
			}
			if(pw == ''){
				alert('비밀번호를 입력하세요.');
				$('[name=me_pw]').focus();
				return false;
			}
			if(pw2 != pw){
				alert('비밀번호가 일치하지 않습니다.');
				$('[name=me_pw2]').focus();
				return false;
			}
			if(name == ''){
				alert('이름을 입력하세요.');
				$('[name=me_name]').focus();
				return false;
			}
			if(birth == ''){
				alert('생일을 입력하세요.');
				$('[name=me_birth]').focus();
				return false;
			}
			if(gender == ''){
				alert('성별을 선택하세요.');
				$('[name=me_gender]').focus();
				return false;
			}
			var address = $('#address').val() + ' ' +$('#detailAddress').val();
			$('[name=me_address]').val(address);
		});

		$('#birth').datepicker();
		$('#birth').datepicker('option','dateFormat', 'yy-mm-dd');

		function execDaumPostcode() {
			new daum.Postcode({
				oncomplete: function(data) {
					var addr = ''; // 주소 변수
					var extraAddr = ''; // 참고항목 변수
					if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
						addr = data.roadAddress;
					} else { // 사용자가 지번 주소를 선택했을 경우(J)
						addr = data.jibunAddress;
					}

					// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
					if(data.userSelectedType === 'R'){
						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
								extraAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if(data.buildingName !== '' && data.apartment === 'Y'){
								extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
						}
					
					} 
					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('postcode').value = data.zonecode;
					document.getElementById("address").value = addr;
					// 커서를 상세주소 필드로 이동한다.
					document.getElementById("detailAddress").focus();
				}
			}).open();
    }
	</script>
</body>
</html>