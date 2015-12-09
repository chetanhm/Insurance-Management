(function(){
	'use strict';
	

	
var register = angular.module("register", []);

register.controller("RegistrationCtrl",function($scope,$http,$resource,$location){
	
	$scope.submit=function(){
	var dataObj = {
			firstName : $scope.firstName,
			lastName: $scope.lastName,
			address : $scope.address,
			state : $scope.state,
			city : $scope.city,
			contactNo : $scope.contact_no,
			email :$scope.email,
			userName : $scope.username,
			password : $scope.password
	};
	$scope.errorShow=false;
	
	var result=$http.get(baseUrl+"/usernameAvailable?username=" + $scope.username + "&email=" + $scope.email).success(function(response){

	if(response.status!="ok")
		{
			$scope.errorShow=true;
			if(response.status=="username-fail")
				{
				$scope.errorMsg="Username already present";
				}
			else
				{
				$scope.errorMsg="Email already present";
				}
		}
	else
		{
			$http.post(baseUrl+"/imregister",dataObj).success(function(data){
				$location.path("website.home");
			});
		}

	});


	
	}
});




})();
			