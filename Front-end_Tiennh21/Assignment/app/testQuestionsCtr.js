app.controller('testQuestion', function ($scope, $interval, $http, $routeParams, $rootScope) {

    $rootScope.quizzs.forEach(array => {
        if (array.Id == $routeParams.id) {
            $scope.subject = angular.copy(array);
            return;
        }
    })

    $http.get('db/Quizs/' + $routeParams.id + '.js').then(response => {
        $scope.questions = response.data;
    });

    // $http.get("https://620cffe3b573632593a1edf4.mockapi.io/Quetions/" + $routeParams.id).then(response => {
    //     $scope.questions = response.data;
    // });

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
        console.log('sssss', $scope.timer)
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

                // $scope.timerF = {};
                Swal.fire({
                    title: "Kết thúc bài thi",
                    icon: "success",
                    showCancelButton: false,
                    closeOnClickOutside: false,
                    allowOutsideClick: false,
                    timer: 4000,
                });

                // {{(timer-timer%60)/60}}:{{timer%60}}
                // const gio = (($scope.timer - $scope.timer % 60) / 60) / $scope.timer % 60;
                const phut = (($scope.timer - $scope.timer % 60) / 60);
                const ngay = new Date();
                const apiExam = "https://620cffe3b573632593a1edf4.mockapi.io/History";
                $rootScope.history.idExam = $scope.subject.Id;
                $rootScope.history.nameExam = $scope.subject.Name;
                $rootScope.history.mark = $scope.testMark;
                $rootScope.history.idUser = $rootScope.student.id;
                $rootScope.history.timer = (14 - phut) + " phút : " + (59 - $scope.timer % 60) + " giây";
                $rootScope.history.day = ngay;
                $scope.timer = 3;

                // console.log('logggg ne', $scope.timerF)

                // console.log('gio nay', gio)
                console.log('p nay', phut)
                console.log('timer nay', $scope.timer);

                $http.post(apiExam, $rootScope.history).then(function (response) {
                    // $rootScope.historys.push(response.data);
                    // console.log($rootScope.historys);
                    //   });
                    // }
                });
                // window.location.href = "#!information/" + $scope.subject.Id;
                
            }
        })
    }

    // var stop = $interval(() => {
    //     if ($scope.timer > 0) {
    //         $scope.timer -= 1;
    //     } else if ($scope.timer == 0) {
    //         $rootScope.student.marks = parseInt($scope.testMark).toString();
    //         $rootScope.students[$rootScope.indexStudent] = angular.copy(
    //             $rootScope.student
    //         );
    //         $rootScope.history.id = $rootScope.student.id;
    //         $rootScope.history.idExam = $scope.subject.Id;
    //         $rootScope.history.nameExam = $scope.subject.Name;
    //         $rootScope.history.mark = $scope.testMark;
    //         $rootScope.historys.unshift(angular.copy($rootScope.history));
    //         window.location.href = "#!information/" + $scope.subject.Id;
    //         $interval.cancel(stop);
    //     }
    // }, 1000);
    var stop = $interval(() => {
        if ($scope.timer > 0) { $scope.timer -= 1 } else if ($scope.timer == 0) {

            $rootScope.student.marks = (parseInt($rootScope.student.marks) + $scope.testMark).toString();
            $rootScope.students[$rootScope.indexStudent] = angular.copy($rootScope.student);

            $rootScope.history.id = $rootScope.student.id;
            $rootScope.history.idExam = $scope.subject.Id;
            $rootScope.history.nameExam = $scope.subject.Name;
            $rootScope.history.mark = $scope.testMark;
            $rootScope.historys.unshift(angular.copy($rootScope.history));
            window.location.href = "#!informationExam/" + $scope.subject.Id;
            $interval.cancel(stop)
        }
    }, 1000);

})