storeApp.controller('HolidayController', [ '$rootScope', '$scope','$http','$location', function($rootScope, $scope,$http,$location) {
    	var url = 'holiday/' ;
    	$http.get(url).success(function(response){
    		var holiday = response;
    		if( holiday != null ){
    			$scope.holidays=holiday;
        	}
        	else
        		{
        		$scope.error="Cannot get holidays";
        		}
    		
    	}).error(function(){
    		$location.path('/');
    	})
    	
}]);
