/**
 * 
 */

let commentService = (function(){
	
	function setContextPath(contextPath){
		this.contextPath = contextPath;
	}
	
	function ajaxGet(vo, url, success){
		$.ajax({
      async:false,
      type:'POST',
      data:JSON.stringify(vo),
      url: this.contextPath + url,
      contentType:"application/json; charset=UTF-8",
      success : function(res){
        success(res);
      }
  	});
	}
	
	return {
		name : 'CommentService',
		contextPath : '',
		setContextPath : setContextPath,
		insert : ajaxGet
	};
})();