/**
 * 
 */

let commentService = (function(){
	
	function setContextPath(contextPath){
		this.contextPath = contextPath;
	}
	
	function ajaxPost(vo, url, success){
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
	function ajaxGet(url,success){
		$.ajax({
	    async:false,
	    type:'get',
	    url:contextPath + url,
	    dataType:"json",
	    success : function(res){
        success(res);
	    }
    });
	}
	
	return {
		name : 'CommentService',
		contextPath : '',
		setContextPath : setContextPath,
		insert : ajaxPost,
		list : ajaxGet,
		delete : ajaxGet,
		modify : ajaxPost
	};
})();