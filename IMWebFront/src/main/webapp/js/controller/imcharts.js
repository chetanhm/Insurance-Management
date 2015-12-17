(function(){
	'use strict';
	
var imcharts = angular.module("imcharts", []);

imcharts.controller("ChartCtrl",function($scope,$http,$state){	
	
	$http.get(baseUrl+"/chart/policy").success(function(response){
		$scope.policyLabels=response.labels;
		$scope.policyData=response.data;
		
		
	});
	
	$http.get(baseUrl+"/chart/claim/type").success(function(response){
		$scope.claimLabels=response.labels;
		$scope.claimData=response.data;
		
		
	});
//	  $scope.labels = ["Download Sales", "In-Store Sales", "Mail-Order Sales"];
//	  $scope.data = [300, 500, 100];
	  
	  
});

})();
			