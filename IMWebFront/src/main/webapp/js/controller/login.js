(function(){
	'use strict';
	

	
var register = angular.module("login", ['ngStorage']);

register.controller("LoginCtrl",function($scope,$http,$resource,$location,$localStorage){
	
	
	$scope.submit=function(){
	$scope.loginerrorshow=false;

	var result=$http.get(baseUrl+"/login?userName=" + $scope.userName + "&password=" + $scope.password).success(function(response)
			{
				var userDetails = response.userDetails;
				if(userDetails!=null)
					{
					$scope.$storage = $localStorage.$default({
				          user: userDetails
				        });
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
			