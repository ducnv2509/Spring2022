app.controller('myManagerQ', function ($scope, $rootScope, $http) {
    const apiQuizz = "https://620cffe3b573632593a1edf4.mockapi.io/Exam";


    $scope.create = function () {
        $http.post(apiQuizz, $scope.createQ).then(function (response) {
            $scope.quizzs.push(response.data);
        })

        Swal.fire({
            icon: 'success',
            title: 'Tạo quizz thành công',
            showConfirmButton: false,
            closeOnClickOutside: false,
            allowOutsideClick: false,
            timer: 1600
        });
    }
    $scope.indexUpdate = '';
    $scope.edit = function (index) {
        $scope.indexUpdate = index;
        $scope.createQ = angular.copy($scope.quizzs[index]);
    }


    $scope.update = function () {
        const id = $scope.createQ.id;
        const updateAPI = apiQuizz + '/' + id;
        $http.put(updateAPI, $scope.createQ).then(function (response) {
            $rootScope.quizzs[$scope.indexUpdate] = angular.copy($scope.createQ);
        })

        Swal.fire({
            icon: 'success',
            title: 'update thành công',
            showConfirmButton: false,
            closeOnClickOutside: false,
            allowOutsideClick: false,
            timer: 1600
        });
        console.log($scope.createQ.id)
    }


    $scope.delete = function (index) {
        const id = $scope.quizzs[index].id;
        const deleteAPI = apiQuizz + '/' + id;
        $http.delete(deleteAPI).then(function (response) {
            $scope.quizzs.splice(index, 1);

        }).catch(function (error) { })

        Swal.fire({
            icon: 'success',
            title: 'Xoá thành công',
            showConfirmButton: false,
            closeOnClickOutside: false,
            allowOutsideClick: false,
            timer: 1600
        });
        console.log('OKKOKO', id)
    }
})

app.directive('checkQuizz', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attr, mCtrl) {
            const fnCheckQuizz = function (value) {
                let checkValid = true;
                for (let index = 0; index < scope.quizzs.length; index++) {
                    if (scope.quizzs[index].Id == value) {
                        checkValid = false;
                    }
                    mCtrl.$setValidity("check_quizz", checkValid);
                }
                // console.log('ok', value);
                return value;
            }
            mCtrl.$parsers.push(fnCheckQuizz)
        }
    }
  })