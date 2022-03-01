app.controller('loginCtrl', function ($scope, $rootScope, $cookies) {
    $rootScope.historys = [];
    $rootScope.history = {};
    $scope.login = function () {
        var index = true;
        $rootScope.students.forEach(st => {
            if (st.username == $scope.username) {
                if (st.password == $scope.password) {
                    localStorage.setItem("users", JSON.stringify(st));
                    Swal.fire({
                        icon: 'success',
                        title: 'Đăng nhập thành công!',
                        text: 'Quay lại trang chủ!',
                        showConfirmButton: false,
                        closeOnClickOutside: false,
                        allowOutsideClick: false,
                        timer: 1600
                    });
                    $rootScope.indexStudent = st.index;
                    $rootScope.student = st;
                    window.location.href = '#!ListTest'
                    index = false;
                    return;
                }
            }
        })
        if (index == true) {
            Swal.fire({
                icon: 'error',
                title: 'Đăng nhập thất bại',
                text: 'Nhập lại'
            })
        }
    }


})