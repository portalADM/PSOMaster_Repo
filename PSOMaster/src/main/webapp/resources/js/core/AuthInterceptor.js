module.factory('myInterceptor', ['$q', '$location', '$rootScope', function ($q, $location, $rootScope) {  
	 function success(response) {
	        return response;
	    }

	    function error(response) {
	        var status = response.status;
	        if (status == 401) {
	            $location.path('/login');
	        }
	        return $q.reject(response);
	    }

	    return function (promise) {
	        return promise.then(success, error);
	    }
}]);

