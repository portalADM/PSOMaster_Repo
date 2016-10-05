module.controller("UpdateOrderController", function($scope, $routeParams,$http,FileUploadService,MessageService,UpdateOrderService) {
	
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
	
	
	$scope.updateOrderRes = {};
	$scope.updateOrder = function(updatetype){
		
		var newValue='';
		
		if(updatetype=='status'){
		newValue=$scope.newStatus;}
		else if(updatetype=='sim')
			newValue=$scope.newSIM;
		else if(updatetype=='imei')
			newValue=$scope.newIMEI;
		else if(updatetype=='retry')
			newValue=$scope.newRetry;
			
		var orderID = $scope.orderID;
		
		
		
		UpdateOrderService.updateOrderDetails(updatetype,newValue,orderID).then(
				function(d) {
					$scope.updateOrderRes = d;
					console.log($scope.updateOrderRes);
	       		},
		       function(errResponse){
				console.error('Error while fetching Currencies');
		       }
		);
       
	}
	
	
	 $scope.uploadFile = function(){
		 var updateType = $scope.updateType;
		 if(undefined == $scope.myFile){
			 MessageService.showError('Please upload File to update Orders',5000);
			 return;
		 }
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
					console.log(data);
					
					if(data.invalidOrders.length>0){
						$scope.inValidOrders = data.invalidOrders;
						console.log(data.invalidOrders);
						$("#UpdateResponse-modal").modal();
					}
	       		},
		        function(errResponse){
	       			MessageService.showError(errResponse,5000);
		        }
		  );
	 }
	 
});