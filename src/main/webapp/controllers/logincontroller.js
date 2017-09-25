storeApp.controller('LoginController', [
		'$rootScope',
		'$scope',
		'$http',
		'$location',
		function($rootScope, $scope, $http, $location) {
			var userStr = localStorage.getItem("LOGGED_IN_USER");
			if (userStr == null) {
				$location.path('/');
			} else {
				$rootScope.LOGGED_IN_USER = JSON.parse(userStr);
				$location.path('/userpage');
			} 

			$scope.login = function() {
				$scope.data={"emailId":$scope.email,"userPassword":hex_md5($scope.password)};
//				console.log($scope.data);
				$http.post('user/GetUser',$scope.data).success(
						function(response) {
							var user = response != null ? response[0] : null;
							if (user != null) {
								$rootScope.LOGGED_IN_USER = user;
								localStorage.setItem("LOGGED_IN_USER", JSON
										.stringify(user));
								$location.path('/userpage');
							} else {
								$scope.error = "Invalid Login";
							}

						}).error(function() {
					$location.path('/');
				})

			};
			$scope.logout = function() {
				$rootScope.LOGGED_IN_USER = null;
				localStorage.clear();
				$location.path("/");

			};
			$scope.forgot = function() {
				console.log($scope.email);
				var url = 'user/forgotpassword?emailid=' + $scope.email;
		$http.get(url).success(
				function(response) {
					var user = response;
					if (user == 1) {
						$scope.Msg="Mail has Been Sent";
						console.log($scope.Msg);
					} else {
						$scope.Msg = "Invalid Mail Id	";
					}

				}).error(function() {
			$location.path('/');
		})

			};
		} ]);
