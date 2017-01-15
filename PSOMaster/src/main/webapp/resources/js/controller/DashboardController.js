module.controller("DashboardController", function($scope, $routeParams,$http,DashboardService,$rootScope) {
	
	$scope.title = "Dashboard";
	
	/*$scope.labels = ['1 June', '2 June', '3 June', '4 June', '5 June', '6 June', '7 June', '8 June', '9 June', '10 June'];
	  $scope.series = ['Series A', 'Series B'];
	  $scope.data = [
	    [65, 59, 80, 81, 56, 55, 40, 59, 80, 81],
	    [28, 48, 40, 19, 86, 27, 90, 59, 80, 81]
	  ];
	  $scope.onClick = function (points, evt) {
	    console.log(points, evt);
	  };*/
	
	
	  $scope.datasetOverride = [{ yAxisID: 'y-axis-1' }, { yAxisID: 'y-axis-2' }];
	  $scope.options = {
	    scales: {
	      yAxes: [
	        {
	          id: 'y-axis-1',
	          type: 'linear',
	          display: true,
	          position: 'left'
	        },
	        {
	          id: 'y-axis-2',
	          type: 'linear',
	          display: true,
	          position: 'right'
	        }
	      ]
	    }
	  };
	  
	  
	  $scope.labelsBar = ['1 June', '2 June', '3 June', '4 June', '5 June', '6 June', '7 June', '8 June', '9 June', '10 June'];
	  $scope.seriesBar = ["OSHF", "ORFI", "ORLF", "ACTF", "OURF", "PDRF", "PRTF"];
	  $scope.dataBar = [
	    [65, 59, 80, 81, 56, 55, 40, 78, 19, 14],
	    [28, 48, 40, 19, 86, 27, 90, 48, 32, 25],
	    [32, 48, 32, 14, 32, 27, 90, 56, 19, 14],
	    [56, 78, 40, 19, 86, 14, 25, 48, 32, 14],
	    [78, 48, 25, 78, 86, 27, 90, 78, 19, 25],
	    [26, 48, 40, 19, 86, 27, 90, 48, 32, 14],
	    [14, 48, 25, 14, 86, 78, 25, 48, 56, 14],
	    [25, 48, 40, 19, 86, 27, 90, 78, 32, 25]
	  ];
	  $scope.seriesColors = ["#72B3D4","#D5D5D5","#FF1F22","#1ECCC9","#FFA940","#A4B1C7","#E151B6"]
	  
	  
	$scope.init=function()
	{
		$rootScope.spinner.on();
		DashboardService.getStuckOrderCount().then(
				function(data) {
					$rootScope.spinner.off()
					$scope.stuckOrderDetails= data.stuckOrderList;
	       		},
		       function(errResponse){
	       			console.error('Error while fetching Currencies');
		       }
		);
		
		DashboardService.getStuckOrderHandled().then(
				function(data) {
					
					if(data.stuckOrderList!=undefined && data.stuckOrderList.lenght>0){
						$scope.stuckOrderDetailsHandled= data.stuckOrderList;
						$scope.labelsPie = [$scope.stuckOrderDetailsHandled[0].orderStatus,$scope.stuckOrderDetailsHandled[1].orderStatus,$scope.stuckOrderDetailsHandled[2].orderStatus,$scope.stuckOrderDetailsHandled[3].orderStatus,$scope.stuckOrderDetailsHandled[4].orderStatus,$scope.stuckOrderDetailsHandled[5].orderStatus,$scope.stuckOrderDetailsHandled[6].orderStatus];
						$scope.dataPie = [$scope.stuckOrderDetailsHandled[0].count,$scope.stuckOrderDetailsHandled[1].count,$scope.stuckOrderDetailsHandled[2].count,$scope.stuckOrderDetailsHandled[3].count,$scope.stuckOrderDetailsHandled[4].count,$scope.stuckOrderDetailsHandled[5].count,$scope.stuckOrderDetailsHandled[6].count];	
					}
					
	       		},
		       function(errResponse){
				console.error('Error while fetching Currencies');
		       }
		);
		
		DashboardService.getStuckOrderallStatus().then(
				function(data) {
					
					if(data.stuckOrderList!=undefined && data.stuckOrderList.length>0){
						$scope.stuckOrderDetailsallStatus= data.stuckOrderList;
						$scope.labelsDounuts =[$scope.stuckOrderDetailsallStatus[0].orderStatus,$scope.stuckOrderDetailsallStatus[1].orderStatus,$scope.stuckOrderDetailsallStatus[2].orderStatus,$scope.stuckOrderDetailsallStatus[3].orderStatus,$scope.stuckOrderDetailsallStatus[4].orderStatus,$scope.stuckOrderDetailsallStatus[5].orderStatus,$scope.stuckOrderDetailsallStatus[6].orderStatus];
						$scope.dataDounuts =  [$scope.stuckOrderDetailsallStatus[0].count,$scope.stuckOrderDetailsallStatus[1].count,$scope.stuckOrderDetailsallStatus[2].count,$scope.stuckOrderDetailsallStatus[3].count,$scope.stuckOrderDetailsallStatus[4].count,$scope.stuckOrderDetailsallStatus[5].count,$scope.stuckOrderDetailsallStatus[6].count];	
					}
					
	       		},
		       function(errResponse){
	       			console.error('Error while fetching Currencies');
		       }
		);
	}
	
	$scope.init();
	  
	  
	  
	
});