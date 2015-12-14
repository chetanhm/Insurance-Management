(function(){
	'use strict';
	
var browse = angular.module("browse", []);

browse.controller("BrowseCtrl",function($scope,$http){	
	var result=$http.get(baseUrl+"/products").success(function(response){
		var lastLocation="website.browse";
		localStorage.setItem("lastLocation", lastLocation);
		$scope.productList=response;
	});


});

})();
			