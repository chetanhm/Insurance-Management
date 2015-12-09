(function(){
	'use strict';
	
	var baseUrl = "http://localhost:8080"; 
	
var register = angular.module("register", []);

register.controller("RegistrationCtrl",function($scope,$http,$resource,$location){
	
	$scope.submit=function(){
	var dataObj = {
			firstName : $scope.firstName,
			lastName: $scope.lastName,
			address : $scope.address,
			state : $scope.state,
			city : $scope.city,
			contact_no : $scope.contact_no,
			email :$scope.email,
			userName : $scope.username,
			password : $scope.password
	};
	$scope.errorshow=false;
	
	var result=$http.get(baseUrl+"/usernameAvailable?username=" + $scope.username + "&email=" + $scope.email).success(function(response){

	if(response.status!="ok")
		{
			$scope.errorshow=true;
			if($scope.status=="username-fail")
				{
				$scope.errormsg="Username already present";
				}
			else
				{
				$scope.errormsg="Email already present";
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
			