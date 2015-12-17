(function(){
	'use strict';
	
var imcharts = angular.module("imcharts", []);

imcharts.controller("ChartCtrl",function($scope,$http,$state){	
	
	$http.get(baseUrl+"/policy/status/all").success(function(response){
		$scope.policyLabels=response.labels;
		$scope.policyData=response.data;
		
		
	});
	
	$http.get(baseUrl+"/claim/type/all").success(function(response){
		$scope.claimLabels=response.labels;
		$scope.claimData=response.data;
		
		
	});
//	  $scope.labels = ["Download Sales", "In-Store Sales", "Mail-Order Sales"];
//	  $scope.data = [300, 500, 100];
	  
	  
});

})();
			