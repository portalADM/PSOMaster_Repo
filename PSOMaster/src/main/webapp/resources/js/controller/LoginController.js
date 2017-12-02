module.controller("LoginController", function($scope, $routeParams,$http,$location,$rootScope,Auth,MessageService) 
{
	$rootScope.spinner.off();
	
	$scope.init = function(){
		MessageService.hideMessage();
		removeModelBackDrop();
	}
	
	$scope.authenticateUser = function()
	{
		MessageService.hideMessage();
		var username = $scope.username;
		var password = $scope.password;
		if(username == undefined || username == null || password == undefined || password == null )
		{
			MessageService.showInfo('Username or Password are mandatory',5000);
		}
		else
		{
			$rootScope.spinner.on();
			
			Auth.login(username, password).then(function(response) {
				$rootScope.spinner.off();
	        	if (response.errorCode === 401) {
					$location.path('/login');	
					MessageService.showError('Username or Password is wrong',5000);
				}
	        	else 
	        		$location.path("/dashboard");
	        }, function(response) {
	        	$rootScope.spinner.off();
	            $scope.failed = true;
	            
				if (response.status === 401) {
					$location.path('/login');				
				}
	        });
		}
		
	}
	
	$scope.init();
	
	function removeModelBackDrop()
	{
		angular.element( document.querySelector( '.modal-backdrop' ) ).remove('.modal-backdrop')
	}
	
});