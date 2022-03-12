var myApp = angular.module('myapp', []);

myApp.controller('registerCtrl', function ($scope, $rootScope) {
    $scope.save = function () {
        $rootScope.students[$rootScope.index] = angular.copy($scope.student);
    }
    $scope.cancel = function () {
        $rootScope.student = angular.copy($rootScope.students[$rootScope.index]);
    }
});

myApp.controller('listCtrl', function ($scope, $rootScope) {

    $rootScope.students = [
        {
            fullname: 'Nguyễn Văn Đức',
            birthday: '25-09-2002',
            mark: 10
        },
        {
            fullname: 'Nguyễn Văn Minh',
            birthday: '21-09-2001',
            mark: 8
        },
        {
            fullname: 'Nguyễn Văn Dung',
            birthday: '21-09-2001',
            mark: 5
        },
        {
            fullname: 'Nguyễn Văn Ha',
            birthday: '21-09-2001',
            mark: 1
        }
    ]
    $rootScope.student = {};
    $rootScope.index = -1;
    $scope.edit = function (index) {
        $rootScope.index = index;
        $rootScope.student = angular.copy($rootScope.students[index]);
    }
})