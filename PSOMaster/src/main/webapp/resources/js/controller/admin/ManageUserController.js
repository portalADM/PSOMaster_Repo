module.controller("ManageUserController", function($scope, $routeParams,$http,$location,$rootScope,Auth) 
{
	$scope.title = "Manage User";
	
	$scope.userList = [ {
							name : 'Gaurav Patel',email : 'gav.patel@amdocs.com',role : 'ADMIN',group : 'ADMINISTRATOR',company : 'AMDOCS'
						},{
							name : 'Shaista Shaikh',email : 'sha.sha@amdocs.com',role : 'REMIDIATOR',group : 'APP SUPPORT',company : 'AMDOCS'
						},{
							name : 'Nilesh Patil',email : 'nilesh.patil@amdocs.com',role : 'GUEST',group : 'ADM',company : 'AMDOCS'
						},{
							name : 'Chris Morris',email : 'chris.morris@Cricket.com',role : 'ADMIN',group : 'ADMINISTRATOR',company : 'Cricket'
						}];
	
	$scope.groupList = [ {
							name : 'ADMINISTRATOR',desc : 'Admin group',role : 'ADMIN'
						},{
							name : 'ADM',desc : 'ADM Group',role : 'GUEST'
						},{
							name : 'APP Support',desc : 'App Support group',role : 'REMIDIATOR'
						},{
							name : 'RT',desc : 'Reference table group',role : 'GUEST'
						}];
	
	$scope.roleList = ['ADMIN','REMIDIATOR','GUEST'];
	
	$scope.companyList = ['Cricket','AMDOCS'];
	
	$scope.groupData = {};
	
	
	$scope.opneCreateGroupPopup = function(){
		$("#CreateGroup-modal").modal();
	}
	
	$scope.opneEditGroupPopup = function(){
		$("#CreateGroup-modal").modal();
	}
	
	
	$scope.createGroup = function(){
		alert('createGroup');
	}
	
	$scope.editGroup = function(){
		alert('editGroup');
	}
	
	$scope.deleteGroup = function(){
		alert('deleteGroup');
	}
	
	
});