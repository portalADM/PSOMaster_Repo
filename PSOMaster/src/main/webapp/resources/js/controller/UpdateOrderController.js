module.controller("UpdateOrderController", function($scope, $routeParams,$http) {
	
	$scope.title = "Update Order";
	
	
	$scope.updateOrderPopup = function(){
        $("#updateOrder-modal").modal();
	}
	
	$scope.updateSimModal = function(){
        $("#updateSim-modal").modal();
	}
	
	$scope.updateImeiModal = function(){
        $("#updateImei-modal").modal();
	}
	
	$scope.updateRetryModal = function(){
        $("#updateRetry-modal").modal();
	}
	
});