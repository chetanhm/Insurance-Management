(function(){
	'use strict';
	
var allPolicy = angular.module("allPolicies", []);

allPolicy.controller("allPolicyCtrl",function($scope,$http)
{	
	var result=$http.get(baseUrl+"/policy").success(function(response)
	{
		$scope.policyList=response;
	});
	$scope.setStatus= function(status,policyNumber)
	{
		console.log("status"+status);
		console.log("policyNumber"+policyNumber);
		$http.put(baseUrl+"/policy?policyNumber="+policyNumber+"&status="+status);
		
	};
});
})();

