module.controller("UpdateOrderController", function($scope, $routeParams,$http,FileUploadService,MessageService,UpdateOrderService,OrderService,$rootScope,AppDataService) {
	
	$scope.title = "Update Order";
	
	$scope.updateType="status";
	
	$scope.orderID = $routeParams.orderID;
	
	$scope.newOrderID=null;
	
	$scope.updateData={};
	
	$scope.openHelpModel = function(){
        $("#UpdateHelp-modal").modal();
	}
	
	$scope.availableUpdates = [];
	$scope.restrictedUpdates = [];
	
	$scope.init = function(){
		getAvailableUpdates();
		getMultiOrderUpdateConfiguration();
	}
	
	$scope.init();
	$scope.updateOrderRes = {};
	$scope.updateOrder = function(updatetype){
		updateOrderStatusAndRetryCount(updatetype);
	}
	
	/*MY Changes START */
	
	$scope.multiUpdateTableList=[];
	
	function getMultiOrderUpdateConfiguration(){
		AppDataService.getOrderMultiUpdateConfiguration().then(function(response){
					$scope.multiUpdateTableList = response.data;
				}, 
				function(errResponse){
					return $q.reject(errResponse);
				}
		);
	}
	
	$scope.multiUpdateMessage = '';
	$scope.multiTblDisabled = false;
	$scope.tableSelect = null;
	$scope.tableCloumnList = [];
	$scope.populateColumnList = function(){
		console.log($scope.tableSelect);
		if($scope.tableSelect!==''){
			$scope.multiTblDisabled = true;
			$scope.tableCloumnList = [];
			angular.forEach($scope.multiUpdateTableList,function(value, key) {
				if($scope.tableSelect == key){
					$scope.tableCloumnList = value;
				}
			});
		}
	}
	
	$scope.multiUpdateData = [];
	$scope.tableColName =null;
	$scope.populateUpdateTable = function(){
		$scope.multiUpdateMessage = '';
		if($scope.tableColName != null){
			var selectedColName = $scope.tableColName.name;
			var isPresent = false;
			angular.forEach($scope.multiUpdateData,function(value, key) {
				if(value.colName == selectedColName){
					isPresent = true;
				}
			});
			
			if(!isPresent){
				var obj = {
						'colName' : selectedColName,
						'colValue' :  ''
				}
				$scope.multiUpdateData.push(obj);
			}
		}
		else{
			$scope.multiUpdateMessage = 'Please select Column first.';
		}
	}
	
	$scope.resetMultiUpdatePanel = function(){
		$scope.multiTblDisabled = false;
		$scope.multiUpdateData = [];
		$scope.tableCloumnList = [];
	}
	
	$scope.removeMultiUpdateData = function(index){
		console.log(index);
		$scope.multiUpdateData.splice(index,1);
	}
	
	$scope.updateMultiOrderData = function(){
		console.log($scope.multiUpdateData);
	}
	
	/*MY Changes END */
	
	 /*
	  * This method will upload the file to update orders in bulk.
	  */
	 $scope.uploadFile = function(){
		 
		 var updateType = $scope.updateType;
		 if(undefined == $scope.myFile){
			 MessageService.showError('Please upload File to update Orders',5000);
			 return;
		 }
		 var file = $scope.myFile;
		 var uploadUrl = "upload/"+$scope.updateType;
	      
	     uploadAndReviewOrders(file,uploadUrl);
	 };
	 
	 /*
	  * This method will get Portal order SIM and IMEI details
	  */
	 $scope.getPortalLineSimandImeiDetails = function(updateType){
		 $rootScope.spinner.on();
		 $scope.newObject = {};
		 $scope.PortalLineSimAndImeiDetails = [];
		 
		 var orderID = null;
		 
		 if(updateType==='sim')
			 orderID = ($scope.orderID===undefined || $scope.orderID===null) ? $scope.updateData.simOrderId : $scope.orderID;
		 else if(updateType ==='imei')
			 orderID = ($scope.orderID===undefined || $scope.orderID===null) ? $scope.updateData.imeiOrderId : $scope.orderID;
		 
		 OrderService.getPortalLineSimandImei(orderID).then(
					function(response) {
						$rootScope.spinner.off();
						console.log(response.portalLineSimandImeiList);
						$scope.PortalLineSimAndImeiDetails = response.portalLineSimandImeiList;
		       		},
			        function(errResponse){
		       			$rootScope.spinner.off();
		       			MessageService.showError(errResponse,5000);
			        }
			);
	 }
	 
	 /*
	  * This method will update the order SIM and IMEI
	  */
	 $scope.updateSimAndImei = function(lineObj,newValue,updateType){
		 $rootScope.spinner.on();
		 
		 var lineID = lineObj.lineItemNo;
		 
		 var orderID = null;
		 
		 if(updateType==='sim')
			 orderID = ($scope.orderID===undefined || $scope.orderID===null) ? $scope.updateData.simOrderId : $scope.orderID;
		 else if(updateType ==='imei')
			 orderID = ($scope.orderID===undefined || $scope.orderID===null) ? $scope.updateData.imeiOrderId : $scope.orderID;
		 
		 if(newValue!==null && newValue!==undefined){
			 UpdateOrderService.updateOrderDetails(updateType,newValue,orderID,lineID).then(
						function(response) {
							$rootScope.spinner.off();
							if(response!=undefined && response.errorCode == 0){
								$scope.updateOrderRes = response;
								MessageService.showSuccess(response.errorMsg,5000);
								$scope.getPortalLineSimandImeiDetails(updateType);
							}
							else{
								$rootScope.spinner.off();
								var errorMessage = response.errorMsg + ((response.logRefId!==null) ? "\n Log Reference ID : " + response.logRefId : '');
								MessageService.showError(errorMessage,10000);
							}
			       		},
				       function(errResponse){
			       			$rootScope.spinner.off();
							MessageService.showSuccess('Error occured while updating order. Please try again later.',5000);
				       }
				);
		 }
		 else{
			 $rootScope.spinner.off();
			 MessageService.showInfo('Please enter valid SIM / IMEI Value',10000);
		 }
		 
	 }
	 
	 
	 /*
	  * This method will update the order status and retry count 
	  */
	 function updateOrderStatusAndRetryCount(updatetype){
		 	var newValue='';
		 	
			if(updatetype=='status')
				newValue=$scope.newStatus;
			else if(updatetype=='retry')
				newValue=$scope.newRetry;
				
			var orderID = null;
			
			if(updatetype==='status')
				 orderID = ($scope.orderID===undefined || $scope.orderID===null) ? $scope.updateData.statusOrderId : $scope.orderID;
			 else if(updatetype ==='retry')
				 orderID = ($scope.orderID===undefined || $scope.orderID===null) ? $scope.updateData.retryCntOrderID : $scope.orderID;
			
			UpdateOrderService.updateOrderDetails(updatetype,newValue,orderID,null).then(
					function(response) {
						if(response!=undefined && response.errorCode == 0){
							$scope.updateOrderRes = response;
							MessageService.showSuccess(response.errorMsg,5000);
						}
						else{
							var errorMessage = response.errorMsg + "\n Log Reference ID : " + response.logRefId;
							MessageService.showError(errorMessage,null);
						}
		       		},
			       function(errResponse){
						MessageService.showSuccess('Error occured while updating order. Please try again later.',5000);
			       }
			);
	 }
	 
	 /*
	  * This method will upload and review bulk orders 
	  */
	 function uploadAndReviewOrders(file,uploadUrl){
	      
	     FileUploadService.uploadFileToUrl(file, uploadUrl).then(
				function(response) {
					if(response.errorCode == 0){
						$scope.tempTblUpdateType = response.updateType;
						$scope.tempTableDataList = response.tempTableDataList;
						MessageService.showSuccess(response.errorMsg,5000);
						$("#UpdateResponse-modal").modal();
					}
					else if(response.errorCode == 1){
						MessageService.showInfo(response.errorMsg,5000);
					}
					else if(response.errorCode == -1){
						var errorMessage = response.errorMsg + "\n Log Reference ID : " + response.logRefId;
						MessageService.showError(errorMessage,null);
					}
					
					if(response.invalidOrders.length>0){
						$scope.inValidOrders = response.invalidOrders;
						$("#UpdateResponse-modal").modal();
					}
	       		},
		        function(errResponse){
	       			MessageService.showError(errResponse,5000);
		        }
		  );
	 }
	 
	 function updateBulkOrders(){
		 
	 }
	 
	 /*
	  * This method will fetch the Available and restricted Update list
	  */
	 function getAvailableUpdates(){
		 UpdateOrderService.getAllowedUpdates().then(
					function(response) {
						$scope.availableUpdates = response.availableUpdates;
						$scope.restrictedUpdates = response.restrictedUpdates;
		       		},
			       function(errResponse){
						MessageService.showSuccess('Error occured while getting available updates. Please try again later.',5000);
			       }
			);
	 }
	 
});