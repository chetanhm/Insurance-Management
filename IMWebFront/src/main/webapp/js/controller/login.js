(function(){
	'use strict';
	

	
var register = angular.module("login", []);

register.controller("LoginCtrl",function($scope,$http,$resource,$location){
	
	
	$scope.submit=function(){
	$scope.loginerrorShow=false;

	var result=$http.get(baseUrl+"/login?userName=" + $scope.userName + "&password=" + $scope.password).success(function(response)
			{
				var userDetails = response.userDetails;
				if(userDetails!=null)
					{
					localStorage.setItem("user", userDetails);
					$location.path("dashboard");					
					}
				else
					{
					$scope.loginerrorShow=true;
					}
			}		
			).error(function(response){$scope.loginerrorShow=true;});

			}
});




})();
			