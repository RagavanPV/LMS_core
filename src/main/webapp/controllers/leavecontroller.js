storeApp.controller('LeaveController', [ '$rootScope', '$scope','$http','$location','$uibModal', function($rootScope, $scope,$http,$location,$uibModal) {
    	var userStr = localStorage.getItem("LOGGED_IN_USER");
        if (userStr == null) {
            $location.path('/');
        } else {
            $scope.LOGGED_IN_USER = JSON.parse(userStr);
        }
	$scope.getempleavebymanagerid=function(userid){ var url = 'leavedetail/myteam/?userid='+userid ;
    	$http.get(url).success(function(response){
    		var leavedetail = response;
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
	$scope.acceptleave=function(leaveid){
		 var url = 'leavedetail/acceptleave?leaveid='+leaveid+'&userid='+$scope.LOGGED_IN_USER.userid;
		 $http.get(url).success(function(response){
	    		var result = response;
	    		if( result == 1){
	    			 $location.path('#/myteam');
	        	}
	        	else
	        		{
	        		$scope.error="Cannot Cancel Leave";
	        		}
	    		
	    	}).error(function(){
	    		$location.path('/');
	    	})
	}
	$scope.rejectleave=function(leaveid){
		 var url = 'leavedetail/rejectleave?leaveid='+leaveid+'&userid='+$scope.LOGGED_IN_USER.userid+'&reason='+$scope.reason;
		 $http.get(url).success(function(response){
	    		var result = response;
	    		if( result == 1){
	    			 $location.path('#/');
	        	}
	        	else
	        		{
	        		$scope.error="Cannot Cancel Leave";
	        		}
	    		
	    	}).error(function(){
	    		$location.path('/');
	    	})
	}
	$scope.open = function(leaveid) {
		$scope.rejectLeaveId=leaveid;
    };
}]);


