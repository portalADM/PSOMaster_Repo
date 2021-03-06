module.controller("StuckOrderDetailsController", function($scope, $routeParams,$http,CommonUtils,DashboardService,$rootScope) {

	$scope.title = "Stuck Order Details";
	$scope.orderStatus = $routeParams.orderStatus;

	$scope.orderStatusDesc = [ {
								code : 'OSHF',
								desc : 'Number of shipment items do not match the order from ship advice from IMM.'
							},{
								code : 'ORFI',
								desc : 'Order is sent for fulfillment.'
							},{
								code : 'ORLF',
								desc : 'Order cannot be fulfilled by IMM at the moment, retry required.'
							},{
								code : 'ACTF',
								desc : 'Activation failed, please retry.'
							},{
								code : 'OURF',
								desc : 'Backend system failed to be updated with SIM and IMEI info.'
							},{
								code : 'PDRF',
								desc : 'Backend system failed to update device purchase info.'
							},{
								code : 'PRTF',
								desc : 'Port In Response Type Failed'
							}];
	
	$scope.stuckOrders = [1212112,65656565,3232323,8998989,111212,78454545,23232323,3232367,8998977,1112199];
	
	$scope.grouppedOrders=[];
	
	
	$scope.init=function(){
		$rootScope.spinner.on();
		DashboardService.getStuckOrderForStatus($scope.orderStatus).then(
				function(data) {
					$rootScope.spinner.off();
					$scope.stuckOrders= data;
					$scope.grouppedOrders = CommonUtils.getGrouppedOrderList($scope.stuckOrders);
	       		},
		       function(errResponse){
	       			$rootScope.spinner.off();
				console.error('Error while fetching Currencies');
		       }
		);
	}
	
	$scope.init();
});