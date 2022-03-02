app.controller('myFeedBack', function ($scope, $http, $rootScope) {
    $scope.feedBack = function () {
        const apiFeedBack = "https://621b7d1efaa12ee4500effb8.mockapi.io/Feedback";

        $http.post(apiFeedBack, $scope.Feedback).then(function (response) {
            $scope.feedbacks.push(response.data)
        })
        // $rootScope.students.push(angular.copy($scope.studentRegister));

        Swal.fire({
            icon: 'success',
            title: 'Feedback thành công !',
            showConfirmButton: false,
            closeOnClickOutside: false,
            allowOutsideClick: false,
            timer: 1600
        });

        $scope.Feedback = {};
    }
})