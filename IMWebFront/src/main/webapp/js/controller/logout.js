(function(){
	'use strict';
	

	
var logout = angular.module("logout", []);

logout.controller("LogoutCtrl",function($scope,$http,$resource,$location,$rootScope,toaster){
	
	var loaduser=JSON.parse(localStorage.getItem("user"));
	var result=$http.get(baseUrl+"/logout?id="+loaduser.id).success(function(response)
			{
				localStorage.removeItem("user");	
				$rootScope.$broadcast("recheck");
			    toaster.pop('info', "Notification", "You are logged out successfully ! ");
				
			}		
			);

	$location.path("website.home");	
});




})();

			