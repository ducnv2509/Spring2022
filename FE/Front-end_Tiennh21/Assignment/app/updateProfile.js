app.controller('updateForm', function ($scope, $rootScope, $http) {

    $scope.update = function () {
        const api = "https://620cffe3b573632593a1edf4.mockapi.io/Accounts";
        const id = $rootScope.student.id;
        const updateAPI = api + '/' + id;
        $http.put(updateAPI, $rootScope.student).then(response => {
            // $scope.student.id = response.data.Id;
            $scope.students.push(response.data);
        })
        $rootScope.students[$rootScope.indexStudent] = angular.copy($rootScope.student);

        Swal.fire({
            icon: 'success',
            title: 'Cập nhập thông tin cá nhân thành công !',
            text: 'Quay lại trang chủ!',
            showConfirmButton: false,
            closeOnClickOutside: false,
            allowOutsideClick: false,
            timer: 1600
        })
        window.location.href = '#!ListTest'
    }
})

// app.config(['$qProvider', function ($qProvider) {
//     $qProvider.errorOnUnhandledRejections(false);
// }]);