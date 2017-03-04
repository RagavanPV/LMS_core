storeApp.controller('DepartmentController', ['$rootScope', '$scope', '$http', '$location', function($rootScope, $scope, $http, $location) {
    var url = 'department/';
    $http.get(url).success(function(response) {
        var department = response;
        if (department != null) {
            $scope.departments = department;
        } else {
            $scope.error = "Cannot get departments";
        }

    }).error(function() {
        $location.path('/');
    })

}]);
