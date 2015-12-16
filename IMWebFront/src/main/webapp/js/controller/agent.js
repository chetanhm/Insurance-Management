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
			
				$http.put(baseUrl+"/user?userName="+userName+"&userType="+userType);
			 $window.location.reload();	
			};
		});



/**
 * Controllers for Buying policy
 */
agent.controller("ApplyForCustomerFormCtrl",function($stateParams,$scope,$http,$location)
		{	
			
	var userId=JSON.parse(localStorage.getItem("user")).id;
			$scope.policy = {};
			$scope.policy.productName = $stateParams.productName;
			$scope.userName=$stateParams.userName;
			$scope.apply = function() {
				$scope.apply = function() {
					var fd = new FormData();
					fd.append('file', document.getElementById('incomeProof').files[0]);
					$scope.hideButton = true;
					$scope.loaderShow = true;
					$scope.statusMessage = "Uploading income proof...";
					$http.post(baseUrl + "/file", fd, {
						transformRequest : angular.identity,
						headers : {
							'Content-Type' : undefined
						}
					}).success(
							function(response) {
								$scope.policy.incomeProofFile = response.fileName;
								$scope.statusMessage = "Uploading residence proof...";
								var fd2 = new FormData();
								fd2.append('file', document
										.getElementById('residenceProof').files[0]);
								$http.post(baseUrl + "/file", fd2, {
									transformRequest : angular.identity,
									headers : {
										'Content-Type' : undefined
									}
								}).success(function(response) {
									$scope.policy.residenceProofFile = response.fileName;
									$scope.statusMessage = "Uploading age proof...";
									var fd3 = new FormData();
									fd3.append('file', document
											.getElementById('ageProof').files[0]);
									$http.post(baseUrl + "/file", fd3, {
										transformRequest : angular.identity,
										headers : {
											'Content-Type' : undefined
										}
									}).success(function(response) {
										$scope.policy.ageProofFile = response.fileName;
										$scope.statusMessage = "Uploading photograph...";
										var fd4 = new FormData();
										fd4.append('file', document
												.getElementById('photograph').files[0]);
										$http.post(baseUrl + "/file", fd4, {
											transformRequest : angular.identity,
											headers : {
												'Content-Type' : undefined
											}
										}).success(function(response) {
											
											$scope.policy.photoFile=response.fileName;
											$scope.statusMessage = "Submitting form";
										
											$scope.policy.userName=$scope.userName;
											var config = {headers:  {
									             "_id" : userId
											}
											};
											$http.post(baseUrl+"/policy",$scope.policy,config).success(function(data){
											$scope.policyNumber=data.policyNumber;
											$scope.showSuccess=true;
											$scope.hideForm=true;
											});
											
										}).error(function(response){})
										
									 }).error(function(){});
									

								}).error(function() {
								});

							}).error(function() {
					});

				}
			}
			
		}		
		);

		agent.controller("ApplyForCustomerCtrl",function($stateParams, $scope,$http,$uibModal){	
			$scope.customerUserName=$stateParams.userName;
			
			var result=$http.get(baseUrl+"/product").success(function(response){
				$scope.productList=response;
					
			});

			 $scope.open = function (productName) {

				    var modalInstance = $uibModal.open({
				      animation: $scope.animationsEnabled,
				      templateUrl: 'myModalContent.html',
				      controller: 'ModalInstanceCtrl',
				      size: 'lg',
				      resolve: {
				        product: function () {
				          return $scope.productList[0];
				        }
				      }
				    });
				 }
		});

		agent.controller("ListManagedCustomersCtrl",function($scope,$http)
		{

			var loadUser=JSON.parse(localStorage.getItem("user"));
				var result=$http.get(baseUrl+"/agent/"+loadUser.userName).success(function(response){
					if(response.length!=0)
						{
						$scope.userList=response;
						$scope.tableShow=true;
						}
					else
						{
						$scope.dataError=true;
						}
				});
		}		
		)
		agent.controller('ModalInstanceCtrl', function ($scope, $uibModalInstance, product) {

			  $scope.product = product;
			  $scope.cancel = function () {
			    $uibModalInstance.dismiss('cancel');
			  };
			});

		agent.directive("radioButton", function() {
			  return {
			    restrict: 'A',
			    require: 'ngModel',
			    link: function(scope, element, attrs, ctrl) {
			      element.bind('click', function () {
			        if (!element.hasClass('active')) {
			          scope.$apply(function () {
			            scope.transaction.debit = attrs.value;
			          });
			        }
			      });
			    }
			  };
			});

			

})();
			