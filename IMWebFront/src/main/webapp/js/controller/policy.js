(function(){
	'use strict';
	
	var policies = angular.module("policy", []);
	
	policies.controller("respectivePoliciesCtrl",function($scope,$http,$stateParams){
		var loadUser=JSON.parse(localStorage.getItem("user"));
	
		var result=$http.get(baseUrl+"/policies/"+loadUser.userName).success(function(response)
		{
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
		});				
		
	});
}
)();