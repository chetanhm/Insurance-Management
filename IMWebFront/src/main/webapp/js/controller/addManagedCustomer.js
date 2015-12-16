(function(){
	'use strict';
	

	
var customer = angular.module("addManagedCustomer", []);

customer.controller("CustomerCtrl",function($scope,$http,$resource,$location,$rootScope,toaster){
	
	$scope.submit=function(){
	var dataObj = {
			firstName : $scope.firstName,
			lastName: $scope.lastName,
			address : $scope.address,
			state : $scope.city.state,
			city : $scope.city.city,
			contactNo : $scope.contactNo,
			email :$scope.email,
			userName : $scope.userName,
			password : $scope.password,
			agentUserName:$scope.agentUserName
	};
	$scope.errorShow=false;
	
	var result=$http.get(baseUrl+"/user/check?userName=" + $scope.userName + "&email=" + $scope.email).success(function(response){

	if(response.status!="ok")
		{
			$scope.errorShow=true;
			if(response.status=="userName-fail")
				{
				$scope.errorMsgUserName="UserName already present";
				}
			else
				{
				$scope.errorMsgEmail="Email already present";
				}
		}
	else
		{
		var loadUser=JSON.parse(localStorage.getItem("user"));
		
			$http.post(baseUrl+"/agent/"+loadUser.userName+"/user",dataObj).success(function(data){
			$rootScope.$broadcast("recheck");
			$scope.hideForm=true;
			$scope.showSuccess=true;
				
			});
		}

	});


	
	}
	
	
	$scope.checkUsername=function()
	{
		var result=$http.get(baseUrl+"/user/check?userName=" + $scope.userName + "&email=" + $scope.email).success(function(response){
			if(response.status!="ok")
			{
				$scope.errorShow=true;
				if(response.status=="userName-fail")
					{
					$scope.userNameOk=false;
					$scope.errorMsg="UserName already present";
					}
				else
					{
					$scope.emailOk=false;
					$scope.errorMsg="Email already present";
					}
			}
		else
		{
			$scope.emailOk=true;
			$scope.userNameOk=true;
			$scope.errorShow=false;
		}
		
		}).error(function(response){});
	}
});




})();
			