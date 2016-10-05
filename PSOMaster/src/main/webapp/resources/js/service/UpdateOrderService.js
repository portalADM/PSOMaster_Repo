module.service('UpdateOrderService',function($http,$q){
	
			this.updateOrderDetails = function(updatetype,newValue,orderId){
				
				var eventObj = {
						'orderId':orderId,
						'type':updatetype,
						'newValue':newValue
				}
				
				return $http({
					method : "POST",
					url : "updateOrder",
					data :eventObj
				}).then(
						function(response){
							console.log(response.data);
							return response.data;
						}, 
						function(errResponse){
							console.error('Error while fetching users');
							return $q.reject(errResponse);
						}
					
				);
				
			}

			
});