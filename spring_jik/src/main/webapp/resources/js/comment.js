/**
 * 
 */
let commentService = (function(){
	//contextPath 설정
	function setContextPath(contextPath){
		this.contextPath = contextPath;
	}
	
	//ajax Post 방식으로 object로 전달해서 object로 받는 메소드
	function ajaxPostJsonToJson(url, comment, success){
		$.ajax({
			async:false,
			type:'POST',
			data: JSON.stringify(comment),
			url: this.contextPath + url,
			dataType:"json",
			contentType:"application/json; charset=UTF-8",
			success : function(res){
				success(res);
			}
		});
	}
	//ajax Get 방식으로 url에 데이터를 전달하여 object로 받는 메소드
	function ajaxGetJson(url, success){
		$.ajax({
			async:false,
			type:'get',
			url: this.contextPath + url,
			dataType:"json",
			success : function(res){
				success(res);
			}
		});
	}
	
	return {
		name : 'commentService',
		contextPath : '',
		setContextPath : setContextPath,
		insert : ajaxPostJsonToJson,
		modify : ajaxPostJsonToJson,
		list : ajaxGetJson,
		delete : ajaxGetJson
	}
})();