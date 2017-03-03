storeApp.controller('LeaveController', [ '$rootScope', '$scope','$http','$location', function($rootScope, $scope,$http,$location) {
    	console.log("testing Leave details");
	$scope.getempleavebymanagerid=function(userid){ var url = 'leavedetail/myteam/?userid='+userid ;
    	$http.get(url).success(function(response){
    		var leavedetail = response;
    		console.log(leavedetail);
    		if( leavedetail != null ){
    			$scope.leavedetails=leavedetail;
        	}
        	else
        		{
        		$scope.error="Cannot get employees leavedetails";
        		}
    		
    	}).error(function(){
    		$location.path('/');
    	})
	}
}]);
