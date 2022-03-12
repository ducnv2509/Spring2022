var myApp = angular.module('myapp', []);

myApp.controller('crudCtrl', function ($scope) {
    $scope.students = []
    $scope.student = {};
    $scope.index = -1;
    $scope.insert = function () {
        $scope.students.push(angular.copy($scope.student));
        $scope.index = $scope.students.length - 1;
    }
    $scope.update = function () {
        $scope.students[$scope.index] = angular.copy($scope.student);
    }
    $scope.delete = function () {
        $scope.students.splice($scope.index, 1);
        $scope.clear();
    }
    $scope.edit = function (index) {
        $scope.index = index;
        $scope.student = angular.copy($scope.students[index]);
    }
    $scope.save = function () {
        $scope.students[$scope.index] = angular.copy($scope.student);
    }
    $scope.clear = function () {
        $scope.student = {};
        $scope.index = -1;
    }
    $scope.cancel = function () {
        if ($scope.index < 0) {
            $scope.clear();
        } else {
            $scope.edit($scope.index);
        }
    }
})