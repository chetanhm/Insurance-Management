(function(){
	'use strict';
	

	
var logout = angular.module("logout", []);

logout.controller("LogoutCtrl",function($scope,$http,$resource,$location){
	
	
	$scope.submit=function(){
	$scope.logouterrorshow=false;

	var result=$http.get(baseUrl+"/logout").success(function(response)
			{
				localstorage.setItem("user",null);
				$location.path("website.home");	
			}		
			).error(function(response){$scope.logouterrorshow=true;});

			}
});




})();

			