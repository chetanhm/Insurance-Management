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
			$http.put(baseUrl+"/policy?policyNumber="+policyNumber+"&status="+status);	
			$window.location.reload();
	};
});

allPolicy.controller("onePolicyController", function($scope,$stateParams,$http)
{
	var loadUser=JSON.parse(localStorage.getItem("user"));
	var result1 = $http.get(baseUrl+"/policy/"+loadUser.userName+"/"+$stateParams.policyNumber+"/").success(function(response)
			{
				var lastLocation="/dashboard/viewProduct/"+loadUser.userName+"/"+$stateParams.policyNumber;
				localStorage.setItem("lastLocation", lastLocation);
				$scope.policy=response;
				
				var result2 = $http.get(baseUrl+"/product/"+$scope.policy.policyName).success(function(response)
				{ 
					$scope.product=response;
				});			
			}); 
});
})();

