storeApp.controller('VerifyController', [ '$rootScope', '$scope', '$http',
		'$location','$routeParams', function($rootScope, $scope, $http, $location,$routeParams) {
	$scope.verified=0;
	$scope.validatecode=function(){
		$scope.email=$routeParams.email;
		var url = 'user/verifycode?emailid=' + $scope.email+'&code='+$routeParams.code;
		console.log(url);	
		$http.get(url).success(function(response) {
			var result = response[0];
			if (result.VERIFIED == 1) {
				$scope.verified=1;
				console.log("true");
			} else {
				$scope.error = "Cannot get leave details";
				$location.path('/');
			}
		}).error(function() {
			$location.path('/');
		});}
	
}]);