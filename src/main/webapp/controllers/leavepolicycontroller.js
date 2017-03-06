storeApp.controller('LeavePolicyController', ['$rootScope', '$scope', '$http', '$location', function($rootScope, $scope, $http, $location) {
    var url = 'leavepolicy/';
    $http.get(url).success(function(response) {
        var leavepolicy = response;
        if (leavepolicy != null) {
            $scope.leavepolicies = leavepolicy;
        } else {
            $scope.error = "Cannot get departments";
        }

    }).error(function() {
        $location.path('/');
    })
$scope.updatenoofdays=function(id){
    	 var url = 'leavepolicy/updatenoofdays?id='+id+'&no_of_days='+$scope.noofdays;
    	 $http.get(url).success(function(response) {
    	        var result = response;
    	        if (result == 1) {
    	            $location.path("#/");
    	        } else {
    	            $scope.error = "Cannot get departments";
    	        }

    	    }).error(function() {
    	        $location.path('/');
    	    })
    }
    $scope.leaveid=function(id){
    	$scope.LeavePolicyId=id;
    }
}]);
