storeApp.controller('ApplyLeaveController', [ '$rootScope', '$scope','$http','$location', function($rootScope, $scope,$http,$location) {
    	var url = 'leavetype/' ;
    	$http.get(url).success(function(response){
    		var leavetype = response;
    		if( leavetype != null ){
    			$scope.holidays=leavetype;
        	}
        	else
        		{
        		$scope.error="Cannot get holidays";
        		}
    		
    	}).error(function(){
    		$location.path('/');
    	})
    	
}]);
