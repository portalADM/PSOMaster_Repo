module.factory('myInterceptor', ['$q', function($q) {  
	var timestampMarker = {
	        request: function(config) {
	            config.requestTimestamp = new Date().getTime();
	            return config;
	        },
	        response: function(response) {
	            response.config.responseTimestamp = new Date().getTime();
	            return response;
	        }
	    };
	    return timestampMarker;

}]);