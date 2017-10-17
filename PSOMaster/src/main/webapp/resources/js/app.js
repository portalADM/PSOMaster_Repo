var module = angular.module("PSOMaster", [ 'ngRoute','ngSanitize','ng-fusioncharts','ngFlash','ngAnimate', 'ui.bootstrap','treasure-overlay-spinner']);//,'chart.js'

module.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/login', {
		templateUrl : '/Login.jsp',
		controller : 'LoginController'
	})
	.when('/dashboard', {
		templateUrl : 'views/Dashboard.jsp',
		controller : 'DashboardController'
	})
	.when('/orderMaster', {
		templateUrl : 'views/OrderMaster.jsp',
		controller : 'OrderMasterController'
	})
	.when('/getOrder/:orderID', {
		templateUrl : 'views/OrderMaster.jsp',
		controller : 'OrderMasterController'
	})
	.when('/updateOrder', {
		templateUrl : 'views/updateOrder.jsp',
		controller : 'UpdateOrderController'
	})
	.when('/updateOrder/:orderID', {
		templateUrl : 'views/updateOrder.jsp',
		controller : 'UpdateOrderController'
	})
	.when('/sendEmail', {
		templateUrl : 'views/sendEmail.jsp',
		controller : 'SendEmailController'
	})
	.when('/demo', {
		templateUrl : 'views/demo.jsp',
		controller : 'SendEmailController'
	})
	.when('/StuckOrderDetails/:orderStatus', {
		templateUrl : 'views/StuckOrderDetails.jsp',
		controller : 'StuckOrderDetailsController'
	})
	.otherwise({
		redirectTo : '/dashboard'
	});
} ]);


module.run(run);

run.$inject = ['$rootScope'];
function run ($rootScope) {
	 $rootScope.spinner = {
		        active: false,
		        on: function () {
		          this.active = true;
		        },
		        off: function () {
		          this.active = false;
		        }
		      };
}