var storeApp = angular.module('lmsApp', ['ngRoute']).
config(['$routeProvider', function($routeProvider) {
    $routeProvider.
    when('/', {
        templateUrl: 'partials/login.html',
        controller:""
    }).
    when('/holidays', {
        templateUrl: 'partials/holidays.html',
    }).
    when('/myteam', {
        templateUrl: 'partials/myteam.html',
    }).when('/userpage', {
        templateUrl: 'partials/userpage.html',
    }).
    otherwise({
        redirectTo: '/'
    });
}]);
