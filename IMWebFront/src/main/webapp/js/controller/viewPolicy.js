(function(){
	'use strict';
	
var allPolicy = angular.module("allPolicies", []);

allPolicy.controller("allPolicyCtrl",function($scope,$http)
{	
	var result=$http.get(baseUrl+"/policies").success(function(response)
	{
		$scope.policyList=response;
	});

});
})();

