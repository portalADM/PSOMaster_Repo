module.service('UpdateOrderService',function($http,$q){
	
	this.updateOrderDetails = function(updatetype,newValue,orderId,lineId){
		
		var eventObj = {
				'orderId':orderId,
				'lineId':lineId,
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
					console.error('Error while updatinng Order');
					return $q.reject(errResponse);
				}
			
		);
		
	}
	
	
	
	this.getAllowedUpdates = function(){
		
		return $http({
			method : "POST",
			url : "getAllowedUpdates"
		}).then(
				function(response){
					return response.data;
				}, 
				function(errResponse){
					console.error('Error while fetching allowed Updates');
					return $q.reject(errResponse);
				}
			
		);
		
	}

			
});