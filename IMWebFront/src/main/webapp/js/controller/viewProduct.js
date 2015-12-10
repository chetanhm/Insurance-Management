(function(){
	'use strict';
	
var view = angular.module("viewProduct", []);

view.controller("ViewProductController",function($scope,$stateParams,$http){	
	var result=$http.get(baseUrl+"/viewProduct?productName="+$stateParams.productName).success(function(response){
		$scope.product=response;
	});

});

})();
			