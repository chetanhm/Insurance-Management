(function(){
	'use strict';
	
var imcharts = angular.module("imcharts", []);

imcharts.controller("ChartCtrl",function($scope,$http,$state){	
	
	$http.get(baseUrl+"/policy/status/total").success(function(response){
		$scope.policyLabels=response.labels;
		$scope.policyData=response.data;
		
		
	});
	
	$http.get(baseUrl+"/claim/type/total").success(function(response){
		$scope.claimLabels=response.labels;
		$scope.claimData=response.data;
		
		
	});

	  
	  
});

})();
			