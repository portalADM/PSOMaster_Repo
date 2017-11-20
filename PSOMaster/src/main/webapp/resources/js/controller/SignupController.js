module.controller("SignupController", function($scope, SignupService,$location,MessageService,$rootScope,Auth) 
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
	
	$scope.setupUserPassword = function()
	{
		console.log($scope.userData);
		var newPassword = $scope.userData.password;
		var confirmPassword = $scope.userData.confirmPassword;
		
		if(newPassword !== confirmPassword)
		{
			MessageService.showInfo('Your New Password and Confirm Passwords are not matching.',5000);
		}
		else
		{
			$rootScope.spinner.on();
			SignupService.setupUserPassword($scope.userData).then(
					function(response) {
						$rootScope.spinner.off();
						if(response!=undefined && response.errorCode == 0){
							$scope.setupMessage = response.errorMsg;
							$("#setuPassword-modal").modal();
						}
						else{
							var errorMessage = response.errorMsg + ((response.logRefId!==null) ? "\n Log Reference ID : " + response.logRefId : '');
							MessageService.showError(errorMessage,10000);
						}
		       		},
			       function(errResponse){
		       			$rootScope.spinner.off();
						MessageService.showSuccess('Error occured while User password setup. Please try again later.',5000);
			       }
			);
		}
	}
	
	$scope.redirectToLoginPage = function(){
		$location.path('/login');
	}
	
});