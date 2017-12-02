module.controller("UserAssignmentController", function($scope, $routeParams,$location,UserService,$rootScope,Auth,MessageService,ManageGroupService) 
{
	$scope.title = "Manage User Assignments";
	
	$scope.companyList = ['Cricket','AMDOCS'];
	
	$scope.employeeId = $routeParams.employeeId;
	$scope.oprType = $routeParams.oprType;
	
	$scope.userData = {};
	
	$scope.pendingUserList = [];
	
	$scope.init = function()
	{
		MessageService.hideMessage();
		getGroupList();
		if($scope.oprType == 'create')
			getPendingUserDetailsByEmpId($scope.employeeId);
		else
			getApprovedUserDetailsByEmpId($scope.employeeId);
	}
	
	$scope.init();
	
	
	$scope.getRoleNameForSelectedGroup = function(selectedGroupId)
	{
		angular.forEach($scope.groupList, function(value, key) {
			  if(value.groupId === angular.fromJson(selectedGroupId))
				  $scope.userGroupRoleName = value.roleName;
		});
	}
	
	$scope.doUserAssignments = function()
	{
		MessageService.hideMessage();
		if($scope.oprType == 'create')
			saveUserAssignments($scope.userData);
		else
			updateUserAssignments($scope.userData);
	}
	
	$scope.updateUserAssignments = function(){
		console.log($scope.userData);
		
	}
	
	/*
	 * Get list of groups
	 */
	function getGroupList()
	{
		ManageGroupService.getGroupList().then(function(data) {
			if(data!=undefined && data.length>0){
				$scope.groupList = data;
			}
		},
		function(errResponse) {
			console.error('Error while fetching Currencies');
		});
	}
	
	/*
	 * Get Pending use details
	 */
	function getPendingUserDetailsByEmpId(employeeId)
	{
		MessageService.hideMessage();
		$rootScope.spinner.on();
		UserService.getPendingUserDetailsByEmpId(employeeId).then(function(data) {
			if(data!=undefined && data!=null){
				$rootScope.spinner.off();
				$scope.userData = data;
			}
			else{
				MessageService.showSuccess('Error while fetching user details. Please try again later.',5000);
			}
		},
		function(errResponse) {
			$rootScope.spinner.off();
			MessageService.showSuccess('Error while fetching user details. Please try again later.',5000);
		});
	}
	
	/*
	 * Get approved use details by Employee ID
	 */
	function getApprovedUserDetailsByEmpId(employeeId)
	{
		MessageService.hideMessage();
		$rootScope.spinner.on();
		UserService.getUserDetailsByEmpId(employeeId).then(function(data) {
			if(data!=undefined && data!=null){
				$rootScope.spinner.off();
				$scope.userData = data;
			}
			else{
				MessageService.showSuccess('Error while fetching user details. Please try again later.',5000);
			}
		},
		function(errResponse) {
			$rootScope.spinner.off();
			MessageService.showSuccess('Error while fetching user details. Please try again later.',5000);
		});
	}
	
	/*
	 * Saves user assignments in the DB
	 */
	function saveUserAssignments(userAssignmentData)
	{
		MessageService.hideMessage();
		$rootScope.spinner.on();
		UserService.doUserAssignment(userAssignmentData).then(function(response) {
			$rootScope.spinner.off();
			if(response!=undefined && response!=null)
			{
				if(response.errorCode == 0){
					MessageService.showSuccess(response.errorMsg,5000);
					$location.path('/manageUser');
				}
				else{
					var errorMessage = response.errorMsg + ((response.logRefId!==null) ? "\n Log Reference ID : " + response.logRefId : '');
					MessageService.showError(errorMessage,10000);
				}
			}
		},
		function(errResponse) {
			$rootScope.spinner.off();
			MessageService.showSuccess('Error while saving user assignments. Please try again later.',5000);
		});
	}
	
	/*
	 * Updates user assignments in the DB
	 */
	function updateUserAssignments(userAssignmentData)
	{
		MessageService.hideMessage();
		$rootScope.spinner.on();
		UserService.updateUserAssignment(userAssignmentData).then(function(response) {
			$rootScope.spinner.off();
			if(response!=undefined && response!=null)
			{
				if(response.errorCode == 0){
					MessageService.showSuccess(response.errorMsg,5000);
					$location.path('/manageUser');
				}
				else{
					var errorMessage = response.errorMsg + ((response.logRefId!==null) ? "\n Log Reference ID : " + response.logRefId : '');
					MessageService.showError(errorMessage,10000);
				}
			}
		},
		function(errResponse) {
			$rootScope.spinner.off();
			MessageService.showSuccess('Error while saving user assignments. Please try again later.',5000);
		});
	}
	
});