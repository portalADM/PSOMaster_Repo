module.controller("ChangePasswordController", function($scope, $routeParams,$http,$location,$rootScope,UserService,MessageService,Auth) 
{
	$rootScope.spinner.off();
	
	$scope.currentUserData = Auth.currentUser();
	console.log($scope.currentUserData);
	
	$scope.userData = {
			    'empId' : $scope.currentUserData.empId,
			    'currentPassword' : '',
			    'password' : '',
			    'confirmPassword' :'' 
	}
	
	$scope.changePassword = function()
	{
		console.log($scope.userData);
		var newPassword = $scope.userData.password;
		var confirmPassword = $scope.userData.confirmPassword;
		
		if(newPassword !== confirmPassword)
		{
			MessageService.showInfo('Your New Password and Confirm Passwords does not match.',5000);
		}
		else
		{
			$rootScope.spinner.on();
			UserService.changeUserPassword($scope.userData).then(
					function(response) {
						$rootScope.spinner.off();
						if(response!=undefined && response.errorCode == 0){
							$scope.isSignUpSuccess = true;
							MessageService.showSuccess(response.errorMsg,10000);
							$scope.userData = {};
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
		
	}
	
});