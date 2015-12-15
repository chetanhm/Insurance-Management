(function(){
	'use strict';
	
	var claimDetail = angular.module("claimDetail", []);
	
	claimDetail.controller("claimDetailCtrl",function($scope,$http){
		var loadUser=JSON.parse(localStorage.getItem("user"));
	
/*		$scope.submit= function()
		{
			$http.get(baseUrl+"/file?fileName="+document.getElementById('filebutton').files[0]).success(function(response)
		
		{
			var date=new Date();
			var dataObj = {
					userName : loaduser.userName,
					claimAmount : $scope.claimAmount,
					claimDocuments: response,
					claimType : $scope.claimType,
					policyName : $scope.policyName,
					claimStatus : "pending",
					aprrovedClaimAmount : "null" ,
					dateOfClaim : date.getDate(),
					policyNumber : $scope.policyNumber
					
			};
			
				var result1=$http.post(baseUrl+"/claim", dataObj).success(function(response){
					$location.path("dashboard.claimDetail");
				});
		});				
		
		}*/
		
		alert("here");
	});
	
})();