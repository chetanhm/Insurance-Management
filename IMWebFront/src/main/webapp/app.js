(function() {
	'use strict';
var mainApp=angular.module("insuranceApp",  ['ui.router','ngCookies','ui.bootstrap'])

mainApp.config(function ($urlRouterProvider, $stateProvider){
        	  
        	  
	$urlRouterProvider.otherwise('/website/home');
	$stateProvider
	.state('website', {
		url: '/website',
		templateUrl: 'views/website.html'
	});
	
	$stateProvider
	.state('website.home', {
		url: '/home',
		templateUrl: 'views/website.home.html'
	});
	$stateProvider
	.state('website.login', {
		url: '/login',
		templateUrl: 'views/website.login.html'
	});
	$stateProvider
	.state('dashboard', {
		url: '/dashboard',
		templateUrl: 'views/dashboard.html'
	});
      
           
         });



})();

