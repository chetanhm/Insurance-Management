(function(){
	'use strict';
	
var disburse = angular.module("disburse", []);

disburse.controller("DisburseCtrl",function($scope,$http){	
	
		var loadUser=JSON.parse(localStorage.getItem("user"));
	var result=$http.get(baseUrl+"/claim?userName="+loadUser.userName).success(function(response){
		$scope.userName=loadUser.userName;
		$scope.claimDetailsList=response;
	});
	 
});
})();
		