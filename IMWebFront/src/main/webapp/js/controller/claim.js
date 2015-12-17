(function(){
	'use strict';
	
	var claims = angular.module("claim", []);
	
	claims.controller("claimCtrl",function($scope,$http,$location){
		var loadUser=JSON.parse(localStorage.getItem("user"));
		var newProductDetails=null;
	
		var result=$http.get(baseUrl+"/policy/"+loadUser.userName+"/approved").success(function(response)
		{
			$scope.userName=loadUser.userName;
			$scope.listPolicies=response;
			if($scope.listPolicies=='')
			{
			$scope.policyError=true;
			$scope.policyErrorText="No policy is approved";
			
			}
		else
			{
			$scope.policyError=false;
			}
			
		});		
		$scope.updateDetails=function()
		{
			var result2=$http.get(baseUrl+"/product/"+$scope.policyName).success(function(response){
				newProductDetails=response;
			});
		}
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
							$location.path("/dashboard/disburse");
							$scope.showSuccess=true;
							$scope.hideForm=true;
							
						});
							}
					});
		}
		$scope.check=function()
		{
			var basicCoverage=newProductDetails.basicCoverage;
			
			if($scope.claimAmount>basicCoverage)
				{
				//alert("You cannot enter more than Rs" +basicCoverage);
				$scope.claimAmountErrortext="You cannot enter more than Rs" +basicCoverage + " . Which is your basic coverage under term of your policy.";
				$scope.claimAmountError=true;
				$scope.claimAmount="";
				}
			else
				{
				$scope.claimAmountError=false;
				}
			
		}
	});
	claims.controller("AllClaimsCtrl",function($scope,$http,$window)
			{
				var result = $http.get(baseUrl+"/claim/pending").success(function(response)
				{			
					$scope.claimList = response;
				});
				$scope.setClaimStatus=function(id,claimStatus)
				{
					$http.put(baseUrl+"/claim?id="+id+"&claimStatus="+claimStatus);
					$window.location.reload();
				}
			});
	
})();