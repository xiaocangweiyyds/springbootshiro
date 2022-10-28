//定义一个jquery的函数,名叫getUrlParam  参数是一个
(function ($) {
	 $.getUrlParam = function (name) {
	        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	        var r = window.location.search.substr(1).match(reg);
	        if (r != null) return unescape(r[2]); return null;
     }
})(jQuery);