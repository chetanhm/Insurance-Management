(function(){
	'use strict';
	

	
var register = angular.module("register", []);

register.controller("RegistrationCtrl",function($scope,$http,$resource,$location,$rootScope){
	
	$scope.submit=function(){
	var dataObj = {
			firstName : $scope.firstName,
			lastName: $scope.lastName,
			address : $scope.address,
			state : $scope.state,
			city : $scope.city,
			contactNo : $scope.contactNo,
			email :$scope.email,
			userName : $scope.userName,
			password : $scope.password
	};
	$scope.errorShow=false;
	
	var result=$http.get(baseUrl+"/userNameAvailable?userName=" + $scope.userName + "&email=" + $scope.email).success(function(response){

	if(response.status!="ok")
		{
			$scope.errorShow=true;
			if(response.status=="userName-fail")
				{
				$scope.errorMsg="UserName already present";
				}
			else
				{
				$scope.errorMsg="Email already present";
				}
		}
	else
		{
			$http.post(baseUrl+"/imregister",dataObj).success(function(data){
				localStorage.setItem("user", JSON.stringify(data));
				$rootScope.$broadcast("recheck");
				var lastLocation=localStorage.getItem("lastLocation");
				if(lastLocation==null)
				{
				$location.path("website.home");	
				}
			else
				{
					$location.path(lastLocation);
					localStorage.setItem("lastLocation", null);
				}
			});
		}

	});


	
	}
});




})();
			