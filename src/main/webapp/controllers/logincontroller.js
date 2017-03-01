storeApp.controller('LoginController', [ '$rootScope', '$scope','$http','$location', function($rootScope, $scope,$http,$location) {
	
	var userStr = localStorage.getItem("LOGGED_IN_USER");
	
	if (userStr == null ){
		$location.path('/');
	}
	else
		{
			$scope.LOGGED_IN_USER= JSON.parse(userStr);  // Get logged in user details from localStorage and store in scope
		}
	
    $scope.login = function() {
    	var url = 'user/GetUser?emailId='+$scope.email+'&password='+$scope.password ;
    	$http.get(url).success(function(response){
    		var user = response != null ? response[0]: null;
    		if( user != null ){
    			$rootScope.LOGGED_IN_USER= user;
    			localStorage.setItem("LOGGED_IN_USER", JSON.stringify(user)); 
        		$location.path('/userpage');
        	}
        	else
        		{
        		$scope.error="Invalid Login";
        		}
    		
    	}).error(function(){
    		$location.path('/');
    	})
    	
    };
    $scope.logout = function() {
    	$rootScope.LOGGED_IN_USER=null;
    	localStorage.clear();
    	$location.path("/");
    	
    };
}]);
