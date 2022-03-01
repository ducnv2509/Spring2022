app.controller('createQuetions', function ($scope, $routeParams, $http, $rootScope) {
    $rootScope.quizzs.forEach(array => {
        if (array.Id == $routeParams.id) {
            $scope.subject = angular.copy(array);
            return;
        }
    })

    $scope.create = function () {
        const api = "https://620cffe3b573632593a1edf4.mockapi.io/Quetions";
        $http.post(api, $scope.creQuetion).then(function (response) {
            $scope.quetions.push(response.data)
            // $scope.student.id = response.data.id;
        })
    }

})