(function(){
	'use strict';
	

	
var agent = angular.module("agent", []);

agent.controller("AgentCtrl",function($scope,$http,$resource,$location,$rootScope){
	
	$scope.submit=function(){


	var loaduser=JSON.parse(localStorage.getItem("user"));
	var dataObj = {
			age: $scope.age,
			lastQualification : $scope.lastQualification,
			presentOccupation : $scope.presentOccupation,
			rewards : $scope.rewards,
			workExperience : $scope.workExperience,
			userName : loaduser.userName
			
	};
	var result=$http.post(baseUrl+"/agent",dataObj).success(function(response){
	$scope.hideForm=true;
	$scope.showSuccess=true;
		

	});


	
	}
});




})();
			