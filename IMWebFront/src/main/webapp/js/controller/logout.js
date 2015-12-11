(function(){
	'use strict';
	

	
var logout = angular.module("logout", []);

logout.controller("LogoutCtrl",function($scope,$http,$resource,$location,$rootScope){
	
	var loaduser=JSON.parse(localStorage.getItem("user"));
	var result=$http.get(baseUrl+"/logout?id="+loaduser.id).success(function(response)
			{
				localStorage.removeItem("user");	
				$rootScope.$broadcast("recheck");
				
			}		
			);

	$location.path("website.home");	
});




})();

			