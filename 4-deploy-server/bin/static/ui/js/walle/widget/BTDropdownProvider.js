(function($){
	$.BTDropdownProvider = function(){
		// #region Const
		
		var DROPDOWN_TMPLATE = 
			'<div class="dropdown">'+
			'  <button id={0} type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">'+
			'    {1}'+
			'	<span class="caret"></span>'+
			'  </button>'+
			'  <ul class="dropdown-menu" aria-labelledby="dLable" id={1}>'+
			'  </ul>'+
			'</div>';
		
		var MENU_ITEM_TEMPLATE=
			'<li>' +
			'  <a href="#">{0}</a>' +
			'</li>';
			
		// #endregion
			
		// #region Fields
		
		var strMenuId;
		
		// #endregion
			
		this.draw = function(strDrowDownId, strDefaultName, strMenuId){
			this.strMenuId = strMenuId;
			var oDropdown = $(strUtils.format(DROPDOWN_TMPLATE, strDrowDownId, strDefaultName, strMenuId));
			return oDropdown;
		}
		
		// #region appendMenuItem
		
		this.appendMenuItem = function(strMenuName)
		{
			var strMenuItem = strUtils.format(MENU_ITEM_TEMPLATE, strMenuName);
			$("#"+strMenuId).append(strMenuItem);
		}
		
		// #endregion
	}
})(jQuery);