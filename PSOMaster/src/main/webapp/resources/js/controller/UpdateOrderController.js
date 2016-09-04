module.controller("UpdateOrderController", function($scope, $routeParams,$http,FileUploadService) {
	
	$scope.title = "Update Order";
	
	$scope.updateType="status";
	
	$scope.orderID = $routeParams.orderID;
	
	
/*	$scope.updateOrderPopup = function(){
        $("#updateOrder-modal").modal();
	}
	
	$scope.updateSimModal = function(){
        $("#updateSim-modal").modal();
	}
	
	$scope.updateImeiModal = function(){
        $("#updateImei-modal").modal();
	}*/
	
	$scope.openHelpModel = function(){
        $("#UpdateHelp-modal").modal();
	}
	
	
	 $scope.uploadFile = function(){
		 var file = $scope.myFile;
		 var uploadUrl = "upload/"+$scope.updateType;
	      
	     updateBulkOrder(file,uploadUrl);
	 };
	 
	 
	 function updateBulkOrder(file,uploadUrl){
	      
	      FileUploadService.uploadFileToUrl(file, uploadUrl).then(
				function(data) {
					if(data.errorCode != 0){
						MessageService.showError(data.errorMsg,5000);
					}
	       		},
		        function(errResponse){
	       			MessageService.showError(errResponse,5000);
		        }
		  );
	 }
	 
});