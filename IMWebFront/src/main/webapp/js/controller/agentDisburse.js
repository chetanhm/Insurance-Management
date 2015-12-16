(function(){
	'use strict';
	
var agent = angular.module("agentDisburse", []);

agent.controller("AgentDisburseCtrl",function($scope,$stateParams,$http){	

	var result=$http.get(baseUrl+"/claim?userName="+$stateParams.userName).success(function(response){
	
		var loadUser=JSON.parse(localStorage.getItem("user"));
		$scope.customerName=$stateParams.userName;
		$scope.claimDetailsList=response;
		if($scope.claimDetailsList=='')
			{
			$scope.showSuccess=false;
			$scope.hideTable=true;
			}
		else
			{
			$scope.showSuccess=true;
			}
		
	});

});
})();
			