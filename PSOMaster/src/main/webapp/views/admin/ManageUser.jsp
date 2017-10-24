<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class=" clearfix">
		<div class="row">
			<div class="col-lg-12">
				<div class="page-header noPadBtm">
					<h3 id="navbar">
						<span class="glyphicon glyphicon-list-alt marRight8"></span>{{title}}
					</h3>
				</div>
			</div>
		</div>
		
		
		<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">User List</h3>
				</div>
				<div class="panel-body">
					<div class="bs-component">
						<div class="row">
							<div class="form-group col-lg-2">
								<div class="form-group">
									<div class="">
										<label class="control-label textAlgnInit">Group Name</label>
										<select class="form-control" ng-model="groupName">
											<option value="">Select Group</option>
											<option ng-repeat="grp in groupList"  value="{{grp.name}}">{{grp.name}}</option>
										</select>
									</div>
								</div>
							</div>
							<div class="form-group col-lg-2">
								<div class="form-group">
									<div class="">
										<label class="control-label textAlgnInit">Role Name</label>
										<select class="form-control" ng-model="groupName">
											<option value="">Select Role</option>
											<option ng-repeat="role in roleList"  value="{{role}}">{{role}}</option>
										</select>
									</div>
								</div>
							</div>
							<div class="form-group col-lg-2">
								<div class="form-group">
									<div class="">
										<label class="control-label textAlgnInit">Company Name</label>
										<select class="form-control" ng-model="groupName">
											<option value="">Select Company</option>
											<option ng-repeat="com in companyList"  value="{{com}}">{{com}}</option>
										</select>
									</div>
								</div>
							</div>
							<div class="form-group col-lg-2">
								<div class="form-group">
									<div class="">
										<label class="control-label textAlgnInit">User Name</label>
										<input type="text" class="form-control" ng-model="userName" placeholder="User Name">
									</div>
								</div>
							</div>
							<div class="form-group col-lg-4">
								<div class="form-group">
										<span class="glyphicon glyphicon-search marLeft25  cursorPointer searchUserIcon" tooltip-placement="bottom" uib-tooltip="Search Users" ng-click="opneEditGroupPopup()"></span>
								</div>
							</div>
						</div>
						<div class="row">
							<table class="table table-striped table-hover marTop20">
								<thead>
									<tr>
										<th></th>
										<th>Name</th>
										<th>Email</th>
										<th>Group</th>
										<th>Role</th>
										<th>Company</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody  ng-repeat="user in userList">
									<tr>
										<td></td>
										<td>{{user.name}}</td>
										<td>{{user.email}}</td>
										<td>{{user.group}}</td>
										<td>{{user.role}}</td>
										<td>{{user.company}}</td>
										<td>
											<span class="glyphicon glyphicon-edit  cursorPointer clrBlue" tooltip-placement="bottom" uib-tooltip="Edit Group" ng-click="opneEditGroupPopup()"></span>
											<span class="glyphicon glyphicon-trash marLeft25 cursorPointer clrBlue" tooltip-placement="bottom" uib-tooltip="Delete Group" ng-click="deleteGroup()"></span>
										</td>
									</tr>
								</tbody>
							</table> 
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">Pending Approval List</h3>
				</div>
				<div class="panel-body">
					<div class="bs-component">
						<div class="form-group col-lg-2">
							<input type="text" class="form-control" ng-model="pendingUserName" placeholder="Filter by Name / Email">
						</div>
						<div class="row">
							<table class="table table-striped table-hover marTop20">
								<thead>
									<tr>
										<th></th>
										<th>Name</th>
										<th>Email</th>
										<th>Company</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody  ng-repeat="user in userList | filter: pendingUserName">
									<tr>
										<td></td>
										<td>{{user.name}}</td>
										<td>{{user.email}}</td>
										<td>{{user.company}}</td>
										<td>
											<span class="glyphicon glyphicon-ok-circle  cursorPointer font21" tooltip-placement="bottom" uib-tooltip="Approve" ng-click="opneEditGroupPopup()"></span>
											<span class="glyphicon glyphicon-remove-circle marLeft25 cursorPointer font21" tooltip-placement="bottom" uib-tooltip="Reject" ng-click="deleteGroup()"></span>
										</td>
									</tr>
								</tbody>
							</table> 
						</div>
					</div>
				</div>
			</div>
		
		
	</div>
</body>
</html>