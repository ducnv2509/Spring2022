app.controller('informationExam', function ($scope, $rootScope, $routeParams) {
    $rootScope.subjects.forEach(array => {
        if (array.Id == $routeParams.id) {
            $scope.subject = angular.copy(array);
            return;
        }
    })

    $scope.test = function () {
        if ($rootScope.student == null) {
            Swal.fire({
                icon: 'error',
                title: 'Bạn chưa đăng nhập!',
                text: 'Hãy quay lại sau khi đăng nhập!'
            })
        }else{
            Swal.fire({
                title: 'Bắt Đầu Thi !!!',
                text: 'Bạn Đã Sẵn Sàng Chưa ?',
                icon: 'warning',
                showCancelButton: true, 
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Có! Bắt đầu thi.',
                cancelButtonText: 'Chưa'
            }).then(response =>{
                if(response.value){window.location.href = "#!listQuestion/" + $scope.subject.Id}
            })
        }
    }
})