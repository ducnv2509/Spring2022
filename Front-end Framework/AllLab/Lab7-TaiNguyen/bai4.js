
var app = angular.module('myapp', []);
app.controller('myctrl', function ($scope, $http) {
    $scope.products = [];
    $http.get('Prods2.js').then(function (response){
        $scope.products = response.data;
    } )
    $scope.begin = 0;
    $scope.pageSize = 8;
    $scope.pageCount = Math.ceil($scope.products.length / $scope.pageSize);
    $scope.prop = 'price';
    $scope.repaginate = function () {
        $scope.begin = 0;
        $scope.pageCount = Math.ceil($scope.products.length / $scope.pageSize);
    }
    $scope.sortBy = function (prop) {
        $scope.prop = prop;

    }
    $scope.first = function () {
        $scope.begin = 0;
    }
    $scope.previous = function () {
        if ($scope.begin > 0) {
            $scope.begin -= $scope.pageSize;
        }
    }
    $scope.next = function () {
        if ($scope.begin < ($scope.pageCount - 1) * scope.pageSize) {
            $scope.begin += $scope.pageSize;
        }
    }
    $scope.last = function () {
        $scope.begin = ($scope.pageCount - 1) * $scope.pageSize;
    }

})
app.directive('convertToNumber', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, atrs, ngModel) {
            ngModel.$parsers.push(function (val) {
                return parseInt(val, 10);
            })
            ngModel.$formatters.push(function (val) {
                return '' + val;
            })
        }
    }
})
app.filter('percentage', function ($filter) {
    return function (input, decimals) {
        return $filter('number')(input * 100, decimals) + '%';
    }
})