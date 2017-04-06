function AjaxUtils(){
	//#region post
	
	this.postAjax = function(strUrl, oData, 
			oDelegateSuccessFunc, oDelegateErrorFunc){
		$.ajax({
            url: strUrl,
            contentType: "application/json",
            type: 'POST', //GET
            async: true,    //或false,是否异步
            data: JSON.stringify(oData),
            //timeout: 5000,    //超时时间
            dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
            success: function (res) {
                if (oDelegateSuccessFunc) {
                    oDelegateSuccessFunc(res);
                }
            },
            error: function (xhr) {
                if (oDelegateErrorFunc) {
                    oDelegateErrorFunc(xhr);
                }
            }
        });
	};
	
	//#endrgion
	
	//#region json2Str
	
	this.json2Str = function(oJsonObj){
		var strRes = JSON.stringify(oJsonObj);
		return strRes;
	};
	
	//#endregion
	
	//#region str2Json
	
	this.str2Json = function(strJsonObj){
		var oRes = $.parseJSON(strJsonObj);
		return strRes;
	};
	
	//#endregion
};
var ajaxUtils = new AjaxUtils();