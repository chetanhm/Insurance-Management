(function(){
	'use strict';
	
var browse = angular.module("browse", []);

browse.controller("BrowseCtrl",function($scope,$http){	
	var result=$http.get(baseUrl+"/product").success(function(response){
		var lastLocation="/website/browse";
		localStorage.setItem("lastLocation", lastLocation);
		$scope.productList=response;
	});


});

browse.directive("radioButton", function() {
	  return {
	    restrict: 'A',
	    require: 'ngModel',
	    link: function(scope, element, attrs, ctrl) {
	      element.bind('click', function () {
	        if (!element.hasClass('active')) {
	          scope.$apply(function () {
	            scope.transaction.debit = attrs.value;
	          });
	        }
	      });
	    }
	  };
	});
})();
			