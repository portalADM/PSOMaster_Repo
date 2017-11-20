module.service('SignupService', function($http,$q) {
	
	/*
	 * Service Method that will Update the order details  
	 */
	this.registerUser = function(registerUserData){
		
		return $http({
			method : "POST",
			url : "registerUser",
			data :registerUserData
		}).then(
				function(response){
					console.log(response.data);
					return response.data;
				}, 
				function(errResponse){
					console.error('Error while Creating User');
					return $q.reject(errResponse);
				}
			
		);
		
	}
	
	
	/*
	 * Service Method that will setup User password
	 */
	this.setupUserPassword = function(userData){
		
		return $http({
			method : "POST",
			url : "setupPassword",
			data : userData
		}).then(
				function(response){
					console.log(response.data);
					return response.data;
				}, 
				function(errResponse){
					console.error('Error while setting user password');
					return $q.reject(errResponse);
				}
			
		);
		
	}


});