<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
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
		
		<flash-message></flash-message> 
		
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
										<select class="form-control" ng-model="userSearch.groupId">
											<option value="">Select Group</option>
											<option ng-repeat="grp in groupList"  value="{{grp.groupId}}">{{grp.groupName}}</option>
										</select>
									</div>
								</div>
							</div>
							<div class="form-group col-lg-2">
								<div class="form-group">
									<div class="">
										<label class="control-label textAlgnInit">Role Name</label>
										<select class="form-control" ng-model="userSearch.roleId">
											<option value="">Select Role</option>
											<option ng-repeat="role in roleList"  value="{{role.roleId}}">{{role.roleName}}</option>
										</select>
									</div>
								</div>
							</div>
							<div class="form-group col-lg-2">
								<div class="form-group">
									<div class="">
										<label class="control-label textAlgnInit">Company Name</label>
										<select class="form-control" ng-model="userSearch.company">
											<option value="">Select Company</option>
											<option ng-repeat="com in companyList"  value="{{com}}">{{com}}</option>
										</select>
									</div>
								</div>
							</div>
							<div class="form-group col-lg-2">
								<div class="form-group">
									<div class="">
										<label class="control-label textAlgnInit">Employee ID / ATTUID</label>
										<input type="text" class="form-control" ng-model="userSearch.empId" placeholder="Employee ID / ATTUID">
									</div>
								</div>
							</div>
							<div class="form-group col-lg-4">
								<div class="form-group">
										<span class="glyphicon glyphicon-search marLeft25  cursorPointer searchUserIcon" tooltip-placement="bottom" uib-tooltip="Search Users" ng-click="searchUser()"></span>
								</div>
							</div>
						</div>
						<div class="row">
							<table class="table table-striped table-hover marTop20">
								<thead>
									<tr>
										<th>Emp ID / ATTUID</th>
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
										<td>{{user.empId}}</td>
										<td>{{user.firstName}} {{user.lastName}}</td>
										<td>{{user.email}}</td>
										<td>{{user.userGroup}}</td>
										<td>{{user.userRole}}</td>
										<td>{{user.company}}</td>
										<td>
											<a href="#userAssignments/{{user.empId}}/update" class="basicIconColor"><span class="glyphicon glyphicon-edit  cursorPointer clrBlue" tooltip-placement="bottom" uib-tooltip="Edit User assignments"></span></a>
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
										<th>Employee ID</th>
										<th>First Name</th>
										<th>Last Name</th>
										<th>Email</th>
										<th>Company</th>
										<th>Status</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody  ng-repeat="user in pendingUserList | filter: pendingUserName">
									<tr ng-class="(user.status=='R') ? ['highlightRowRed'] : []">
										<td></td>
										<td>{{user.empId}}</td>
										<td>{{user.firstName}}</td>
										<td>{{user.lastName}}</td>
										<td>{{user.email}}</td>
										<td>{{user.company}}</td>
										<td><b>{{(user.status=='R')?'REJECTED':'OPEN'}}</b></td>
										<td>
											<a href="#userAssignments/{{user.empId}}/create"  class="basicIconColor"><span class="glyphicon glyphicon-ok-circle  cursorPointer font21" tooltip-placement="bottom" uib-tooltip="Approve"></span></a>
											<span class="glyphicon glyphicon-remove-circle marLeft25 cursorPointer font21" ng-if="user.status!='R'" tooltip-placement="bottom" uib-tooltip="Reject" ng-click="rejectUserConfirm(user)"></span>
										</td>
									</tr>
								</tbody>
							</table> 
						</div>
					</div>
				</div>
			</div>
			
			
			
			<!-- Reject User confirmation Popup Panel Start -->
			<div id="RejectUserConfirmation-modal" class="modal fade">
				<div class="modal-dialog modal-lg confirmPopupWidth">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title">Are you sure want to reject this request?</h4>
						</div>
						<div class="modal-body ">
		                   <div class="row">
		                   		<form class="form-horizontal marLeft10">
									<div class="form-group col-lg-2">
										<textarea class="form-control" rows="3" cols="60" ng-model="reject.comments"></textarea>
									</div>
								</form>
						   </div>
						   <div class="row">
		                   		<form class="form-horizontal marLeft10">
									<div class="form-group col-lg-2">
											<button type="button" class="btn btn-default" ng-click="rejectUserRequest()">Yes</button>
									</div>
									<div class="form-group col-lg-2">
											<button type="button" class="btn btn-default" ng-click="closeRejectUserConfirmationPopup()">Cancel</button>
									</div>
								</form>
						   </div>
						</div>
					</div>
				</div>
			</div>
			<!-- Reject User confirmation Popup Panel END -->
		
		
	</div>
</body>
</html>