(function($){
	$.OperationBtnProvider = function(){
		// #region Const
		
		var TEMPLATE_BTN_ID = '{0}_{1}_{2}';
		var TEMPLATE_BTN = '<button id="{0}" type="button" class="btn btn-sm {1}">{2}</button>';
		
		// #endregion
	
		// #region draw
		
		this.draw = function(strOperationType, strOperationLevel, oServiceVo){
			// 1.init btn
			var strBtnId = strUtils.format(TEMPLATE_BTN_ID, strOperationType, oServiceVo.port, "btn");
			var strBtn = strUtils.format(TEMPLATE_BTN, strBtnId, strOperationLevel, strOperationType);
			var oBtn = $(strBtn);
			
			oBtn.click(function(){
				var operationPanelProvider = new $.OperationPanelProvider();
				operationPanelProvider.draw("Deploy dialog", strBtnId+"_dialog", "Deploy");
				
				var oDialog = operationPanelProvider.getDialog();				
				oDialog.modal();
			});
			return oBtn;
		};
		
		// #endregion
	};
})(jQuery);
