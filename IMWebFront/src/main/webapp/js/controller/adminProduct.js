(function(){
	'use strict';
	
var browse = angular.module("adminproduct", []);

browse.controller("AddProductCtrl",function($scope,$http,$state){	
	var range = [0];
	var terms=[];
	var currentRange=1;
	$scope.range=range;
	$scope.terms=terms;
	$scope.addRange=function()
	{
		$scope.range.push(currentRange++);
		
	}
	
	$scope.reAdd=function()
	{
	    $state.reload();
	}
	
	$scope.addProduct=function()
	{
		$http.get(baseUrl+"/checkProductName?productName="+$scope.product.productName).success(
		function(response)
		{

			if(!response)
				{
					$scope.product.productTerms=terms;
					var adminId=JSON.parse(localStorage.getItem("user")).id;
					var config = {headers:  {
			             "_id" : adminId
					}
					};
					$http.post(baseUrl+"/addProduct",$scope.product,config).success(function(data){
					
						if(data.productName!=$scope.product.productName)
							{
							$scope.successShow=true;
							
							$scope.alertType="danger";
							$scope.alertMessage="Unable to add product.";
							}
						else
							{
							$scope.successShow=true;
							$scope.formHide=true;
							$scope.alertType="success";
							$scope.alertMessage="Product added successfully";
							$scope.showReAddButton=true;
							}
					});
				}
			else
				{
				$scope.successShow=true;
				
				$scope.alertType="danger";
				$scope.alertMessage="Product name already exists";
			
				}
		}
		
		);
		

	}

});

})();
			