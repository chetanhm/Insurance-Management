(function(){
	'use strict';
	
var browse = angular.module("browse", []);

browse.controller("BrowseCtrl",function($scope,$http){	
	var result=$http.get(baseUrl+"/allProducts").success(function(response){
		$scope.productList=response;
	});


});

})();
			