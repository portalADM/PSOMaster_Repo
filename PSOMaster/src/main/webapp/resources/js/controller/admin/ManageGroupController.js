module.controller("ManageGroupController", function($scope, $routeParams,$http,$location,$rootScope,Auth) 
{
	$scope.title = "Manage Group";
	
	$scope.groupList = [ {
							name : 'ADMINISTRATOR',
							desc : 'Admin group',
							role : 'ADMIN'
						},{
							name : 'ADM',
							desc : 'ADM Group',
							role : 'GUEST'
						},{
							name : 'APP Support',
							desc : 'App Support group',
							role : 'REMIDIATOR'
						},{
							name : 'RT',
							desc : 'Reference table group',
							role : 'GUEST'
						}];
	
	$scope.roleList = ['ADMIN','REMIDIATOR','GUEST'];
	
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