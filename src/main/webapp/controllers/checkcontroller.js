storeApp.controller('CheckController', [ '$rootScope', '$scope', '$http',
		'$location','$routeParams', function($rootScope, $scope, $http, $location,$routeParams) {
	$scope.user = {
			password : "",
			confirmPassword : ""
		};
	$scope.submit = function(isValid, email) {
		
		if (isValid) {
			$scope.url = "user/updatepassword";
			$scope.data = {
				"emailId" : email,
				"userPassword" : $scope.user.confirmPassword
			}
			var result = $http.post($scope.url, $scope.data);
			console.log(result);
			result.success(function(response) {
				console.log(response);
				if (response== 1) {
					$location.path("/");
				} else {
					$scope.errMsg = "Cannot change";
					console.log($scope.errMsg);
				}
			});
			result.error(function(response) {
				console.log(response.ERRMSG);
			});
		} else {
			$scope.message = "There are still invalid fields below";
			console.log($scope.message);
		}
	};

}]);
storeApp.directive('compareTo', [function() {
	return {
		require : "ngModel",
		scope : {
			otherModelValue : "=compareTo"
		},
		link : function(scope, element, attributes, ngModel) {

			ngModel.$validators.compareTo = function(modelValue) {
				return modelValue == scope.otherModelValue;
			};

			scope.$watch("otherModelValue", function() {
				ngModel.$validate();
			});
		}
	};
}]);