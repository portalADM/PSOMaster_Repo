<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PSO Master</title>
<!-- <link rel="stylesheet" href="resources/css/login.css" media="screen"> -->
</head>
<body>

	<div class=" clearfix">
		<div class="page-header noPadBtm">
			<h3 id="navbar">
				<span class="glyphicon glyphicon-user marRight8"></span>Setup Password
			</h3>
		</div>
	
	<flash-message></flash-message> 
	
		<div class="row">
			<form class="form-horizontal marLeft15">
				<div class="form-group">
					<div class="col-lg-12">
						<input type="text" class="form-control" ng-model="userData.empId" placeholder="Employee Id" required="required" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-12">
						<input type="text" class="form-control" ng-model="userData.emailId" placeholder="Email ID" required="required" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-12">
						<input type="password" class="form-control" ng-model="userData.tempPassword" placeholder="Temporary Password" required="required" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-12">
						<input type="password" class="form-control" ng-model="userData.password" placeholder="New Password" required="required" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-12">
						<input type="password" class="form-control" ng-model="userData.confirmPassword" placeholder="Confirm Password" required="required" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-2">
						<button type="button" class="btn btn-primary btn-block btn-large" ng-click="setupUserPassword()">Submit</button>
					</div>
				</div>
			</form>
		</div>
		
		
		
		<!-- Setup Password Popup Panel start -->
			<div id="setuPassword-modal" class="modal fade">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title">Setup Password</h4>
						</div>
						<div class="modal-body">
							<div class="row">
					          <div class="col-lg-12">
					            <div class="">
					                <p>{{setupMessage}}</p>
					                <p><a class="btn btn-primary btn-lg" href="#login">Login</a></p>
					              </div>
					          </div>
					        </div>
						</div>
					</div>
				</div>
			</div>
			<!-- Setup Password Popup Panel start -->
		
	</div>
</body>
</html>