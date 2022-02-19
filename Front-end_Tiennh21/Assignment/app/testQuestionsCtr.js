app.controller('testQuestion', function ($scope, $interval, $http, $routeParams, $rootScope) {

    $rootScope.subjects.forEach(array => {
        if (array.Id == $routeParams.id) {
            $scope.subject = angular.copy(array);
            return;
        }
    })

    $http.get('db/Quizs/' + $routeParams.id + '.js').then(response => {
        $scope.questions = response.data;
    });

    $scope.testMark = 0;
    $scope.indexQuestion = 0;
    $scope.timer = 900;
    $scope.element = [];

    $scope.move = function (x) {
        $scope.indexQuestion = x;
    }

    $scope.mark = function () {
        if ($scope.questions[$scope.indexQuestion].AnswerId == $scope.element[$scope.indexQuestion].answer) {
            Swal.fire({
                icon: 'success',
                title: 'Chúc mừng bạn đã chọn đúng !',
                text: 'Bạn được cộng ' + $scope.questions[$scope.indexQuestion].Marks + ' điểm',
                showConfirmButton: false,
                timer: 1200
            });
            $scope.testMark += $scope.questions[$scope.indexQuestion].Marks;
        } else {
            Swal.fire({
                icon: 'error',
                title: 'Bạn đã chọn sai HIHI !!!',
                showConfirmButton: false,
                timer: 1200
            })
        }
    }

    $scope.finish = function () {
        Swal.fire({
            title: 'Bạn có chắc không ?',
            text: 'Bạn thực sự muốn kết thúc bài thi ?',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#d33',
            cancelButtonColor: '#3085d6',
            confirmButtonText: 'Có',
            cancelButtonText: 'Không'
        }).then(res => {
            if (res.value) {
                $scope.timer = 3;
                Swal.fire({
                    title: 'Kết thúc bài thi',
                    text: 'Bài thi sẽ kết thúc sau 3 giây hihi !!!',
                    icon: 'success',
                    showCancelButton: false,
                    closeOnClickOutside: false,
                    allowOutsideClick: false,
                    timer: 4000
                })
            }
        })
    }

    var stop = $interval(() => {
        if ($scope.timer > 0) { $scope.timer -= 1 } else if ($scope.timer == 0) {

            $rootScope.student.marks = (parseInt($rootScope.student.marks) + $scope.testMark).toString();
            $rootScope.students[$rootScope.indexStudent] = angular.copy($rootScope.student);
            window.location.href = "#!informationExam/" + $scope.subject.Id;
            $interval.cancel(stop)
        }
    }, 1000);

})