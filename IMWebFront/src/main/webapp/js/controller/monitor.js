(function(){
	'use strict';
var monitor = angular.module("monitor", []);
monitor.controller("MonitorCtrl",function($scope,$http)
		{

			var loadUser=JSON.parse(localStorage.getItem("user"));
				var result=$http.get(baseUrl+"/agent/"+loadUser.userName+"/user").success(function(response){
					if(response.length!=0)
						{
						$scope.customerList=response;
						$scope.tableShow=true;
						}
					else
						{
						$scope.dataError=true;
						}
				});	
});
})();