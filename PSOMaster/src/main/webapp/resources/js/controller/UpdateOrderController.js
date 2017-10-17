module.controller("UpdateOrderController", function($scope, $filter,$routeParams,$http,FileUploadService,MessageService,UpdateOrderService,OrderService,$rootScope,AppDataService,CommonUtils) {
	
	$scope.title = "Update Order";
	
	$scope.updateType="status";
	
	$scope.orderID = $routeParams.orderID;
	
	$scope.newOrderID=null;
	
	$scope.updateData={};
	
	$scope.bulkUpdateID = null;
	
	$scope.openHelpModel = function(){
        $("#UpdateHelp-modal").modal();
	}
	
	$scope.availableUpdates = [];
	$scope.restrictedUpdates = [];
	
	$scope.init = function(){
		getAvailableUpdates();
		getMultiOrderUpdateConfiguration();
		getOrderStatusesForUpdate();
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
	$scope.isLineLevelUpdate = null;
	$scope.tableCloumnList = [];
	$scope.populateColumnList = function(){
		console.log($scope.tableSelect);
		if($scope.tableSelect!==''){
			$scope.multiTblDisabled = true;
			$scope.tableCloumnList = [];
			angular.forEach($scope.multiUpdateTableList,function(value, key) {
				console.log(value);
				if($scope.tableSelect == key){
					$scope.tableCloumnList = value.COL_DATA;
					$scope.isLineLevelUpdate = value.isLineLevelUpdate;
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
		var dataObj = {
				'orderId' : $scope.orderID,
				'tabName' : $scope.tableSelect,
				'colData' : $scope.multiUpdateData,
				'isLineLevelUpdate' : ($scope.isLineLevelUpdate == 1) ? true : false
		}
		
		console.log(dataObj);
		
		UpdateOrderService.updateMultiOrderDetails(dataObj).then(
				function(response) {
					
	       		},
		        function(errResponse){
	       			
		        }
		);
	}
	
	/*MY Changes END */
	/*$scope.selectedTypes = '';
	$scope.availableBulkUpdateType = [{'name':'SIM'},{'name':'IMEI'},{'name':'STATUS'},{'name':'RETRY_COUNT'}];
	$scope.getSelectedBulkUpdatesTypes = function () {
		$scope.selectedTypes = '';
		$scope.selectedBulkUpdateTypes = $filter('filter')($scope.availableBulkUpdateType, {checked: true});
		
		angular.forEach($scope.selectedBulkUpdateTypes,function(obj,value){
			if($scope.selectedTypes.indexOf(obj.name)==-1){
				$scope.selectedTypes += obj.name + ",";
			}
        })
	}*/
	
	
	function getOrderStatusesForUpdate(){
		$scope.orderStatusList = [];
		OrderService.getOrderStatusList().then(
				function(response) {
					$scope.orderStatusList = response;
					$scope.newStatus = $scope.orderStatusList[0];
	       		},
		        function(errResponse){
	       			MessageService.showError(errResponse,5000);
		        }
		);
	}
	
	
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
						if(response.portalLineSimandImeiList.length>0)
							$scope.PortalLineSimAndImeiDetails = response.portalLineSimandImeiList;
						else
							MessageService.showInfo('No details found for this order',5000);
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
		 var isValidValue = false;
		 
		 if(updateType==='sim'){
			 orderID = ($scope.orderID===undefined || $scope.orderID===null) ? $scope.updateData.simOrderId : $scope.orderID;
			 isValidValue = CommonUtils.checkIfValidSim(newValue);
		 }
		 else if(updateType ==='imei'){
			 orderID = ($scope.orderID===undefined || $scope.orderID===null) ? $scope.updateData.imeiOrderId : $scope.orderID;
			 isValidValue = CommonUtils.checkIfValidIMEI(newValue);
		 }
		 
		 if(newValue!==null && newValue!==undefined && isValidValue && orderID!=null){
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
		 $rootScope.spinner.on();
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
			
			 if(newValue!==null && newValue!==undefined && orderID!==null){
				 UpdateOrderService.updateOrderDetails(updatetype,newValue,orderID,null).then(
							function(response) {
								$rootScope.spinner.off();
								if(response!=undefined && response.errorCode == 0){
									$scope.updateOrderRes = response;
									MessageService.showSuccess(response.errorMsg,5000);
								}
								else{
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
				 MessageService.showInfo('Please provide valid Order Status or Retry count',10000);
			 }
			
	 }
	 
	 /*
	  * This method will upload and review bulk orders 
	  */
	 function uploadAndReviewOrders(file,uploadUrl){
	      
		 $rootScope.spinner.on();
	     FileUploadService.uploadFileToUrl(file, uploadUrl).then(
				function(response) {
					$rootScope.spinner.off();
					if(response.errorCode == 0){
						$scope.tempTableDataList = response.tempTableDataList;
						$scope.bulkUpdateID = response.bulkUpdateId;
						MessageService.showSuccess(response.errorMsg,5000);
						
						$scope.accordion='Valid';
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
	 
	 /*
	  * This method will update the Valid bulk orders
	  */
	 $scope.updateBulkOrders = function(){
		 $("#UpdateResponse-modal").modal('hide');
		 $rootScope.spinner.on();
		 UpdateOrderService.updateBulkOrderDetails($scope.bulkUpdateID).then(
					function(response) {
						$rootScope.spinner.off();
						MessageService.showInfo(response.errorMsg,10000);
		       		},
			       function(errResponse){
		       			$rootScope.spinner.off();
						MessageService.showSuccess('Error occured while Updating Bulk Orders. Please try again later.',5000);
			       }
		 );
		 
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