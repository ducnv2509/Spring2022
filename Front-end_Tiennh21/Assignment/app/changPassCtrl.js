app.controller('changePassword', function($scope, $rootScope){
    $scope.changePassword = function(){
        if($rootScope.student.password == $scope.oldPassword){
            if($rootScope.student.password == $scope.studentR.password){
                Swal.fire({
                    icon: 'error',
                    title: 'Mật khẩu mới trùng với mật khẩu cũ !'
                })
            }else{
                $rootScope.student.password = $scope.studentR.password;
                $rootScope.students[$rootScope.indexStudent] = angular.copy($rootScope.student);
                Swal.fire({
                    title: 'Đổi mật khẩu thành công',
                    text: 'Bạn có muốn quay lại trang chủ không ? ',
                    icon: 'success',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Có!',
                    cancelButtonText: 'Không'
                }).then(res =>{
                    if(res.value){window.location.href = "#!ListTest"}
                })
            }
        }else{Swal.fire({icon: 'error', title:'Mật khẩu cũ không đúng'})}
        $scope.studentR.password = "";
        $scope.oldPassword = "";
        $scope.RenewPassword = "";

    }
})
