(function(){
	'use strict';
	
var calculatePremium = angular.module("premium", []);

calculatePremium.controller("CalculatePremiumCtrl",function($scope,$http,$stateParams){	
	var loaduser=JSON.parse(localStorage.getItem("user"));

	var result=$http.get(baseUrl+"/getPremium?userName="+loaduser.userName).success(function(response){
		$scope.userName=loaduser.userName;
		if(response==[])
			{
			$scope.totalPremium="You don't have any policy enrolled."
			$scope.status="Fail";
			}
		else
			{
			$scope.totalPremium=response + " INR";
		$scope.status="Pass";
			}
		
	});
	var reslt=$http.get(baseUrl+"/getAllPolicies?userName="+loaduser.userName).success(function(response){
		$scope.listPolicies=response;
		
	});

});
})();