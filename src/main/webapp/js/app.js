var storeApp = angular.module('lmsApp', ['ngRoute','ui.bootstrap']);


storeApp.
config(['$routeProvider', function($routeProvider) {
    $routeProvider.
    when('/', {
        templateUrl: 'partials/login.html',
        controller: "LoginController"
    }).
    when('/holidays', {
        templateUrl: 'partials/holidays.html',
        controller: "HolidayController"
    }).
    when('/applyleave', {
        templateUrl: 'partials/applyleave.html',
        controller: "ApplyLeaveController"
    }).
/*    when('/updatepassword/:email', {
        templateUrl: 'partials/updatepassword.html',
        controller:'UpdateController'
    }).
*/    when('/userpage', {
        templateUrl: 'partials/userpage.html',
        controller: "UserController"
    }).
    when('/myteam', {
        templateUrl: 'partials/myteam.html',
        controller: "LeaveController"
    }).
    when('/viewemployees', {
        templateUrl: 'partials/viewemployees.html',
        controller: "EmployeeController"
    }).
    when('/addemployee', {
        templateUrl: 'partials/addemployee.html',
    }).
    when('/adddepartment', {
        templateUrl: 'partials/adddepartment.html',
        controller: "DepartmentController"
    }).
    when('/addleavepolicy', {
        templateUrl: 'partials/addleavepolicy.html',
        controller: "LeavePolicyController"
    }).
    when('/verifycode/:email/:code', {
    	templateUrl: 'partials/updatepassword.html',
        controller: "VerifyController"
    }).
    when('/updateemployee/:empid', {
        templateUrl: 'partials/updateemployee.html',
        controller: "EmployeeController"
    }).
    otherwise({
        redirectTo: '/'
    });
}]);
