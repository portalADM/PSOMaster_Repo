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
				<span class="glyphicon glyphicon-user marRight8"></span>Sign Up
				<a href="#login" tooltip-placement="bottom" uib-tooltip="Login" class="glyphicon glyphicon-chevron-left floatRight cursorPointer"></a>
			</h3>
			<h3 id="navbar">
						
					</h3>
		</div>
	
	
		<flash-message></flash-message> 
	
		<div class="row">
			<form class="form-horizontal marLeft40" name="signUpForm">
				<div class="form-group">
					<label class="col-lg-2 control-label textAlgnInit">Create Username</label>
					<div class="col-lg-8">
						<input type="text" class="form-control col-lg-3" ng-model="userData.username" ng-blur="checkUserName()">
						<span class="glyphicon glyphicon-ok-circle col-lg-2 validUserIcon" ng-if="validUserName=='true' && userData.username!==''"></span>
						<span class="glyphicon glyphicon-remove-circle col-lg-2 invalidUserIcon" ng-if="validUserName=='false' && userData.username!==''"></span>
						<img src="resources/images/spinner.gif" class="img-fluid spinnerIcon " ng-if="validUserName=='' && userData.username!==''">
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label textAlgnInit">First Name</label>
					<div class="col-lg-8">
						<input type="text" class="form-control" ng-model="userData.firstName">
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label textAlgnInit">Last Name</label>
					<div class="col-lg-8">
						<input type="text" class="form-control" ng-model="userData.lastName">
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label textAlgnInit">Employee ID/ ATTUID</label>
					<div class="col-lg-8">
						<input type="text" class="form-control" ng-model="userData.empId" tooltip-placement="bottom" uib-tooltip="Your Employee ID or ATTUID" >
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label textAlgnInit" >Email ID</label>
					<div class="col-lg-8">
						<input type="text" class="form-control col-lg-3" name="signUpEmail" ng-model="userData.email" ng-pattern="/^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/" required>
						<span class="col-lg-4"  style="color:Red" ng-show="signUpForm.signUpEmail.$dirty&&signUpForm.signUpEmail.$error.pattern">Please Enter Valid Email</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label textAlgnInit">Company</label>
					<div class="col-lg-8">
						<select class="form-control" ng-model="userData.company">
							<option value="">Select Company</option>
							<option value="CRICKET">CRICKET</option>
							<option value="AMDOCS">AMDOCS</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-2">
					</div>
					<div class="col-lg-2">
						<button type="button" ng-disabled="isSignUpSuccess" class="btn btn-primary btn-block btn-large" ng-click="signUp()">Sign Up</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
</body>
</html>