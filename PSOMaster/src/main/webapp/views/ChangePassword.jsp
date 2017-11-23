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
				<span class="glyphicon glyphicon-user marRight8"></span>Change Password
			</h3>
		</div>
	
	<flash-message></flash-message> 
	
		<div class="row">
			<form class="form-horizontal marLeft15">
				<div class="form-group">
					<label class="col-lg-2 control-label textAlgnInit">Employee Id</label>
					<div class="col-lg-8">
						<input type="text" class="form-control" ng-model="userData.empId" required="required" value="{{currentUserData.empId}}" ng-disabled="true"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label textAlgnInit">Current Password</label>
					<div class="col-lg-8">
						<input type="password" class="form-control" ng-model="userData.currentPassword" required="required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label textAlgnInit">New Password</label>
					<div class="col-lg-8">
						<input type="password" class="form-control" ng-model="userData.password" required="required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label textAlgnInit">Confirm Password</label>
					<div class="col-lg-8">
						<input type="password" class="form-control" ng-model="userData.confirmPassword" required="required" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-2">
					</div>
					<div class="col-lg-2">
						<button type="button" class="btn btn-primary btn-block btn-large" ng-click="changePassword()">Submit</button>
					</div>
				</div>
			</form>
		</div>
		
			
	</div>
</body>
</html>