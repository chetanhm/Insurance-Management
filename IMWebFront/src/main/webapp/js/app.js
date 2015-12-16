var baseUrl = "http://localhost:8080/imservices";
(function() {
	'use strict';
	var mainApp = angular.module("insuranceApp", [ 'ui.router', 'ngCookies',
			'ui.bootstrap', 'register', 'login', 'ngResource', 'browse',
			'viewProduct', 'navigation', 'logout', 'adminproduct', 'premium',
			'agent', 'buyProduct', 'allPolicies', 'policy' ,'disburse','ngAnimate','toaster',
			'claim','angular.filter','ngMessages']);

	mainApp.config(function($urlRouterProvider, $stateProvider) {

		$urlRouterProvider.otherwise('/website/home');
		$stateProvider.state('website', {
			url : '/website',
			templateUrl : 'views/website.html'
		});
		$stateProvider.state('logout', {
			url : '/logout',
			controller : 'LogoutCtrl',
			templateUrl : 'views/website.html'
		});

		/**
		 * Website sub states
		 */
		$stateProvider.state('website.home', {
			url : '/home',
			templateUrl : 'views/website.home.html'
		});
		$stateProvider.state('website.login', {
			url : '/login',
			templateUrl : 'views/website.login.html',
			controller : 'LoginCtrl'
		});

		$stateProvider.state('website.register', {
			url : '/register',
			templateUrl : 'views/website.register.html',
			controller : 'RegistrationCtrl'
		});

		$stateProvider.state('website.browse', {
			url : '/browse',
			templateUrl : 'views/website.browse.html',
			controller : 'BrowseCtrl'
		});
		$stateProvider.state('website.viewProduct', {
			url : '/viewProduct/:productName',
			templateUrl : 'views/website.viewProduct.html',
			controller : 'ViewProductCtrl'
		});
		$stateProvider.state('website.buyProduct', {
			url : '/buyProduct/:productName',
			templateUrl : 'views/website.buyProduct.html',
			controller : 'BuyProductCtrl'
		});
		/**
		 * Dashboard substates
		 */
		$stateProvider.state('dashboard', {
			url : '/dashboard',
			templateUrl : 'views/dashboard.html',
			controller : function($scope) {
				$scope.user = JSON.parse(localStorage.getItem("user"));
			}
		});

		$stateProvider.state('dashboard.home', {
			url : '/home',
			templateUrl : 'views/dashboard.home.html'
		});

		$stateProvider.state('dashboard.addProduct', {
			url : '/addProduct',
			templateUrl : 'views/dashboard.addProduct.html',
			controller : 'AddProductCtrl'
		});

		$stateProvider.state('dashboard.premium', {
			url : '/premium',
			templateUrl : 'views/dashboard.premium.html',
			controller : 'CalculatePremiumCtrl'
		});

		$stateProvider.state('dashboard.applyForAgent', {
			url : '/applyForAgent',
			templateUrl : 'views/dashboard.agent.html',
			controller : 'AgentCtrl'
		});

		$stateProvider.state('dashboard.allPolicies', {
			url : '/allPolicies',
			templateUrl : 'views/dashboard.allPolicies.html',
			controller : 'allPolicyCtrl'
		});

		$stateProvider.state('dashboard.respectivePolicies', {
			url : '/respectivePolicies',
			templateUrl : 'views/dashboard.respectivePolicies.html',
			controller : 'respectivePoliciesCtrl'
		});
		
		
		$stateProvider.state('dashboard.disburse', {
			url : '/disburse',
			templateUrl : 'views/dashboard.disburse.html',
			controller : 'DisburseCtrl'
		});
 
		$stateProvider.state('dashboard.claim', {
			url : '/claim',
			templateUrl : 'views/dashboard.claim.html',
			controller : 'claimCtrl'
		});
		

		$stateProvider.state('dashboard.viewProduct', {
			url : '/viewProduct/:policyNumber',
			templateUrl : 'views/dashboard.viewProduct.html',
			controller : 'onePolicyController'
		});
		
	});

})();