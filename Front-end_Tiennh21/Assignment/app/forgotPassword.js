app.controller('myCtrlForgotPassword', function ($scope, $rootScope) {
    $scope.getPassword = function () {
        var check = true;
        $rootScope.students.forEach(st => {
            if (st.email == $scope.email && st.username == $scope.username) {
                Swal.fire({
                    icon: 'success',
                    title: 'Lấy lại tài khoản thành công !!!',
                    text: 'Mật khẩu: ' + st.password,
                });
                check = false;
                return;
            }
        })
        if (check) {
            Swal.fire({
                icon: 'error',
                title: 'Lấy lại tài khoản thất bại !',
                text: 'Vui lòng xem lại thông tin'
            })
        }
    }
})