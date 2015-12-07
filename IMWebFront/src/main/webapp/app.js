(function() {
	'use strict';
var mainApp=angular.module("insuranceApp",  ['ui.router','ngCookies'])

mainApp.config(function ($urlRouterProvider, $stateProvider){
        	  
        	  
	$urlRouterProvider.otherwise('/home');

	$stateProvider
	.state('home', {
		url: '/home',
		templateUrl: 'views/website.html',
		controller: 'website'
	});
	$stateProvider
	.state('dashboard', {
		url: '/dashboard',
		templateUrl: 'views/dashboard.html'
	});
      
           
         });

mainApp.controller('website',function($scope)
{
	$scope.viewLoaded=function(){
		
		   $('.carousel').carousel({
		        interval: 5000 //changes the speed
		    });
		}
	}		
);


})();