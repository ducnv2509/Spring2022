app.controller('myManagerQ', function ($scope, $rootScope, $http) {
    const apiQuizz = "https://620cffe3b573632593a1edf4.mockapi.io/Exam";


    $scope.create = function () {
        $http.post(apiQuizz, $scope.createQ).then(function (response) {
            $scope.quizzs.push(response.data);
        })
    }
})