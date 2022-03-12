app.controller('myHistory', function ($scope, $rootScope, $http) {
    $scope.historyUser = [];
    const apiExam = "https://620cffe3b573632593a1edf4.mockapi.io/History";
    $http.get(apiExam).then(function (response) {
        $rootScope.historys = response.data;
    })

    $rootScope.historys.forEach((item) => {
        if (item.idUser == $rootScope.student.id) {
            $scope.historyUser.push(angular.copy(item));
            // console.log($scope.historyUser);
        }
    });
})