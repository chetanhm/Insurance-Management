(function(){
	'use strict';
	
var view = angular.module("viewProduct", []);

view.controller("ViewProductCtrl",function($scope,$stateParams,$http){	
	var result=$http.get(baseUrl+"/product?productName="+$stateParams.productName).success(function(response){
		var lastLocation="/website/viewProduct/"+$stateParams.productName;
		localStorage.setItem("lastLocation", lastLocation);
		$scope.product=response;
	});

});
})();
			