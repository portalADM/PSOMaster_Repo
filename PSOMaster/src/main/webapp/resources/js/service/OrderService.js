module.service('OrderService', function($http,$q) {
	
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
				return $q.reject(errResponse);
			}
			);
}
	
});
