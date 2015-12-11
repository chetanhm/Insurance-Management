(function() {
	'use strict';

	var view = angular.module("buyProduct", []);

	view.controller("BuyProductCtrl", function($scope, $stateParams, $http,
			$location) {

		$scope.loaderShow = false;
		$scope.policy = {};
		$scope.policy.productName = $stateParams.productName;
		$scope.apply = function() {
			var fd = new FormData();
			fd.append('file', document.getElementById('incomeProof').files[0]);
			$scope.hideButton = true;
			$scope.loaderShow = true;
			$scope.statusMessage = "Uploading income proof...";
			$http.post(baseUrl + "/addFile", fd, {
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
						$http.post(baseUrl + "/addFile", fd2, {
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
							$http.post(baseUrl + "/addFile", fd3, {
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
								$http.post(baseUrl + "/addFile", fd4, {
									transformRequest : angular.identity,
									headers : {
										'Content-Type' : undefined
									}
								}).success(function(response) {
									
									$scope.policy.photoFile=response.fileName;
									$scope.statusMessage = "Submitting form";
									
									alert(JSON.stringify($scope.policy));
									
									
									
								}).error(function(response){})
								
							}).error(function(){});
							

						}).error(function() {
						});

					}).error(function() {
			});

		}
		if (localStorage.getItem("user") == null) {
			$location.path("/website/login");
		}

	});
})();
