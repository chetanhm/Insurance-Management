(function(){
	'use strict';
	
	var baseUrl = "http://localhost:8080/imservices"; 
	
var register = angular.module("login", []);

register.controller("LoginCtrl",function($scope,$http,$resource,$location){
	
	
	$scope.submit=function(){
	$scope.loginerrorshow=false;

	var result=$http.get(baseUrl+"/login?userName=" + $scope.userName + "&password=" + $scope.password).success(function(response)
	{
		if(response.status=="ok")
			{
			$location.path("dashboard");
			}
		else
			{
			$scope.loginerrorshow=true;
			}
	}		
	).error(function(response){$scope.loginerrorshow=true;});

	}
});




})();
			