module.service('MessageService', function($http) {

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

});