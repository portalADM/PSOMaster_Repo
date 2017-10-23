module.controller("LoginController", function($scope, $routeParams,$http,$location,$rootScope,Auth) 
{
	$scope.authenticateUser = function()
	{
		var username = $scope.username;
		var password = $scope.password;
		Auth.login(username, password)
        .then(function() {
            $location.path("/dashboard");
        }, function() {
            $scope.failed = true;
        });
	}
	
});