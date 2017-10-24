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
					<h3 class="panel-title">Group List</h3>
				</div>
				<div class="panel-body">
					<div class="bs-component">
						<div class="form-group col-lg-2">
							<input type="text" class="form-control" ng-model="groupName" placeholder="Filter by Group/Role Name">
						</div>
						<div class="form-group col-lg-10">
							<span class="glyphicon glyphicon-plus-sign marLeft25  cursorPointer addGroupIcon" tooltip-placement="bottom" uib-tooltip="Add Group" ng-click="opneCreateGroupPopup()"></span>
						</div>
						<table class="table table-striped table-hover ">
							<thead>
								<tr>
									<th></th>
									<th>Group Name</th>
									<th>Drscription</th>
									<th>Role</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody  ng-repeat=" grp in groupList | filter: groupName">
								<tr>
									<td></td>
									<td>{{grp.name}}</td>
									<td>{{grp.desc}}</td>
									<td>{{grp.role}}</td>
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
			
			
			
			
			
			<!-- Create Group Popup Panel Start -->
			<div id="CreateGroup-modal" class="modal fade">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title">Create Group</h4>
						</div>
						<div class="modal-body ">
		                   <div class="row">
		                   		<form class="form-horizontal marLeft75">
									<div class="form-group">
										<label class="col-lg-2 control-label textAlgnInit">Group Name</label>
										<div class="col-lg-8">
											<input type="text" class="form-control" ng-model="groupData.name" placeholder="Group Name">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label textAlgnInit">Description</label>
										<div class="col-lg-8">
											<input type="text" class="form-control" ng-model="groupData.desc" placeholder="Group Description">
										</div>
									</div>
									<div class="form-group">
										<label for="select" class="col-lg-2 control-label textAlgnInit">Role</label>
										<div class="col-lg-8">
											<select class="form-control" ng-model="groupData.role">
												<option ng-repeat="role in roleList"  value="{{role}}">{{role}}</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-2">
										</div>
										<div class="col-lg-8">
											<button type="button" class="btn btn-default" ng-click="createGroup()">Add</button>
										</div>
									</div>
								</form>
						   </div>
						</div>
					</div>
				</div>
			</div>
			<!-- Create Group Popup Panel END -->


	</div>
</body>
</html>