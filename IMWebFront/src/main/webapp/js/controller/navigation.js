(function(){
	'use strict';
	
var browse = angular.module("navigation", []);
browse.directive('ngConfirmClick', [
                                        function(){
                                          return {
                                            priority: -1,
                                            restrict: 'A',
                                            link: function(scope, element, attrs){
                                              element.bind('click', function(e){
                                                var message = attrs.ngConfirmClick;
                                                if(message && !confirm(message)){
                                                  e.stopImmediatePropagation();
                                                  e.preventDefault();
                                                }
                                              });
                                            }
                                          }
                                        }
                                      ]);
browse.controller("NavigationController",function($scope,$rootScope){	

	
	$rootScope.$on("recheck",function()
			{
			var user=localStorage.getItem("user");
			if(user!=null)
				{
					$scope.hideRegister=true;
					$scope.hideLogin=true;
					$scope.hideLogout=false;
					$scope.hideDashboard=false;
					var loaduser=JSON.parse(localStorage.getItem("user"));
					$scope.welcomeMessage="Welcome" + loaduser.firstName;
				}
			else
				{
				$scope.hideRegister=false;
				$scope.hideLogin=false;
				$scope.hideLogout=true;
				$scope.hideDashboard=true;
				$scope.welcomeMessage="";
				}
			});
	$rootScope.$broadcast("recheck");
	
});

})();
			