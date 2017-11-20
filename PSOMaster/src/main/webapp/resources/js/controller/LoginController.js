module.controller("LoginController", function($scope, $routeParams,$http,$location,$rootScope,Auth,MessageService) 
{
	$scope.authenticateUser = function()
	{
		var username = $scope.username;
		var password = $scope.password;
		Auth.login(username, password)
        .then(function(response) {
        	if (response.errorCode === 401) {
				$location.path('/login');	
				MessageService.showError('Username or Password is wrong',5000);
			}
        	else 
        		$location.path("/dashboard");
        }, function(response) {
            $scope.failed = true;
            
			if (response.status === 401) {
				$location.path('/login');				
			}
        });
	}
	
});