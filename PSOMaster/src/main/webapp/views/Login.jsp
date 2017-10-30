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
				<span class="glyphicon glyphicon-user marRight8"></span>Sign In
			</h3>
		</div>
	
	
		<div class="row">
			<form class="form-horizontal">
				<div class="form-group">
					<div class="col-lg-12">
						<input type="text" class="form-control" ng-model="username" placeholder="Username" required="required" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-12">
						<input type="password" class="form-control" ng-model="password" placeholder="Password" required="required" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-2">
						<button type="button" class="btn btn-primary btn-block btn-large" ng-click="authenticateUser()">Sign In</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<div class="row">
			<form class="form-horizontal">
				<div class="form-group">
					<div class="col-lg-2">
						<a href="#signUp" type="button" class="btn btn-primary btn-block btn-large" ">Sign Up</a>
					</div>
				</div>
			</form>
		</div>



	<!-- <div class="login">
    <h1>Login</h1>
    <form action="login" method="post">
    	<input type="text" name="username" placeholder="Username" required="required" />
        <input type="password" name="password" placeholder="Password" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Login</button>
    </form>
    <br>
</div> -->
</body>
</html>