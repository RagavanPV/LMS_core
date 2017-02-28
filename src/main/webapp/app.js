var storeApp = angular.module('lms', []).
config(['$routeProvider', function($routeProvider) {
    $routeProvider.
    when('/users/login', {
        templateUrl: 'partials/store.htm',
        controller: '/users/login'
    }).
    when('/products/:productSku', {
        templateUrl: 'partials/product.htm',
        controller: storeController
    }).
    when('/cart', {
        templateUrl: 'partials/shoppingCart.htm',
        controller: storeController
    }).
    otherwise({
        redirectTo: '/store'
    });
}]);
