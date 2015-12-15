(function(){
	'use strict';
	
	var claims = angular.module("claim", []);
	
	claims.controller("claimCtrl",function($scope,$http){
		var loadUser=JSON.parse(localStorage.getItem("user"));
	
		var result=$http.get(baseUrl+"/policy/"+loadUser.userName).success(function(response)
		{
			$scope.userName=loadUser.userName;
			$scope.listPolicies=response;				
		});		
		
		$scope.submit=function()
		{
			var fd = new FormData();
			fd.append('file', document.getElementById('filebutton').files[0]);
			$http.post(baseUrl + "/file", fd, {
				transformRequest : angular.identity,
				headers : {
					'Content-Type' : undefined
				}
			}).success(
					function(response) {
						
						
						var date=new Date();
						var dataObj = {
								userName : loadUser.userName,
								claimDocuments: response.fileName,
								claimType : $scope.claimType,
								policyName : $scope.policyName,
								claimAmount : $scope.claimAmount,
								claimStatus : "pending",
								aprrovedClaimAmount : "null" ,
								dateOfClaim : date.getFullYear() + "-" + date.getMonth() + "-" + date.getDate(),
								policyNumber : $scope.policyNumber
								
						};
						var result1=$http.post(baseUrl+"/claim", dataObj).success(function(response){
							$scope.showSuccess=true;
							$scope.hideForm=true;
							
						});
					});
		}
		
	});
	
})();