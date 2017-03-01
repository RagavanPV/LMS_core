$scope.fetchFacilities = function() {
    $http.get("http://localhost:8080/core-app/holiday/").then(function(response) {
        console.log('Facilities:', response.data);
        $scope.facilities = response.data;
    });
};
