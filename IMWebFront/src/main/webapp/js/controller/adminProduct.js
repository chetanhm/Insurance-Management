(function(){
	'use strict';
	
var browse = angular.module("adminproduct", []);

browse.controller("AddProductCtrl",function($scope,$http){	
	var range = [0];
	var terms=[];
	var currentRange=1;
	$scope.range=range;
	$scope.terms=terms;
	$scope.addRange=function()
	{
		$scope.range.push(currentRange++);
		
	}
	$scope.addProduct=function()
	{
		$scope.product.productTerms=terms;
		var adminId=JSON.parse(localStorage.getItem("user")).id;
		var config = {headers:  {
	             "_id" : adminId
	    }
		};
		$http.post(baseUrl+"/addProduct",$scope.product,config).success(function(data){
			
			$scope.successShow=true;
			$scope.alertType="success";
			$scope.alertMessage="Product added successfully";
			
		});
	}

});

})();
			