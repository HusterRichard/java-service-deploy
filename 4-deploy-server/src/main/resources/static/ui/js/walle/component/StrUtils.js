function StrUtils(){
	//#region format
	
	this.format = function(strMsg){
		if (!strMsg) return null;  
	    var ss = strMsg.split(/\{\d+?\}/);  
	    for ( var i = 0; i < ss.length; i++ ) {  
	        if (!arguments[i + 1]) break;  
	        ss[i] += arguments[i + 1];  
	    }  
	    return ss.join("");
	};
	
	//#endrgion
};
var strUtils = new StrUtils();