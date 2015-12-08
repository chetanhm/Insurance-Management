<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="css/modern-business.css" rel="stylesheet">
		<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" media="screen" href="//netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title class="navbar-brand">Registration Form</title>
</head>
<body>
<div class="col-lg-12">
<h1 class="page-header">
Registration Form
</h1>

</div>
<form class="navbar-brand" ng-app="myApp" ng-controller="validateCtrl" 
name="myForm">

<p>First Name:<br>
<input type="text" name="firstName" placeholder="First Name" ng-model="firstName" required>
<span style="color:red" ng-show="myForm.user.$dirty && myForm.user.$invalid">
<span ng-show="myForm.user.$error.required">Name is required.</span>
</span>
</p>

<p>LastName:<br>
<input type="text" name="lastName" placeholder="Last Name" ng-model="lastName" required>
<span style="color:red" ng-show="myForm.user.$dirty && myForm.user.$invalid">
<span ng-show="myForm.user.$error.required">Last Name is required.</span>
</span>
</p>

<p>Address:<br>
<input type="text" name="address" placeholder="Address" ng-model="address" required>
<span style="color:red" ng-show="myForm.user.$dirty && myForm.user.$invalid">
<span ng-show="myForm.user.$error.required">Address is required.</span>
</span>
</p>
<p>State:<br>
<input type="text" name="state" placeholder="State" ng-model="state" required>
<span style="color:red" ng-show="myForm.user.$dirty && myForm.user.$invalid">
<span ng-show="myForm.user.$error.required">State is required.</span>
</span>
</p>

<p>City:<br>
<input type="text" name="city" placeholder="City" ng-model="city" required>
<span style="color:red" ng-show="myForm.user.$dirty && myForm.user.$invalid">
<span ng-show="myForm.user.$error.required">City is required.</span>
</span>
</p>

<p>Contact Number:<br>
<input type="text" name="contact_no" placeholder="Contact Number" ng-model="contact_no" required>
<span style="color:red" ng-show="myForm.user.$dirty && myForm.user.$invalid">
<span ng-show="myForm.user.$error.required">Contact number is required.</span>
</span>
</p>

<p>Email:<br>
<input type="email" name="email" placeholder="Email Id" ng-model="email" required>
<span style="color:red" ng-show="myForm.email.$dirty && myForm.email.$invalid">
<span ng-show="myForm.email.$error.required">Email is required.</span>
<span ng-show="myForm.email.$error.email">Invalid email address.</span>
</span>
</p>


<p>Username:<br>
<input type="text" name="username" placeholder="User Name" ng-model="username" required>
<span style="color:red" ng-show="myForm.user.$dirty && myForm.user.$invalid">
<span ng-show="myForm.user.$error.required">Username is required.</span>
</span>
</p>

<p>Password:<br>
<input type="password" name="password" placeholder="Password" ng-model="password" required>
<span style="color:red" ng-show="myForm.user.$dirty && myForm.user.$invalid">
<span ng-show="myForm.user.$error.required">Password is required.</span>
</span>
</p>

<p>
<input type="submit"
ng-disabled="myForm.user.$dirty && myForm.user.$invalid ||  
myForm.email.$dirty && myForm.email.$invalid">
</p>

</form>
<script>
var app = angular.module('myApp', []);
app.controller('validateCtrl', function($scope) {
    $scope.firstName ;
    $scope.lastName;
    $scope.address ;
    $scope.state ;
    $scope.city ;
    $scope.contact_no ;
    $scope.email;
    $scope.dob ;
    $scope.username;
    $scope.password ;
});
</script>


</body>
</html>