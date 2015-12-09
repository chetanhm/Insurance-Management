(function(){
	'use strict';
	

	
var register = angular.module("login", []);

register.controller("LoginCtrl",function($scope,$http,$resource,$location){
	
	
	$scope.submit=function(){
	$scope.loginerrorshow=false;

	var result=$http.get(baseUrl+"/login?userName=" + $scope.userName + "&password=" + $scope.password).success(function(response)
			{
				var userDetails = response;
				if(userDetails!=null)
					{
					localStorage.setItem("user", JSON.stringify(userDetails));
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
			