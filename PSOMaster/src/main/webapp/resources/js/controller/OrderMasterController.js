module.controller("OrderMasterController", function($scope, $routeParams,$http,OrderService) {
	
	$scope.title = "Order Master";
	
	$scope.orderID = $routeParams.orderID;
	
	console.log($scope.orderID);
	
	$scope.portalOrderDetails = {
			orderId : '',
			orderType : '',
			originatorId : '',
			ban : '',
			ptn : '',
			retry : '',
			status : '',
			sys_creation_date : '',
			sys_update_date : ''
	};
	
	
	/*
	 * Method that calls Order Service to get Portal and Ensemble Order Details 
	 */
	$scope.searchOrderDetails = function(){
		
		var orderID = $scope.orderID;
		
		// Get Portal Order Details
		$scope.portalOrderDetails = getPortalOrderDetails(orderID);
		
		// Get Portal Order API Details
		getPortalOrderAPIDetails(orderID);
		
		// Get Ensemble Order Details
		getENSOrderDetails(orderID);
	}
	
	
	/*
	 * Method that calls Order Service to get Portal Order Details 
	 */
	function getPortalOrderDetails(orderID){
		
		OrderService.getPortalOrderDetails(orderID).then(
				function(d) {
					$scope.portalOrderDetails = d;
					console.log($scope.portalOrderDetails);
	       		},
		       function(errResponse){
				console.error('Error while fetching Currencies');
		       }
		);
		
	}
	
	/*
	 * Method that calls Order Service to get Portal Order API Details 
	 */
	function getPortalOrderAPIDetails(orderID){
		
	}
	
	/*
	 * Method that calls Order Service to get Ensemble Order Details 
	 */
	function getENSOrderDetails(orderID){
		
	}
	
	
	if($scope.orderID!=undefined){
		$scope.searchOrderDetails();
	}
	
});