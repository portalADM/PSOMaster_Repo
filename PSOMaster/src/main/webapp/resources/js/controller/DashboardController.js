module.controller("DashboardController", function($scope, $routeParams,$http,DashboardService) {
	
	$scope.title = "Dashboard";
	
	$scope.labels = ['1 June', '2 June', '3 June', '4 June', '5 June', '6 June', '7 June', '8 June', '9 June', '10 June'];
	  $scope.series = ['Series A', 'Series B'];
	  $scope.data = [
	    [65, 59, 80, 81, 56, 55, 40, 59, 80, 81],
	    [28, 48, 40, 19, 86, 27, 90, 59, 80, 81]
	  ];
	  $scope.onClick = function (points, evt) {
	    console.log(points, evt);
	  };
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
	  
	  
	  $scope.labelsPie = ["OSHF", "ORFI", "ORLF", "ACTF", "OURF", "PDRF", "PRTF"];
	  $scope.dataPie = [10,15,14,12,5,3,8];
	  
	  
	  $scope.labelsDounuts = ["OSHF", "ORFI", "ORLF", "ACTF", "OURF", "PDRF", "PRTF"];
	  $scope.dataDounuts = [10,15,14,12,5,3,8];
	  
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
	  
	  
	  // -------------------------------
	  
	  //
	$scope.init=function(){
		DashboardService.getStuckOrderCount().then(
				function(data) {
					$scope.stuckOrderDetails= data.stuckOrderList;
					console.log($scope.stuckOrderDetails);
	       		},
		       function(errResponse){
				console.error('Error while fetching Currencies');
		       }
		);
	}
	
	$scope.init();
	  
	  
	  
	
});