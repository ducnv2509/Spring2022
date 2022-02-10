app.controller('loginCtrl', function ($scope, $rootScope) {
    $scope.login = function () {
        var index =  true;
        $rootScope.students.forEach(st => {
            if(st.username == $scope.username){
                if(st.password == $scope.password){
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
                    $rootScope.student = st.student;
                    window.location.href = '#!ListTest'

                    index = false;
                    return;
                }
            }
        })
        if(index == true) {
            Swal.fire({ 
                icon: 'error',
                title: 'Đăng nhập thất bại',
                text: 'Nhập lại'
            })
        }
    }
})