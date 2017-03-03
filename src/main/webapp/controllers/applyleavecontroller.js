storeApp.controller('ApplyLeaveController', ['$rootScope','$scope','$http','$location','$window','$filter',function($rootScope, $scope, $http, $location, $window,$filter) { 
                var userStr = localStorage.getItem("LOGGED_IN_USER");
                if (userStr == null) {
                    $location.path('/');
                } else {
                    $scope.LOGGED_IN_USER = JSON.parse(userStr);
                }
                var url = 'leavetype/?gender='+$scope.LOGGED_IN_USER.gender;
                $http.get(url).success(function(response) {
                    var leavetype = response;
                    if (leavetype != null) {
                        $scope.leavetypes = leavetype;
                    } else {
                        $scope.error = "Cannot get Leave Types";
                    }

                }).error(function() {
                    $location.path('/');
                });
                $scope.submit = function() {
                    if ($scope.day == 1) {
                        $scope.from_date = $filter('date')(
                            new Date($scope.frm_date),
                            'yyyy-MM-dd');
                        $scope.to_date = $filter('date')(
                            new Date($scope.to_date),
                            'yyyy-MM-dd');
                        $scope.employeeId = $scope.LOGGED_IN_USER.employeeid;
                        $scope.data = {
                            "empDTO": {
                                "id": $scope.employeeId
                            },
                            "leaveDTO": {
                                "id": $scope.type
                            },
                            "fromDate": $scope.from_date,
                            "toDate": $scope.to_date,
                            "reason": $scope.reason
                        };
                        var result = $http.post('/leave/fullDay', $scope.data);
                        result.success(function(response) {
                            console.log(response.ERRMSG);
                            if (response.ERRMSG == "Success") {
                                $location.path("/");
                            } else {
                                $scope.errMsg = response.ERRMSG;
                            }
                        });
                        result.error(function(response) {
                            console.log(response.ERRMSG);
                        });
                    } else if ($scope.day == 2) {
                        $scope.date = $filter('date')(
                            new Date($scope.date),
                            'yyyy-MM-dd');

                        $scope.employeeId = $scope.LOGGED_IN_USER.employeeid;
                        $scope.data = {
                            "empDTO": {
                                "id": $scope.employeeId
                            },
                            "leavDTO": {
                                "id": $scope.type
                            },
                            "fromDate": $scope.date,
                            "session": $scope.session,
                            "reason": $scope.reason
                        };
                        console.log($scope.data);
                        var result = $http.post('/leave/halfDay', $scope.data);
                        result.success(function(response) {
                                console.log(response.ERRMSG);
                                if (response.ERRMSG == "Success") {
                                    $location.path("/");
                                } else {
                                    $scope.errMsg = response.ERRMSG;
                                }
                                
                            });
                        }
                    
                }}]);
