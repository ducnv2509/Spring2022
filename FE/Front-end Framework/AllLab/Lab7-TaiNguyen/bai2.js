
var app = angular.module('myapp', []);
app.controller('myctrl', function ($scope, $http) {
    $scope.products = list;
})
app.filter('percentage', function ($filter) {
    return function (input, decimals) {
        return $filter('number')(input * 100, decimals) + '%';
    }
})