storeApp.controller('EmployeeController', ['$rootScope', '$scope', '$http', '$location', function($rootScope, $scope, $http, $location) {
    $scope.getemployeebymanagerid = function(userid) {
        var url = 'employee/myteam/?userid=' + userid;
        $http.get(url).success(function(response) {
            var employee = response;
            if (employee != null) {
                $scope.employees = employee;
            } else {
                $scope.error = "Cannot get employees";
            }

        }).error(function() {
            $location.path('/');
        })
    }
    $scope.viewallemployees = function() {
        var url = 'employee/';
        $http.get(url).success(function(response) {
            var employee = response;
            if (employee != null) {
                $scope.employees = employee;
            } else {
                $scope.error = "Cannot get employees";
            }

        }).error(function() {
            $location.path('/');
        })
    }
}]);
