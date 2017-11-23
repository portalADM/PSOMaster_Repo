module.controller("SignupController", function($scope, SignupService,$location,MessageService,$rootScope,Auth) 
{
	$scope.userData = {};
	
	$scope.isSignUpSuccess = false;
	
	$scope.signUp = function()
	{
		var userData = $scope.userData;
		
		if(userData.firstName==null ||userData.lastName==null ||userData.empId==null  || userData.company==null 
					|| userData.firstName=='' ||userData.lastName=='' ||userData.empId==''  || userData.company==''){
			MessageService.showInfo('All the feilds are mandatory',5000);
		}
		else if(!$scope.signUpForm.$valid || userData.email==''|| userData.email== undefined){
			MessageService.showInfo('Please enter valid Email ID',5000);
		}
		else{
			$rootScope.spinner.on();
			SignupService.registerUser($scope.userData).then(
					function(response) {
						$rootScope.spinner.off();
						if(response!=undefined && response.errorCode == 0){
							$scope.isSignUpSuccess = true;
							MessageService.showSuccess('The request has been sent for approval. You will receive an email once it is approved.',10000);
							$scope.userData = {};
							$scope.validUserName = null;
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
	
	$scope.setupUserPassword = function()
	{
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
		$("#setuPassword-modal").modal('hide');
		$location.path('/login');
	}
	
	$scope.checkUserName = function(){
		var username = $scope.userData.username;
		if(username!=undefined || username!='' || username!=null){
			$scope.validUserName = '';
			SignupService.checkUsername(username).then(
					function(response) {
						if(response!=undefined && response.errorCode == 0){
							$scope.validUserName = 'true';
						}
						else{
							$scope.validUserName = 'false';
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
	
});