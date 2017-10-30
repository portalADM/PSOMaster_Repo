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
<link rel="stylesheet" href="resources/js/libs/loadMask/treasure-overlay-spinner.css" media="screen">

</head>
<body ng-app="PSOMaster">
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container menuBgClr ">
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
					<li permission="['ADMINISTRATOR','REMIDIATOR','GUEST']"><a href="#/dashboard">Dashboard</a></li>
					<li permission="['ADMINISTRATOR','REMIDIATOR','GUEST']"><a href="#/orderMaster">Order Master</a></li>
					<li class="dropdown" permission="['ADMINISTRATOR']">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#" id="themes">Admin<span class="caret marLeft8"></span>
						</a>
						<ul class="dropdown-menu" aria-labelledby="themes">
							<li><a href="#/login">Manage Help</a></li>
							<li><a href="#/manageGroup">Manage Group</a></li>
							<li><a href="#/manageUser">Manage User</a></li>
						</ul>
					</li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#" id="themes"><span
							class="glyphicon glyphicon-user marRight8"></span>Hi User<span
							class="caret"></span></a>
						<ul class="dropdown-menu" aria-labelledby="themes">
							<li><a href="#/login">Logout</a></li>
						</ul></li>
				</ul>

			</div>
		</div>
	</div>

	<treasure-overlay-spinner active='spinner.active'>
	<div class="container minContainerHeight">
		<div ng-view></div>
	</div>
    </treasure-overlay-spinner> 
    
	<!-- Application Libreries Import -->
	<script src="resources/js/libs/jquery/jquery-1.10.2.min.js"></script>
	<script src="resources/js/libs/angularjs/angular.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-resource/1.3.0/angular-resource.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/ngStorage/0.3.11/ngStorage.js"></script>
	<script src="resources/js/libs/angularjs/angular-animate.js"></script>
	<script src="resources/js/libs/angularjs/angular-route.min.js"></script>
	<script src="resources/js/libs/angularjs/angular-sanitize.min.js"></script>
	<script src="resources/js/libs/angularjs/angular-flash.js"></script>
	<script src="resources/js/libs/bootstrap/ui-bootstrap-tpls-1.3.3.js"></script>
	<script src="resources/js/libs/bootstrap/bootstrap.min.js"></script>
	<script src="resources/js/libs/bootstrap/bootswatch.js"></script>
	<script src="resources/js/libs/jquery/jquery-ui.js"></script>
	<!-- <script src="resources/js/libs/charts/Chart.js"></script>
	<script src="resources/js/libs/charts/angular-chart.js"></script> -->
	<script src="resources/js/libs/charts/fusionChart/fusioncharts.js"></script>
	<script src="resources/js/libs/charts/fusionChart/fusioncharts.charts.js"></script>
	<script src="resources/js/libs/charts/fusionChart/angular-fusioncharts.min.js"></script>
	<script src="resources/js/libs/utils/xml2json.js"></script>
	<script src="resources/js/libs/loadMask/treasure-overlay-spinner.js"></script>
	
	<script src="resources/js/libs/charts/fusionChart/themes/fusioncharts.theme.carbon.js"></script>
	<script src="resources/js/libs/charts/fusionChart/themes/fusioncharts.theme.fint.js"></script>
	<script src="resources/js/libs/charts/fusionChart/themes/fusioncharts.theme.ocean.js"></script>
	<script src="resources/js/libs/charts/fusionChart/themes/fusioncharts.theme.zune.js"></script>
	
	<!-- Application Modules Controller Import -->
	<script src="resources/js/app.js"></script>
	<script src="resources/js/service/AuthServices.js"></script>
	<script src="resources/js/controller/DashboardController.js"></script>
	<script src="resources/js/controller/OrderMasterController.js"></script>
	<script src="resources/js/controller/UpdateOrderController.js"></script>
	<script src="resources/js/controller/StuckOrderDetailsController.js"></script>
	<script src="resources/js/controller/SendEmailController.js"></script>
	<script src="resources/js/controller/LoginController.js"></script>
	<script src="resources/js/controller/admin/ManageGroupController.js"></script>
	<script src="resources/js/controller/admin/ManageUserController.js"></script>
	<script src="resources/js/controller/SignupController.js"></script>
	<script src="resources/js/controller/UserAssignmentController.js"></script>

	<!-- Application Modules Services Import -->
	<script src="resources/js/service/OrderService.js"></script>
	<script src="resources/js/service/DashboardService.js"></script>
	<script src="resources/js/service/UpdateOrderService.js"></script>
	<script src="resources/js/libs/utils/CommonUtils.js"></script>
	<script src="resources/js/libs/utils/MessageService.js"></script>
	<script src="resources/js/service/FileUploadService.js"></script>
	<script src="resources/js/service/AppDataService.js"></script>
	<script src="resources/js/service/SendEmailService.js"></script>
	<script src="resources/js/service/ManageGroupService.js"></script>
	<script src="resources/js/service/SignupService.js"></script>
	<script src="resources/js/service/UserService.js"></script>
	
	<!-- Application Modules Directives Import -->
	<script src="resources/js/directive/fileModel.js"></script>

</body>
</html>
