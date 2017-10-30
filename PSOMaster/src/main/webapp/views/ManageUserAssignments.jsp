<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>PSO Master</title>
</head>
<body>

	<div class=" clearfix">
		<div class="page-header noPadBtm">
			<h3 id="navbar">
				<span class="glyphicon glyphicon-user marRight8"></span>{{title}}
			</h3>
		</div>
	
	
		<flash-message></flash-message> 
	
		<div class="row">
			<form class="form-horizontal marLeft40">
				<div class="form-group">
					<label class="col-lg-2 control-label textAlgnInit">Employee / ATTUID</label>
					<div class="col-lg-8">
						<label class="control-label textAlgnInit">{{userData.empId}}</label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label textAlgnInit">First Name</label>
					<div class="col-lg-8">
						<label ng-if="oprType=='create'" class="control-label textAlgnInit">{{userData.firstName}}</label>
						<input type="text" ng-if="oprType=='update'" class="form-control" ng-model="userData.firstName" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label textAlgnInit">Last Name</label>
					<div class="col-lg-8">
						<label ng-if="oprType=='create'" class="control-label textAlgnInit">{{userData.lastName}}</label>
						<input type="text" ng-if="oprType=='update'" class="form-control" ng-model="userData.lastName" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label textAlgnInit">Email ID</label>
					<div class="col-lg-8">
						<label ng-if="oprType=='create'" class="control-label textAlgnInit">{{userData.email}}</label>
						<input type="text" ng-if="oprType=='update'" class="form-control" ng-model="userData.email" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label textAlgnInit">Company</label>
					<div class="col-lg-8">
						<label ng-if="oprType=='create'" class="control-label textAlgnInit">{{userData.company}}</label>
						<select ng-if="oprType=='update'" class="form-control" ng-model="userData.company">
							<option value="">Select Company</option>
							<option value="CRICKET">Cricket</option>
							<option value="AMDOCS">AMDOCS</option>
						</select>
					</div>
				</div>
				<div class="form-group">
						<label class="col-lg-2 control-label textAlgnInit">Assign Group</label>
						<div class="col-lg-8">
							<select class="form-control" ng-model="userData.groupId" ng-change="getRoleNameForSelectedGroup(userData.groupId)">
								<option value="">Select Company</option>
								<option ng-repeat="group in groupList"  value="{{group.groupId}}">{{group.groupName}}</option>
							</select>						
						</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label textAlgnInit">Role</label>
					<div class="col-lg-8">
						<label class="control-label textAlgnInit">{{userGroupRoleName}}</label>
					</div>
				</div>
				<div class="form-group marTop40">
					<div class="col-lg-2">
						<button type="button" class="btn btn-primary btn-block btn-large" ng-click="doUserAssignments()">Submit</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
</body>
</html>