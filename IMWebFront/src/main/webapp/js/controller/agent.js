(function(){
	'use strict';
	

	
var agent = angular.module("agent", []);

agent.controller("AgentCtrl",function($scope,$http,$resource,$location,$rootScope){
	
	$scope.submit=function(){


	var loaduser=JSON.parse(localStorage.getItem("user"));
	var dataObj = {
			age: $scope.age,
			lastQualification : $scope.lastQualification,
			presentOccupation : $scope.presentOccupation,
			rewards : $scope.rewards,
			workExperience : $scope.workExperience,
			userName : loaduser.userName
			
	};
	var result=$http.post(baseUrl+"/agent",dataObj).success(function(response){
	$scope.hideForm=true;
	$scope.showSuccess=true;
		

	});


	
	}
});

agent.controller("AgentClaimCtrl", function($scope, $http){
	var loadUser=JSON.parse(localStorage.getItem("user"));
	
	var result=$http.get(baseUrl+"/agent/"+loadUser.userName+"/user").success(function(response){
		$scope.userList=response;
		
	});
	
	$scope.policy=function(){
		var result2=$http.get(baseUrl+"/policy/"+$scope.managedCustomer).success(function(response){
			$scope.policyList=response;
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
						$scope.showSuccess=true;
						$scope.hideForm=true;
						
					});
						}
				});
	}
});


agent.controller("ApproveAgentCtrl",function($scope, $http,$window)
		{
			var result=$http.get(baseUrl+"/agent").success(function(response)
					{
						$scope.agentList=response;
					});			
			$scope.setAgentStatus= function(userName,userType)
			{		
				alert(userName+"--"+userType);
				$http.put(baseUrl+"/user?userName="+userName+"&userType="+userType);
			 $window.location.reload();	
			};
		});


			

})();
			