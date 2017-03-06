storeApp.controller('UserController', [ '$rootScope', '$scope', '$http',
		'$location', function($rootScope, $scope, $http, $location) {
			var userStr = localStorage.getItem("LOGGED_IN_USER");

			if (userStr == null) {
				$location.path('/');
			} else {
				$rootScope.LOGGED_IN_USER = JSON.parse(userStr);
			}
			$scope.changepassword = function() {
				console.log($scope.password);
				console.log($scope.cfrmpassword);
			}
			$scope.cancelleave = function(leaveid) {
				console.log($scope.LOGGED_IN_USER.userid+" "+leaveid);
				var url = 'leavedetail/cancelleave?leaveid='+leaveid;
				console.log(url);
				$http.get(url).success(function(response) {
					var result = response;
		    		if( result == 1){
		    			 $location.path('#/userpage');
		        	}else {
						$scope.error = "Cannot cancel leave details";
					}
				}).error(function() {
					$location.path('/');
				})
				
			}
			$scope.home = function() {
				var employeeId = $scope.LOGGED_IN_USER.employeeid;
				var url = 'leavedetail/byempid?empid=' + employeeId;
				$http.get(url).success(function(response) {
					var leavedetail = response;
					if (leavedetail != null) {
						$scope.leavedetails = leavedetail;
					} else {
						$scope.error = "Cannot get leave details";
					}
				}).error(function() {
					$location.path('/');
				})
			}
		} ]);
