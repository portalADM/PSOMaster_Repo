module.service('OrderService', function($http) {
	
	/*
	 *Service Method that will fetch Portal Order Details  
	 * 
	 */
	this.getPortalOrderDetails = function(orderID){
		
		return $http.get('portalOrder/'+orderID)
		.then(
				function(response){
					return response.data;
				}, 
				function(errResponse){
					console.error('Error while fetching users');
					return $q.reject(errResponse);
				}
		);
	}


	/*
	 *Service Method that will fetch Ensemble Order Details  
	 * 
	 */
this.getEnsembleOrderDetails = function(orderID){
		
		return $http.get('ensembleOrder/'+orderID)
		.then(
				function(response){
					return response.data;
				}, 
				function(errResponse){
					console.error('Error while fetching users');
					return $q.reject(errResponse);
				}
		);
	}


/*
 *Service Method that will fetch Portal Order API Details  
 * 
 */
this.getPortalAPIDetails=function(orderID){
	
	return $http.get('apiOrder/'+orderID)
	.then(
			function(response){
				return response.data;
			},
			function(errResponse){
				console.error('Error while fetching users');
				return $q.reject(errResponse);
			}
			);
}
	
});