module.service('CommonUtils', function($http) {

	/*
	 * Service Method that will fetch Portal Order Details
	 * 
	 */
	this.getGrouppedOrderList = function(orderList) {
		var grouppedList = [];
		var orders = [];
		angular.forEach(orderList, function(value, key) {
			if (orders.length == 2) {
				orders.push(value);
				grouppedList.push(orders);
				orders = [];
			} else if (orderList.length == (key + 1)) {
				orders.push(value);
				/*orders.push(" ");
				orders.push("  ");*/
				grouppedList.push(orders);
			} else {
				orders.push(value);
			}

		});
		return grouppedList;
	}
	
	
	this.checkIfValidSim = function(sim){
		var simPatern = /^[0-9]{1,20}$/;
		
		if (simPatern.test(+sim) && sim.length==20) 
			return true;
		else
			return false;
	}
	
	this.checkIfValidIMEI = function(imei){
		var imeiPatern = /^[0-9]{1,15}$/;
		
		if (imeiPatern.test(+imei) && imei.length==15) 
			return true;
		else
			return false;
	}

});