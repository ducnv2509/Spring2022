app.controller('createQuetions', function ($scope, $routeParams, $http, $rootScope) {

    $scope.index = -1;
    $rootScope.quizzs.forEach(array => {
        if (array.Id == $routeParams.id) {
            $scope.subject = angular.copy(array);
            return;
        }
    })

    const api = "https://620cffe3b573632593a1edf4.mockapi.io/Quetions";
    $scope.create = function () {
        $http.post(api, $scope.creQuetion).then(function (response) {
            $scope.quetions.push(response.data)
        })
        Swal.fire({
            icon: 'success',
            title: 'Tạo câu hỏi thành công',
            showConfirmButton: false,
            closeOnClickOutside: false,
            allowOutsideClick: false,
            timer: 1600
        });
        $scope.clear();
    }

    $scope.clear = function () {
        $scope.creQuetion = {};
        $scope.index = -1;
    }

    $scope.edit = function (index) {
        $scope.index = index;
        $scope.creQuetion = angular.copy($scope.quetions[index]);
    }
    $scope.onDelete = function (index) {
        const id = $scope.quetions[index].id;
        const deleteApi = api + '/' + id;
        $http.delete(deleteApi).then(response => {
            $scope.quetions.splice(index, 1);
        }).catch(error => {
        })

        Swal.fire({
            icon: 'success',
            title: 'Xoá thành công !',
            showConfirmButton: false,
            closeOnClickOutside: false,
            allowOutsideClick: false,
            timer: 1600
        })
        $scope.clear();
    }

    $scope.update = function () {
        const id = $scope.creQuetion.id;
        const updateAPI = api + '/' + id;
        $http.put(updateAPI, $scope.creQuetion).then(response => {
            // $scope.student.id = response.data.Id;
            // $scope.students.push(response.data);
            $rootScope.quetions[$scope.index] = angular.copy($scope.creQuetion);

        })
        // $rootScope.students[$rootScope.indexStudent] = angular.copy($rootScope.student);

        Swal.fire({
            icon: 'success',
            title: 'Cập nhập thông tin thành công !',
            showConfirmButton: false,
            closeOnClickOutside: false,
            allowOutsideClick: false,
            timer: 1600
        })
        $scope.clear();
        // window.location.href = '#!ListTest'
    }

})