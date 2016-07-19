<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PSO Master</title>
<link rel="stylesheet" href="resources/css/bootstrap.css" media="screen">
<link rel="stylesheet" href="resources/css/bootswatch.min.css" media="screen">
<link rel="stylesheet" href="resources/css/psoStyle.css" media="screen">
</head>
<body ng-app="PSOMaster">
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a href="#dashboard" class="navbar-brand"> <span
					class="glyphicon glyphicon-briefcase marRight8"></span>PSO Master
				</a>
				<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target="#navbar-main">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="navbar-collapse collapse" id="navbar-main">
				<ul class="nav navbar-nav">
					<li><a href="#/dashboard">Dashboard</a></li>
					<li><a href="#/orderMaster">Order Master</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#" id="themes"><span
							class="glyphicon glyphicon-user marRight8"></span>Hi John Snow <span
							class="caret"></span></a>
						<ul class="dropdown-menu" aria-labelledby="themes">
							<li><a href="../default/">Logout</a></li>
						</ul></li>
				</ul>

			</div>
		</div>
	</div>


	<div class="container">

		<div class=" clearfix marTop20">
			<div class="row" ng-show="false">
				<div class="col-lg-12">
					<div class="bs-component">
						<div class="alert alert-dismissible alert-warning">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<span class="glyphicon glyphicon-exclamation-sign marRight8"></span><strong>Oh snap!</strong> <a href="#" class="alert-link">Change
								a few things up</a> and try submitting again.
							</p>
						</div>
					</div>
				</div>
			</div>
			<div class="row" ng-show="false">
				<div class="col-lg-12">
					<div class="bs-component">
						<div class="alert alert-dismissible alert-danger">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<span class="glyphicon glyphicon-thumbs-down marRight8"></span><strong>Oh snap!</strong> <a href="#" class="alert-link">Change
								a few things up</a> and try submitting again.
						</div>
					</div>
				</div>
			</div>
			<div class="row" ng-show="false">
				<div class="col-lg-12">
					<div class="bs-component">
						<div class="alert alert-dismissible alert-success">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<span class="glyphicon glyphicon-thumbs-up marRight8"></span><strong>Well done!</strong> You successfully read <a href="#"
								class="alert-link">this important alert message</a>.
						</div>
					</div>
				</div>
			</div>
			<div class="row" ng-show="false">
				<div class="col-lg-12">
					<div class="bs-component">
						<div class="alert alert-dismissible alert-info">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<span class="glyphicon glyphicon-info-sign marRight8"></span><strong>Heads up!</strong> This <a href="#" class="alert-link">alert
								needs your attention</a>, but it's not super important.
						</div>
					</div>
				</div>
			</div>
		</div>


		<div ng-view></div>
	</div>

	<!-- Application Libreries Import -->
	<script src="resources/js/libs/jquery/jquery-1.10.2.min.js"></script>
	<script src="resources/js/libs/angularjs/angular.min.js"></script>
	<script src="resources/js/libs/angularjs/angular-animate.js"></script>
	<script src="resources/js/libs/angularjs/angular-route.min.js"></script>
	<script src="resources/js/libs/angularjs/angular-sanitize.min.js"></script>
	<script src="resources/js/libs/bootstrap/ui-bootstrap-tpls-1.3.3.js"></script>
	<script src="resources/js/libs/bootstrap/bootstrap.min.js"></script>
	<script src="resources/js/libs/bootstrap/bootswatch.js"></script>
	<script src="resources/js/libs/jquery/jquery-ui.js"></script>
	<script src="resources/js/libs/charts/Chart.js"></script>
	<script src="resources/js/libs/charts/angular-chart.js"></script>

	<!-- Application Modules Controller Import -->
	<script src="resources/js/app.js"></script>
	<script src="resources/js/controller/DashboardController.js"></script>
	<script src="resources/js/controller/OrderMasterController.js"></script>
	<script src="resources/js/controller/UpdateOrderController.js"></script>
	<script src="resources/js/controller/StuckOrderDetailsController.js"></script>

	<!-- Application Modules Services Import -->
	<script src="resources/js/service/OrderService.js"></script>
	<script src="resources/js/libs/utils/CommonUtils.js"></script>


</body>
</html>