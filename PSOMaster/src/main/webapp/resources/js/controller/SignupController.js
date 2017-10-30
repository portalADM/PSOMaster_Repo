module.controller("SignupController", function($scope, SignupService,$http,MessageService,$rootScope,Auth) 
{
	$scope.userData = {};
	
	$scope.isSignUpSuccess = false;
	
	$scope.signUp = function()
	{
		$rootScope.spinner.on();
		SignupService.registerUser($scope.userData).then(
				function(response) {
					$rootScope.spinner.off();
					if(response!=undefined && response.errorCode == 0){
						$scope.isSignUpSuccess = true;
						MessageService.showSuccess('The request has been sent for approval. You will receive an email once it is approved.',null);
					}
					else{
						var errorMessage = response.errorMsg + ((response.logRefId!==null) ? "\n Log Reference ID : " + response.logRefId : '');
						MessageService.showError(errorMessage,10000);
					}
	       		},
		       function(errResponse){
	       			$rootScope.spinner.off();
					MessageService.showSuccess('Error occured while registration. Please try again later.',5000);
		       }
		);
	}
	
});