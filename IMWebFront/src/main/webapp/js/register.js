(function(){
	'use strict';
var register = angular.module("register", []);

register.controller("RegistrationCtrl",function($scope,$http){
	$scope.submit=function(){
	var dataObj = {
			firstName : $scope.firstName,
			lastName: $scope.lastName,
			address : $scope.address,
			state : $scope.state,
			city : $scope.city,
			contact_no : $scope.contact_no,
			email :$scope.email,
			username : $scope.username,
			password : $scope.password
	};
	$http.post("http://localhost:8080/imregister",dataObj).success(function(data){
		$scope.user=data;
		console.log(data);
	});
	}
});




})();
			