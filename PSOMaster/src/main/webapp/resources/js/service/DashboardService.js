module.service('DashboardService', function($http) {
	
	/*
	 *Service Method that will fetch Stuck Order list   stuckOrderList
	 * 
	 */
	this.getStuckOrderCount = function(){
		
		return $http.get('stuckOrderCount/')
		.then(
				function(response){
					return response.data;
				}, 
				function(errResponse){
					console.error('Error while fetching orders');
					return $q.reject(errResponse);
				}
		);
	}
	
	
this.getStuckOrderForStatus = function(status){
		
		return $http.get('stuckOrderList/'+status)
		.then(
				function(response){
					return response.data;
				}, 
				function(errResponse){
					console.error('Error while fetching orders');
					return $q.reject(errResponse);
				}
		);
	}
});