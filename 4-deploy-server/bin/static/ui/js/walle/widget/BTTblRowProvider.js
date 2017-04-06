/*
 * created by zhangxincheng
 */
(function($){
	$.BTTblRowProvider = function(){
		// #region Const
		
		var oRow;
		
		var TEMPLATE_ROW = '<tr class="success" id={0}></tr>';
		
		var TEMPLATE_TABLE_DATA = '<td>{0}</td>';

		// #endregion
		
		// #region init
		
		this.init = function(rowId){
			var strRow = strUtils.format(TEMPLATE_ROW, rowId); 
			this.oRow = $(strRow);
			return this;
		}
		
		// #endregion
		
		// #region append
		
		this.append = function(strValue){
			var strTblData = strUtils.format(TEMPLATE_TABLE_DATA, strValue);
			this.oRow.append(strTblData);
			return this;
		}
		
		// #endregion
		
		// #region getRow
		
		this.getRow = function(){
			return this.oRow;
		}
		
		// #endregion
	}
})(jQuery);