module.controller("DashboardController",function($scope, $routeParams, $http, DashboardService,$rootScope) {

	$scope.title = "Dashboard";
	$scope.dateList = [];
	$scope.backLogList = [];
	$scope.curDate = '';
	$scope.regOrderList=[];
	
	

	$scope.myDataSourcePie = {
		chart : {
			caption : "Order Stuck Status",
			subcaption : "",
			startingangle : "120",
			showlabels : "0",
			showlegend : "1",
			enablemultislicing : "0",
			slicingdistance : "15",
			showpercentvalues : "0",
			showpercentintooltip : "0",
			plottooltext : "Status : $label Count : $datavalue",
			theme : "ocean"
		},
		data : []
	}

	$scope.myDataSourceOrderHandledPie = {
		chart : {
			caption : "Order Stuck Status",
			subcaption : "",
			startingangle : "120",
			showlabels : "0",
			showlegend : "1",
			enablemultislicing : "0",
			slicingdistance : "15",
			showpercentvalues : "0",
			showpercentintooltip : "0",
			plottooltext : "Status : $label Count : $datavalue",
			theme : "ocean"
		},
		data : []
	}
	
	$scope.myOrdersCreatedSourcePie = {
			chart : {
				caption : "Total Regular Orders",
				subcaption : "",
				startingangle : "120",
				showlabels : "0",
				showlegend : "1",
				enablemultislicing : "0",
				slicingdistance : "15",
				showpercentvalues : "0",
				showpercentintooltip : "0",
				plottooltext : "Status : $label Count : $datavalue",
				theme : "ocean"
			},
			data : []
		}

	/*Stuck Order backlogs in last 10 Days*/
	$scope.myDataSource3 = {
		chart : {
			caption : '',
			subCaption : '',
			numberPrefix : "",
			theme : "ocean"
		},
		data : []
	};

	var curIndex = 0;
	$scope.showGraph = function(option) {
		if (option == 'prev')
			curIndex = (curIndex != 0) ? curIndex - 1 : curIndex;
		if (option == 'next')
			curIndex = (curIndex != 9) ? curIndex + 1 : curIndex;

		$scope.curDate = $scope.dateList[curIndex];

		filterDataByDate($scope.backLogList,$scope.curDate);

	}

	$scope.init = function() {
		
		$rootScope.spinner.on();

		/* Stuck Order counts for Table */
		DashboardService.getStuckOrderCount().then(function(data) {
						$rootScope.spinner.off()
						$scope.stuckOrderDetails = data.stuckOrderList;
					},
					function(errResponse) {
						console.error('Error while fetching Currencies');
					});

		/* Stuck Orders handled in Last 10 Days */
		DashboardService.getStuckOrderHandled().then(function(data) {
						var Data = [];
						angular.forEach(data.stuckOrderList,function(value, key) {
							var obj = {
								label : value.dateOfHandlingl,
								value : value.count
							}
							Data.push(obj);
						});
						$scope.myDataSourceOrderHandledPie.data = Data;
					},
					function(errResponse) {
						console.error('Error while fetching Currencies');
					});

		/* Orders stuck in different statuses */
		DashboardService.getStuckOrderallStatus().then(function(data) {
			
						if (data.stuckOrderList != undefined && data.stuckOrderList.length > 0) {
							var Data = [];
							angular.forEach(data.stuckOrderList,function(value,key) {
												var obj = {
													label : value.orderStatus,
													value : value.count
												}
												Data.push(obj);
							});
			
							$scope.myDataSourcePie.data = Data;
			
							/* Hide Chart label */
							$("tspan").filter(function(idx) {
									if (this.innerHTML.indexOf('FusionCharts XT Trial') == 0) {
										$(this).css("display","none")
									}
							});
						}
			
					},
					function(errResponse) {
						console.error('Error while fetching Currencies');
					});

		
		/* Stuck Order backlogs in last 10 Days */
		DashboardService.getStuckOrderBacklog().then(function(data) {
						$scope.dateList = data.dateList;
						$scope.curDate = $scope.dateList[0];
						$scope.backLogList = data.backLogList;
						
						filterDataByDate($scope.backLogList,$scope.curDate);
					},
					function(errResponse) {
						console.error('Error while fetching Currencies');
					});
		
		$scope.regularOrderStatistics = [];
		/* Regular Orders */
		DashboardService.getRegOrderCount().then(function(data) {
					$scope.regularOrderStatistics = data.regularOrderList;
					console.log($scope.regularOrderStatistics);
					},
					function(errResponse) {
						console.error('Error while fetching Currencies');
					});
		
		
	}
	
	/* Regular Order count for dynamic graph */
	$scope.getDynamicGraphData=function(){
		
		var DynGraphRequest={
				"fromDate": $scope.fromDate,
				"toDate"  : $scope.toDate,
				"type"    : $scope.typeSelect
		}
		
		console.log(DynGraphRequest);
		
		DashboardService.getDynRegOrderCount(DynGraphRequest).then(function(data){
			$scope.ordertype=data.type;
			$scope.regOrderList=data.regularOrderList
			console.log("DynGraph Controller");
			console.log($scope.regOrderList);
			console.log($scope.ordertype);
			$scope.myOrdersCreatedSourcePie.data = [];
			$scope.totalDynCount = 0;
			if (data.regularOrderList != undefined && data.regularOrderList.length > 0) {
				var Data = [];
				angular.forEach(data.regularOrderList,function(value,key) {
									var obj = {
										label : value.date,
										value : value.count
									}
									Data.push(obj);
									
									$scope.totalDynCount = $scope.totalDynCount +value.count;
				});
			$scope.myOrdersCreatedSourcePie.data = Data;
			$scope.myOrdersCreatedSourcePie.chart.caption = $scope.typeSelect;
			
			}},
		function(errResponse){
			console.error('Error while fetching dynamicRegular Order response')
		
		});
	}

	$scope.init();
	
	
	function filterDataByDate(backLogListData,curDate){
		
		angular.forEach(backLogListData , function(value, key) {
			
			if (key == curDate) {
				
				var dataFroGraph = [];
				angular.forEach(value , function(value1, key) {
					var obj = {
							label : value1.statusCode,
							value : value1.count
					}
					dataFroGraph.push(obj);
				});
				
				$scope.myDataSource3 = {
					chart : {
						caption : key,
						subCaption : key,
						numberPrefix : "",
						theme : "ocean"
					},
					data : dataFroGraph
				};
			}
		});
		
	}
	
	
	
	/*Show Dynamic Graph Code Start*/
	$scope.showDynamicGraphPopup = function(){
		$scope.fromDate = '2017-JAN-20';
		$scope.toDate = '2017-MAR-20';
		
		$("#DynamicGraph-modal").modal();
	}
	/*Show Dynamic Graph Code End*/

});