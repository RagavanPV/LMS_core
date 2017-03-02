var storeApp = angular.module('lmsApp', ['ngRoute']);


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
    when('/updatepassword', {
        templateUrl: 'partials/updatepassword.html',
        controller: "RegistrationController"
    }).
    when('/userpage', {
        templateUrl: 'partials/userpage.html',
    }).
    otherwise({
        redirectTo: '/'
    });
}]);
