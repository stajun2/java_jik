//롤링 기능
var issueAreaId;
issueAreaId = rollingToTop('.issue-area','li',2000, 1000);
$('.issue-area').hover(function(){
	clearInterval(issueAreaId);
},function(){
	issueAreaId = rollingToTop('.issue-area','li',2000, 1000);
});

var contentsId;

$(function(){
	contentsId = rollingToLeft('.contents-view','.contents-list','.contents-item', 2000, 1000);
	$('.container').hover(function(){
		clearInterval(contentsId);
	},function(){
		contentsId = rollingToLeft('.contents-view','.contents-list','.contents-item', 2000, 1000);
	});

	//>버튼클릭
	$('.contents-r-box2 .next-btn').click(function(e){
		e.preventDefault();
		if(!$('.contents-item').first().is(':animated')){
			var width = $('.contents-view').width();
			$('.contents-item').first().animate({marginLeft : -width}, 1000, function(){
				$(this).removeAttr('style').detach().appendTo('.contents-list');
			});
		}
	});
	//<버튼 클릭
	$('.contents-r-box2 .prev-btn').click(function(e){
		e.preventDefault();
		if(!$('.contents-item').first().is(':animated')){
			var width = $('.contents-view').width();
			$('.contents-item').last().detach().css('margin-left',-width+'px')
				.prependTo('.contents-list').animate({marginLeft : 0}, 1000);
		}
	});
});