var baseUrl = "http://localhost:8080/imservices"; 
(function() {
	'use strict';
var mainApp=angular.module("insuranceApp",  ['ui.router','ngCookies','ui.bootstrap','register','login','ngResource', 'browse','viewProduct'])

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
		templateUrl: 'views/website.login.html',
		controller: 'LoginCtrl'
	});
	$stateProvider
	.state('dashboard', {
		url: '/dashboard',
		templateUrl: 'views/dashboard.html'
	});
      
	
	$stateProvider
	.state('website.register', {
		url: '/register',
		templateUrl: 'views/website.register.html',
		controller: 'RegistrationCtrl'
	});
	
	$stateProvider
	.state('website.browse', {
		url: '/browse',
		templateUrl: 'views/website.browse.html',
		controller: 'BrowseCtrl'
	});
	$stateProvider
	.state('website.viewProduct', {
		url: '/viewProduct/:productName',
		templateUrl: 'views/website.viewProduct.html',
		controller: 'ViewProductController'
	});
           
         });



})();