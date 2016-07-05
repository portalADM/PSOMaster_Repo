var module = angular.module("PSOMaster", [ 'ngRoute','ngSanitize']);

module.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/dashboard', {
		templateUrl : 'views/Dashboard.jsp',
		controller : 'DashboardController'
	})
	.when('/orderMaster', {
		templateUrl : 'views/OrderMaster.jsp',
		controller : 'OrderMasterController'
	})
	.when('/updateOrder', {
		templateUrl : 'views/updateOrder.jsp',
		controller : 'UpdateOrderController'
	})
	.when('/sendEmail', {
		templateUrl : 'views/sendEmail.jsp',
		controller : 'OrderMasterController'
	})
	.otherwise({
		redirectTo : '/dashboard'
	});
} ]);
