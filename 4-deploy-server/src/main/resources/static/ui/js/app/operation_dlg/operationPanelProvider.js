(function($){
	$.OperationPanelProvider = function(){
		var self = this;
		// #region dialog
		
		var oDialog;
		
		var strBodyId;
		
		// #endregion
		
		// #region draw
		
		this.draw = function(strDialogName, strBodyId, strExecBtName){
			this.strBodyId = strBodyId;
			this.oDialog = bTDialogProvider.draw(strDialogName, strBodyId, strExecBtName);
			bTDialogProvider.getDialog().modal();
			
			// 1.draw serviceTypes dropdown btn
			this.drawServiceTypeDropdown();
			
			// 2.draw ftp url textbox
			
			// 3.draw ftp user_name textbox
			
			// 4.draw ftp password textbox
			
			// 5.draw service_version textbox
			
			// 6.draw service_branch textbox
			
			// 7.draw service instance num textbox
			
			// 8.draw service instance start port textbox
			
			// 9.draw service instance end port textbox
		}
		
		// #endregion
		
		// #region drawServiceTypeDropdown
		
		this.drawServiceTypeDropdown = function(){
			var btDropdownProvider = new $.BTDropdownProvider();
			var strDropdownId = strBodyId + "_dropdown_servicetype";
			var strDropdownMenuId = strDropdownId + "_menu";
			var oDropdown = btDropdownProvider.draw(strDropdownId, "Redis", strDropdownMenuId);
			btDropdownProvider.appendMenuItem("Redis");
			btDropdownProvider.appendMenuItem("Mysql");
			btDropdownProvider.appendMenuItem("Registry");
			btDropdownProvider.appendMenuItem("Config_server");
			
			$("#"+this.strBodyId).append(oDropdown);
		}
		
		// #endregion
		
		// #region getDialog
		
		this.getDialog = function(){
			return this.oDialog;
		}
		
		// #endregion
	}
}
)(jQuery);