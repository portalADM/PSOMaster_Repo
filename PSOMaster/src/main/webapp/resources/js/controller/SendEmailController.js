module.controller("SendEmailController",function($scope,$routeParams,$http,MessageService,SendEmailService){
	
	$scope.title="Send Email";
	
	$scope.sendEmailResponse={};
	
	$scope.sendEmail=function(){
		toEmailId=$scope.toEmail;
		ccEmailId=$scope.ccEmail;
		emailSubject=$scope.subject;
		emailContent=$scope.content;
		
		SendEmailService.sendEmailRes(toEmailId,ccEmailId,emailSubject,emailContent).then(
				function(d){
					$scope.sendEamilResponse = d;
					console.log($scope.sendEamilResponse);
				},
				function(errResponse){
					console.error('Error while sending Email ');
				}	
		);
	}
	
});