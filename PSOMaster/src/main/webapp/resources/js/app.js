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
	.otherwise({
		redirectTo : '/dashboard'
	});
} ]);
