storeApp.controller('UserController', [ '$rootScope', '$scope','$http','$location', function($rootScope, $scope,$http,$location) {
	$scope.changepassword=function(){
		console.log($scope.password);
		console.log($scope.cfrmpassword);
	}
}]);
