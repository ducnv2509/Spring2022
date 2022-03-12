var myApp = angular.module('myapp', []);

myApp.controller('registerCtrl', function ($scope) {
    $scope.save = function () {
        $scope.$parent.students[$scope.$parent.index] = angular.copy($scope.student);
    }
    $scope.cancel = function () {
        $scope.$parent.student = angular.copy($scope.$parent.students[$scope.$parent.index]);
    }
});

myApp.controller('listCtrl', function ($scope) {

    $scope.$parent.students = [
        {
            fullname: 'Nguyễn Văn Đức',
            birthday: '25-09-2002',
            mark: 10
        },
        {
            fullname: 'Nguyễn Văn Minh',
            birthday: '21-09-2001',
            mark: 8
        }
    ]
    $scope.$parent.student = {};
    $scope.$parent.index = -1;
    $scope.edit = function (index) {
        $scope.$parent.index = index;
        $scope.$parent.student = angular.copy($scope.$parent.students[index]);

    }
})