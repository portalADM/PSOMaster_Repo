var module = angular.module("PSOMaster", ['ngResource','ngRoute', 'ngSanitize','ng-fusioncharts','ngFlash','ngAnimate', 'ui.bootstrap','treasure-overlay-spinner','AuthServices','ngCookies']);//,'chart.js'

module.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/login', {
		templateUrl : 'views/Login.jsp',
		controller : 'LoginController'
	})
	.when('/dashboard', {
		templateUrl : 'views/Dashboard.jsp',
		controller : 'DashboardController',
        requiresAuthentication: true,
        permissions: ["ADMINISTRATOR","REMIDIATOR","GUEST"]
	})
	.when('/orderMaster', {
		templateUrl : 'views/OrderMaster.jsp',
		controller : 'OrderMasterController',
        requiresAuthentication: true,
        permissions: ["ADMINISTRATOR","REMIDIATOR","GUEST"]
	})
	.when('/getOrder/:orderID', {
		templateUrl : 'views/OrderMaster.jsp',
		controller : 'OrderMasterController',
        requiresAuthentication: true,
        permissions: ["ADMINISTRATOR","REMIDIATOR","GUEST"]
	})
	.when('/updateOrder', {
		templateUrl : 'views/updateOrder.jsp',
		controller : 'UpdateOrderController',
        requiresAuthentication: true,
        permissions: ["ADMINISTRATOR","REMIDIATOR"]
	})
	.when('/updateOrder/:orderID', {
		templateUrl : 'views/updateOrder.jsp',
		controller : 'UpdateOrderController',
        requiresAuthentication: true,
        permissions: ["ADMINISTRATOR","REMIDIATOR"]
	})
	.when('/sendEmail', {
		templateUrl : 'views/sendEmail.jsp',
		controller : 'SendEmailController',
        requiresAuthentication: true
	})
	.when('/demo', {
		templateUrl : 'views/demo.jsp',
		controller : 'SendEmailController'
	})
	.when('/StuckOrderDetails/:orderStatus', {
		templateUrl : 'views/StuckOrderDetails.jsp',
		controller : 'StuckOrderDetailsController',
        requiresAuthentication: true,
        permissions: ["ADMINISTRATOR","REMIDIATOR","GUEST"]
	})
	.when('/manageGroup', {
		templateUrl : 'views/admin/ManageGroup.jsp',
		controller : 'ManageGroupController',
        requiresAuthentication: true,
        permissions: ["ADMINISTRATOR"]
	})
	.when('/manageUser', {
		templateUrl : 'views/admin/ManageUser.jsp',
		controller : 'ManageUserController',
        requiresAuthentication: true,
        permissions: ["ADMINISTRATOR"]
	})
	.when('/signUp', {
		templateUrl : 'views/Signup.jsp',
		controller : 'SignupController'
	})
	.when('/logout', {
		templateUrl : 'views/Login.jsp',
		controller : 'LogoutController'
	})
	.when('/changePassword', {
		templateUrl : 'views/ChangePassword.jsp',
		controller : 'ChangePasswordController'
	})
	.when('/setupUserPassword', {
		templateUrl : 'views/SetupPassword.jsp',
		controller : 'SignupController'
	})
	.when('/userAssignments/:employeeId/:oprType', {
		templateUrl : 'views/ManageUserAssignments.jsp',
		controller : 'UserAssignmentController',
        requiresAuthentication: true,
        permissions: ["ADMINISTRATOR"]
	})
	.otherwise({
		redirectTo : '/login'
	});
} ]);


module.factory('XSRFInterceptor', function ($cookies) {

  var XSRFInterceptor = {

    request: function(config) {

      var token = $cookies.get('XSRF-TOKEN');

      if (token) {
        config.headers['X-XSRF-TOKEN'] = token;
      }

      return config;
    }
  };
  return XSRFInterceptor;
});

var interceptor = function ($q, $location) {
    return {
        request: function (config) {//req
            return config;
        },
        response: function (result) {//res
            return result;
        },
        responseError: function (rejection) {//error
            if (rejection.status == 401) {
        		$location.path('/logout');
            }
            return $q.reject(rejection);
        }
    }
};

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
module.config(function ($httpProvider) {
    $httpProvider.interceptors.push(interceptor);
    $httpProvider.interceptors.push('XSRFInterceptor');
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    $httpProvider.defaults.headers.common[header] = token;
});


module.run(run);

run.$inject = ['$rootScope', '$location', 'Auth'];
function run ($rootScope, $location, Auth) {
	 $rootScope.spinner = {
		        active: false,
		        on: function () {
		          this.active = true;
		        },
		        off: function () {
		          this.active = false;
		        }
		      };
	 
	 Auth.init();
     
    $rootScope.$on('$routeChangeStart', function (event, next) {
        if (!Auth.checkPermissionForView(next)){
            event.preventDefault();
            $location.path("/login");
        }
    });
}



module.directive('permission', ['Auth', function(Auth) {
   return {
       restrict: 'A',
       scope: {
          permission: '='
       },
 
       link: function (scope, elem, attrs) {
            scope.$watch(Auth.isLoggedIn, function() {
                if (Auth.userHasPermission(scope.permission)) {
                    elem.show();
                } else {
                    elem.hide();
                }
            });                
       }
   }
}]);