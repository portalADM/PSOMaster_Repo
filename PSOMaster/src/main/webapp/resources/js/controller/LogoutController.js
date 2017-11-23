module.controller("LogoutController", function($scope, $routeParams,$http,$location,$rootScope,Auth,MessageService) 
{
	$rootScope.spinner.off();
	
	$scope.logout = function()
	{
		Auth.logout();
		$location.path('/login');	
	}
	
	$scope.logout();
});