(function() {
	'use strict';
var mainApp=angular.module("insuranceApp",  ['ui.router','ngCookies','ui.bootstrap'])

mainApp.config(function ($urlRouterProvider, $stateProvider){
	
	$routeProvide
	 .when('/login', {
		 templateUrl: 'website.login.html',  
		 controller: 'login'
	 })
	 .otherwise({redirectTo: '/website.html'});          
         });

//mainApp.factory("User", function($resource) {
//    return $resource("users/:userId.json", {}, 
//    {
//        query: {method: "GET", params: {userId: "users"}, isArray: true}
//    });
//});

mainApp.controller('LoginController',function($scope)
{
	$scope.user = {
		    username: '',
		    password: ''
		  };
	 
	 $scope.loginUser = function(user) 
	    {
		 	var username=$scope.user.name;
	        var password=$scope.user.password;
	        if(user.username.length>3 && user.password.length>3)
	        {
	            page.setUser($scope.user);
	            $location.path( "/dashboard.html" );
	        }
	        else
	        {
	            $scope.message="Error";
	            $scope.messagecolor="alert alert-danger";
	        }
	    }
}
);

})();



