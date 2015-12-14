(function(){
	'use strict';
	

	
var register = angular.module("login", []);

register.controller("LoginCtrl",function($scope,$http,$resource,$location,$rootScope,toaster){
	
	
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
					var lastLocation=localStorage.getItem("lastLocation");
					if(lastLocation==null)
						{
						$location.path("website.home");	
						}
					else
						{
					    toaster.pop('info', "Logged In", "You are successfully logged in!");
						$location.path(lastLocation);

						localStorage.setItem("lastLocation", null);
						}
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
			