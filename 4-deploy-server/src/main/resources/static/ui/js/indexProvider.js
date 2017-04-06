(function($){
	$.IndexProvider = function(){
		//#region Const
		
		var TEMPLATE_ROW = '<tr class="success">'+
'			<th scope="row">{0}</th>'+
'			<td>{1}</td>'+
'			<td>{2}</td>'+
'			<td>{3}</td>'+
'			<td>'+
'		 	</td>'+
'        </tr>';
		
		//#endregion
		
		//#region getAllDeployClients
		
		this.getAllInstances = function(){
			var strUrl = "/getAllDeployClients";
			var oParams = {};
			ajaxUtils.postAjax(strUrl, oParams, function(oRes){
				$.each(oRes, function(i, oServiceVo){
					// 1.init row
					var strRowId = oServiceVo.port + "_row";
					var oRowProvider = new $.BTTblRowProvider();
					oRowProvider.init(strRowId);
					
					// 2.append id/serivceType/ip/port
					oRowProvider.append(""+i)
						.append(oServiceVo.serviceType)
						.append(oServiceVo.ip)
						.append(oServiceVo.port);
					
					// 3.draw operation oBtn
					var operationBtnProvider = new $.OperationBtnProvider();
					var oBtn = operationBtnProvider.draw("Operation", "btn-info", oServiceVo);
					
					// 4.append oBtn to oRow
					oRowProvider.getRow().append(oBtn);
					
					// 5.append oRow to oTable
					var ttt = $("#tableGetAllInstances");
	    			$("#tableGetAllInstances").append(oRowProvider.getRow());
				});
			}, function(oRes){
				
			});
		};
		
		//#endrgion
	};
})(jQuery);
var indexProvider = new $.IndexProvider();