storeApp.controller('EmployeeController', ['$rootScope','$routeParams' ,'$scope', '$http', '$location', function($rootScope,$routeParams, $scope, $http, $location) {
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
    $scope.updateemp = function(id) {
    	$location.path("/updateemployee/"+id);
    }
    $scope.getdetails=function(){
    	$scope.id=1;
    	var url = 'employee/byempid?userid='+$routeParams.empid;
    	$http.get(url).success(function(response) {
            var employee = response[0];
            if (employee != null) {
                $scope.employeesById = employee;
                
            } else {
                $scope.error = "Cannot get employees";
            }

        }).error(function() {
            $location.path('/');
        })
    }
    $scope.updatedeptforemp=function(empId,dept){
    	console.log(empId+" "+dept);
    	var url = 'employee/updatedeptbyemp?empid='+empId+"&deptid="+dept;
    	$http.get(url).success(function(response) {
            var employee = response;
            if (employee == 1) {
               $location.path("#/viewemployees");
               $scope.msg="Succesfully Updated Department";
                
            } else {
                $scope.error = "Cannot update department";
            }

        }).error(function() {
            $location.path('/');
        })
    }
}]);
