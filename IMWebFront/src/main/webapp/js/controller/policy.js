(function(){
	'use strict';
	
	var policies = angular.module("policy", []);
	
	policies.controller("respectivePoliciesCtrl",function($scope,$http,$stateParams){
		var loadUser=JSON.parse(localStorage.getItem("user"));
	
		var result=$http.get(baseUrl+"/policy/"+loadUser.userName).success(function(response)
		{
			$scope.allPolicies=response;
			if(response==[])
				{
					$scope.user="No policies";
					$scope.status="Fail";
					
				}
			else
				{
					$scope.user=loadUser.userName;
					$scope.listPolicies=response;
					$scope.status="Pass";
				
				}
			if($scope.allPolicies=='')
				{
				$scope.hideTable=true;
				$scope.showSuccess=false;
				}
			else
				{
				$scope.hideTable=false;
				$scope.showSuccess=true;
				}
		});				
		
	});
}
)();