var app = angular.module('myApp', []).controller('myCtrl', function($scope){

})

app.run(function($rootScope, $http, $timeout) {

    // $http.get("db/Students.js").then(function(response) {
    //     $rootScope.students = response.data;
    // });

    $http.get("db/Subjects.js").then(function(response) {
        $rootScope.subjects = response.data;
    });
    $rootScope.student = null;
});