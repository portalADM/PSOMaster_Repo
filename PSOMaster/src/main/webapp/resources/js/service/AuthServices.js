angular.module('AuthServices', ['ngResource', 'ngStorage'])
.factory('Auth', function($resource, $rootScope, $sessionStorage, $q,$http){
     
    /**
     *  User profile resource
     */
    var Profile = $resource('login', {}, {
        login: {
            method: "POST",
            isArray : false
        }
    });
     
    var auth = {};
     
    /**
     *  Saves the current user in the root scope
     *  Call this in the app run() method
     */
    auth.init = function(){
        if (auth.isLoggedIn()){
            $rootScope.user = auth.currentUser();
        }
    };
         
    auth.login = function(username, password){
    	 var config = {/*
                 ignoreAuthModule: 'ignoreAuthModule',*/
                 headers: {'Content-Type': 'application/x-www-form-urlencoded',
                	 'authorization' : "Basic "+ btoa(username + ":" + password)
                	 }
                 
             };
    	
      /*  return $http({
			method : "POST",
			url : "authenticate",
			data :$.param({
	            username: username,
	            password: password
	        }),
			config : config
		}).then(
		function(response){
			$sessionStorage.user = response.data.user;    
            $rootScope.user = $sessionStorage.user;
			return response.data;
		}, 
		function(errResponse){
			console.error('Error while login');
			return $q.reject(errResponse);
		});*/
        
        
    	 return $http.post('authenticate', $.param({
            username: username,
            password: password
        }), config).then(
        		function(response){
        			$sessionStorage.user = response.data.user;    
                    $rootScope.user = $sessionStorage.user;
        			return response.data;
        		}, 
        		function(errResponse){
        			console.error('Error while login');
        			return $q.reject(errResponse);
        		});
        
        
    };
     
 
    auth.logout = function() {
    	$http.post('logout');
        delete $sessionStorage.user;
        delete $rootScope.user;
    };
     
     
    auth.checkPermissionForView = function(view) {
        if (!view.requiresAuthentication) {
            return true;
        }
         
        return userHasPermissionForView(view);
    };
     
     
    var userHasPermissionForView = function(view){
        if(!auth.isLoggedIn()){
            return false;
        }
         
        if(!view.permissions || !view.permissions.length){
            return true;
        }
         
        return auth.userHasPermission(view.permissions);
    };
     
     
    auth.userHasPermission = function(permissions){
        if(!auth.isLoggedIn()){
            return false;
        }
         
        var found = false;
        angular.forEach(permissions, function(permission, index){
            if ($sessionStorage.user.userRole.indexOf(permission) >= 0){
                found = true;
                return;
            }                        
        });
         
        return found;
    };
     
     
    auth.currentUser = function(){
        return $sessionStorage.user;
    };
     
     
    auth.isLoggedIn = function(){
        return $sessionStorage.user != null;
    };
     
 
    return auth;
});