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

}]);
