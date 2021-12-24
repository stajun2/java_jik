//더보기/접기 버튼 클릭
$('.menu-box .btn-more').on('click', function(e){
	$('.menu-box .service-btn-box').toggle();
	e.preventDefault();
	$('.service-box').toggle();
	//더보기 클릭
	if(!$(this).hasClass('fold')){
		$('.menu-box .btn-more').text('접기');
		tmpArr = arr.slice(0);
	}
	//접기 클릭
	else{
		$('.menu-box .btn-more').text('더보기');
		$('.menu-box .service-box').removeClass('set');
		$('.menu-box .service-btn-box1').show();
		$('.menu-box .service-btn-box2').hide();
		tmpArr = [];
		checkMenu(arr);
		if(arr.length == 0){
			drawMenu(baseArr, false);
		}else{
			drawMenu(arr, false);
		}
	}
	$(this).toggleClass('fold');
});
//메뉴 설정 버튼 클릭
$('.menu-box .btn-service-set').click(function(e){
	e.preventDefault();
	$('.menu-box .service-box').addClass('set');
	$('.menu-box .service-btn-box1').hide();
	$('.menu-box .service-btn-box2').show();

	$('.black-menu-box .menu-item').addClass('set');
	//수정 필요
	drawMenu(arr,true);
});
var maxBlackMenuCount = 4;
var baseArr = ['사전','뉴스', '증권', '부동산', '지도', 'VIBE', '책', '웹툰'];
var arr = [];//저장 버튼을 클릭하여 저장된 메뉴, 초기화 버튼을 눌렀을 때 빈 배열로 만듬
var tmpArr = [];//메뉴설정 버튼을 클릭한후, 선택한 메뉴들
//메뉴 선택
$('.menu-box .check-menu').click(function(){
	var value = $(this).val();
	if($(this).is(':checked')){
		if(tmpArr.length < maxBlackMenuCount){
			tmpArr.push(value);
		}else{
			alert('최대 ' +maxBlackMenuCount +'개 선택이 가능합니다.');
			$(this).prop('checked',false);
		}
	}else{
		var index = tmpArr.indexOf(value);
		tmpArr.splice(index, 1);
	}
	drawMenu(tmpArr, true);
});
//저장
$('.btn-service-save').click(function(){
	arr = tmpArr;
	if(arr.length == 0){
		alert('선택된 메뉴가 없습니다. 초기화합니다.');
	}
	$('.btn-more').click();
});
//초기화
$('.btn-service-init').click(function(){
	arr = [];
	alert('초기화합니다.');
	$('.btn-more').click();
});
/* arr : 검은 메뉴를 출력한 메뉴들이 담긴 배열
	 isDrawBox : 
		- 메뉴가 출력되고 남은 부분들을 테두리 박스로 체울지 말지를 결정하는 변수,
		- 메뉴 선택 중일때 true, 선택중이 아닐때 false
*/
function drawMenu(arr1, isDrawBox){
	//모든 검은 메뉴를 보여주고, 박스 테두리와 녹색 테두리를 제거
	$('.black-menu-box .menu-item').show();
	$('.black-menu-box .menu-item').removeClass('set focus');

	$('.black-menu-box .menu-item').each(function(index){
		if(index < arr1.length){
			if(isDrawBox){
				//글자로 채움
				$(this).text(arr1[index]);
			}else{
				//a태그로 채움
				var blackMenuItem = '<a href="#" class="menu-link">'+arr1[index]+'</a>';
				$(this).html(blackMenuItem);
			}
		}
		else{
			//박스를 그릴 때 박스 포함 메뉴가 최대 4개가 되도록 해야함
			if(isDrawBox && index < maxBlackMenuCount){
				$(this).addClass('set').text('');
			}else{
				$(this).removeClass('set').text('').hide();
			}
		}
		$('.black-menu-box .menu-item.set').first().addClass('focus');
	});
}
//주어진 배열에 맞는 체크박스 체크상황을 설정하는 함수
function checkMenu(arr){
	$('.menu-box .check-menu').each(function(){
		var value = $(this).val();
		$(this).prop('checked', arr.indexOf(value) != -1);
	});
}