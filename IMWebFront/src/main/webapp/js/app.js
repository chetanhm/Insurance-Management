var baseUrl = "http://localhost:8080/imservices";
(function() {
	'use strict';
	var mainApp = angular.module("insuranceApp", [ 'ui.router', 'ngCookies',
			'ui.bootstrap', 'register', 'login', 'ngResource', 'browse',
			'viewProduct', 'navigation', 'logout', 'adminproduct', 'premium',
			'agent', 'buyProduct', 'allPolicies', 'policy' ,'disburse','ngAnimate','toaster',
			'claim','angular.filter','ngMessages','addManagedCustomer','monitor','agentDisburse','chart.js','imcharts']);

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
			templateUrl : 'views/dashboard.applyForAgent.html',
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
		$stateProvider.state('dashboard.agentDisburse', {
			url : '/agentDisburse/:userName',
			templateUrl : 'views/dashboard.agentDisburse.html',
			controller : 'AgentDisburseCtrl'
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
		$stateProvider.state('dashboard.addManagedCustomer', {
			url : '/addManagedCustomer',
			templateUrl : 'views/dashboard.addManagedCustomer.html',
			controller : 'CustomerCtrl'
		});
		$stateProvider.state('dashboard.agentClaim', {
			url : '/agentClaim',
			templateUrl : 'views/dashboard.agentClaim.html',
			controller : 'AgentClaimCtrl'
		});
		
		$stateProvider.state('dashboard.allAgents', {
			url : '/allAgents',
			templateUrl : 'views/dashboard.allAgents.html',
			controller : 'ApproveAgentCtrl'
		});
		$stateProvider.state('dashboard.listManagedCustomers',{
			url: '/listManagedCustomers',
			templateUrl: 'views/dashboard.agent.listManagedCustomers.html',
			controller : 'ListManagedCustomersCtrl'
			
		});
		$stateProvider.state('dashboard.applyForCustomer', {
			url : '/applyForCustomer/:userName',
			templateUrl : 'views/dashboard.agent.applyForCustomer.html',
			controller : 'ApplyForCustomerCtrl'
		});
		$stateProvider.state('dashboard.applyForCustomerForm', {
			url : '/applyForCustomerForm/:userName/:productName',
			templateUrl : 'views/dashboard.agent.applyForCustomerForm.html',
			controller : 'ApplyForCustomerFormCtrl'
		});
		
		$stateProvider.state('dashboard.allClaims', {
			url : '/allClaims',
			templateUrl : 'views/dashboard.allClaims.html',
			controller : 'AllClaimsCtrl'
		});
		$stateProvider.state('dashboard.monitorDisbursements', {
			url : '/monitorDisbursements',
			templateUrl : 'views/dashboard.agent.monitorDisbursements.html',
			controller : 'MonitorCtrl'
		});
		$stateProvider.state('dashboard.charts',{
			url : '/charts',
			templateUrl : 'views/dashboard.charts.html',
			controller : 'ChartCtrl'
			
		});
	});

})();