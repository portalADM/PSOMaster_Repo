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
	
	/*
	 *Service Method that will fetch Order API Request Body  
	 * 
	 */
	this.getOrderAPIRequest=function(seq_number){
		
		return  $http({
			  method: 'GET',
			  url: 'getAPIRequest/'+seq_number,
              transformResponse : function(data) {
            	  var x2js = new X2JS();  
                  var aftCnv = x2js.xml_str2json(data);  
                  return aftCnv;  
                //return $.parseXML(data);
              }
			  }).then(function successCallback(response) {
				console.log(response);
				return response.data;
			  }, function errorCallback(response) {
				  console.log(response);
			  });
		
	}
	
	
	/*
	 *Service Method that will fetch order's Port-in status
	 * 
	 */
	this.getPortInStatus = function(orderID){
		
		return $http.get('getPortInDetails/'+orderID)
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
