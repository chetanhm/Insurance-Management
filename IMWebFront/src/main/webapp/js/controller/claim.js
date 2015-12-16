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
						
						if($scope.claimAmount==undefined || $scope.policyName==undefined || $scope.policyNumber==undefined || $scope.claimType==undefined )
							{
							if($scope.claimAmount==undefined )
							alert("Re enter the amount with positive number");
							else if($scope.policyName==undefined )
								alert("Select the Policy Name");
							else if($scope.policyNumber==undefined)
								alert("Select the policy number");
							else if($scope.claimType==undefined )
								alert("Select the type of claim ");
							}
						else
							{
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
							}
					});
		}
		
	});
	
})();