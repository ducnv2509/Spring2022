
var app = angular.module('myapp', []);
app.controller('myctrl', function ($scope, $http) {
    $scope.products = list;
})