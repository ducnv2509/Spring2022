var app = angular.module('myApp', ['ngRoute']);
// .controller('myCtrl', function ($scope) {

// })
app.controller('myCtrl', function ($scope) {

})
app.run(function ($rootScope, $http, $timeout) {
    $http.get("db/Subjects.js").then(function (response) {
        $rootScope.subjects = response.data;
    });
    $rootScope.student = null;
});
app.config(function($routeProvider, $locationProvider) {
    $routeProvider
        .when("/index", { templateUrl: "layout/HomePage.html"})
        .when("/about", { templateUrl: "layout/About.html" })
        .when("/Contact", { templateUrl: "layout/Contact.html" })
        .when("/Feedback_Home", { templateUrl: "layout/Feedback_Home.html" })
        .when("/FAQ", { templateUrl: "layout/FAQ.html" })
        .when("/ListTest", { templateUrl: "layout/ListTest.html"})
        .when("/Profile", { templateUrl: "layout/Profile.html"})
        .when("/ChangePassword", { templateUrl: "layout/ChangePassword.html"})
        .otherwise({ redirectTo: "/index" });



});

app.run(function ($rootScope) {
    $rootScope.$on("$routeChangeStart", function () {
        $rootScope.loading = true;
    })
    $rootScope.$on("$routeChangeSuccess", function () {
        $rootScope.loading = false;
    })

    $rootScope.$on("$routeChangeError", function () {
        $rootScope.loading = false;
        alert('Lỗi, không tải được template')
    })
})

