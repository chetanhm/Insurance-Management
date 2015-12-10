(function(){
	'use strict';
	
var view = angular.module("buyProduct", []);


view.controller("BuyProductCtrl",function($scope,$stateParams,$http,$location){	
//alert($stateParams.productName);

	$scope.loaderShow=false;
	$scope.policy={};
	$scope.policy.productName=$stateParams.productName;
	$scope.apply=function()
	{
		var fd=new FormData();
		fd.append('file', document.getElementById('incomeProof').files[0]);
		$http.post(baseUrl+"/addFile", fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
        .success(function(response){
        	alert(response);
        })
        .error(function(){
        });
		
	}
	if(localStorage.getItem("user")==null)
	{
	$location.path("/website/login");
	}


});
})();
			