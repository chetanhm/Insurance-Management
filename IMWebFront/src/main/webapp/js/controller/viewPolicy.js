(function(){
	'use strict';
	
var allPolicy = angular.module("allPolicies", []);

allPolicy.controller("allPolicyCtrl",function($scope,$http)
{	
	var result=$http.get(baseUrl+"/policies").success(function(response)
	{
		$scope.policyList=response;
	});
	var result1=$http.post(baseUrl+"/policy").success(function(response)
	{
		$scope.policyData = response;
		var Data = policyData
	});
});
})();

