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
<link rel="stylesheet" href="resources/css/angular-flash.css" media="screen">
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
		<div ng-view></div>
	</div>

	<!-- Application Libreries Import -->
	<script src="resources/js/libs/jquery/jquery-1.10.2.min.js"></script>
	<script src="resources/js/libs/angularjs/angular.min.js"></script>
	<script src="resources/js/libs/angularjs/angular-animate.js"></script>
	<script src="resources/js/libs/angularjs/angular-route.min.js"></script>
	<script src="resources/js/libs/angularjs/angular-sanitize.min.js"></script>
	<script src="resources/js/libs/angularjs/angular-flash.js"></script>
	<script src="resources/js/libs/bootstrap/ui-bootstrap-tpls-1.3.3.js"></script>
	<script src="resources/js/libs/bootstrap/bootstrap.min.js"></script>
	<script src="resources/js/libs/bootstrap/bootswatch.js"></script>
	<script src="resources/js/libs/jquery/jquery-ui.js"></script>
	<script src="resources/js/libs/charts/Chart.js"></script>
	<script src="resources/js/libs/charts/angular-chart.js"></script>
	<script src="resources/js/libs/utils/xml2json.js"></script>

	<!-- Application Modules Controller Import -->
	<script src="resources/js/app.js"></script>
	<script src="resources/js/controller/DashboardController.js"></script>
	<script src="resources/js/controller/OrderMasterController.js"></script>
	<script src="resources/js/controller/UpdateOrderController.js"></script>
	<script src="resources/js/controller/StuckOrderDetailsController.js"></script>
	<script src="resources/js/controller/SendEmailController.js"></script>

	<!-- Application Modules Services Import -->
	<script src="resources/js/service/OrderService.js"></script>
	<script src="resources/js/service/DashboardService.js"></script>
	<script src="resources/js/service/UpdateOrderService.js"></script>
	<script src="resources/js/libs/utils/CommonUtils.js"></script>
	<script src="resources/js/libs/utils/MessageService.js"></script>
	<script src="resources/js/service/FileUploadService.js"></script>
	<script src="resources/js/service/AppDataService.js"></script>
	<script src="resources/js/service/SendEmailService.js"></script>
	
	<!-- Application Modules Directives Import -->
	<script src="resources/js/directive/fileModel.js"></script>

</body>
</html>
