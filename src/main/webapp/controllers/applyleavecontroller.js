storeApp.controller('ApplyLeaveController', [
		'$rootScope',
		'$scope',
		'$http',
		'$location',
		'$window',
		'$filter',
		function($rootScope, $scope, $http, $location, $window, $filter) {
			var userStr = localStorage.getItem("LOGGED_IN_USER");
			
			if (userStr == null ){
				$location.path('/');
			}
			else
				{
					$scope.LOGGED_IN_USER= JSON.parse(userStr);  // Get logged in user details from localStorage and store in scope
				}
			var url = 'leavetype/';
			$http.get(url).success(function(response) {
				var leavetype = response;
				if (leavetype != null) {
					$scope.leavetypes = leavetype;
				} else {
					$scope.error = "Cannot get Leave Types";
				}

			}).error(function() {
				$location.path('/');
			})
			$scope.submit = function() {
				if ($scope.day == 1) {
					var from_date = $filter('date')(new Date($scope.frm_date),
							'yyyy-MM-dd');
					var to_date = $filter('date')(new Date($scope.to_date),
					'yyyy-MM-dd');
					var employeeId=$scope.LOGGED_IN_USER.employeeid;
					var url = 'leave/fullday?empId=' +employeeId+ '&leaveId='
							+ $scope.type + '&fromDate=' + from_date
							+ '&toDate=' + to_date + '&reason='
							+ $scope.reason;
					console.log(url);
					/*
					 * $http.get(url).success(function(response){ var leavetype =
					 * response; if( leavetype != null ){
					 * $scope.leavetypes=leavetype; } else {
					 * $scope.error="Cannot get Leave Types"; }
					 * 
					 * }).error(function(){ $location.path('/'); })
					 */
				} else if ($scope.day == 2) {
					var url = 'leave/halfday';
					/*
					 * $http.get(url).success(function(response){ var leavetype =
					 * response; if( leavetype != null ){
					 * $scope.leavetypes=leavetype; } else {
					 * $scope.error="Cannot get Leave Types"; }
					 * 
					 * }).error(function(){ $location.path('/'); })
					 */
				}
			}
		} ]);
