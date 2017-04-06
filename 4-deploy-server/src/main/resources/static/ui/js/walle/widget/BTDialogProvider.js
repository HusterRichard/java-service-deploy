(function($){
	$.BTDialogProvider = function(){
		// #region Fields
		
		var oDialog;
		
		// #endregion
		
		// #region Fields
		
		var DIALOG_TEMPLATE = 
				'<div class="modal fade" tabindex="-1" role="dialog">'+
				'  <div class="modal-dialog" role="document">'+
				'    <div class="modal-content">'+
				'      <div class="modal-header">'+
				'        <button type="button" class="close" data-dimiss="modal" aria-lable="close">'+
				'			<span aria-hidden="true">&times;</span>'+
				'		</button>'+
				'        <h4 class="modal-title">{0}</h4>'+
				'      </div>'+
				'      <div class="modal-body" id={1}>'+
				'      </div>'+
				'      <div class="modal-footer">'+
				'        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>'+
				'        <button type="button" class="btn btn-primary">{2}</button>'+
				'      </div>'+
				'    </div>'+
				'  </div>'+
				'</div>';
		
		// #endregion
				
		// #region draw
		
		this.draw = function(strDialogName, strBodyId, strExecBtName){
			this.oDialog = $(strUtils.format(DIALOG_TEMPLATE, strDialogName, strBodyId, strExecBtName));
			return this.oDialog;
		}
		
		// #endregion
		
		// #region getDialog
		
		this.getDialog = function(){
			return this.oDialog;
		}
		// #endregion
	}
})(jQuery)
var bTDialogProvider = new $.BTDialogProvider();