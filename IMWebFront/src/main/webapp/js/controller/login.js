(function(){
	'use strict';
	

	
var register = angular.module("login", []);

register.controller("LoginCtrl",function($scope,$http,$resource,$location,$rootScope){
	
	
	$scope.submit=function(){
	$scope.loginerrorshow=false;

	var result=$http.get(baseUrl+"/login?userName=" + $scope.userName + "&password=" + $scope.password).success(function(response)
			{
				var userDetails = response;
				if(userDetails.userName==$scope.userName)
					{
					userDetails.password="";
					localStorage.setItem("user", JSON.stringify(userDetails));
					$rootScope.$broadcast("recheck");
					$location.path("website.home");					
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
			