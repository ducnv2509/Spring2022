app.controller('updateForm', function ($scope, $rootScope) {
    $scope.update = function () {
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