var app = angular.module('myApp', ['ngRoute', 'ngCookies']);
// .controller('myCtrl', function ($scope) {

// })
app.controller('myCtrl', function ($scope) {

})
app.run(function ($rootScope, $http, $timeout) {
    const api = "https://620cffe3b573632593a1edf4.mockapi.io/Accounts";
    $http.get(api).then(function (response) {
        $rootScope.students = response.data;
    });

    const apiQuizz = "https://620cffe3b573632593a1edf4.mockapi.io/Exam";
    const apiQuetions = "https://620cffe3b573632593a1edf4.mockapi.io/Quetions";
    const apiFeedBack = "https://621b7d1efaa12ee4500effb8.mockapi.io/Feedback";
    $http.get("db/Subjects.js").then(function (response) {
        $rootScope.subjects = response.data;
    });

    $http.get(apiQuizz).then(function (response) {
        $rootScope.quizzs = response.data;
    })
    $http.get(apiQuetions).then(function (response) {
        $rootScope.quetions = response.data;
    })
    $http.get(apiFeedBack).then(function (response) {
        $rootScope.feedbacks = response.data;
    })
    $rootScope.student = JSON.parse(localStorage.getItem('users'));
    $rootScope.logoff = function () {
        $rootScope.student = null;
        $rootScope.indexStudent = -1;
        Swal.fire({
            icon: 'warning',
            title: 'Đã đăng xuất !',
            text: 'Quay lại trang chủ ',
            showConfirmButton: false,
            closeOnClickOutside: false,
            allowOutsideClick: false,
            timer: 1600
        })
        window.location.href = "#!ListTest"
        localStorage.removeItem('users');
    }
});
app.config(function ($routeProvider, $locationProvider) {
    $routeProvider
        .when("/index", { templateUrl: "layout/HomePage.html" })
        .when("/about", { templateUrl: "layout/About.html" })
        .when("/Contact", { templateUrl: "layout/Contact.html" })
        .when("/Feedback_Home", { templateUrl: "layout/Feedback_Home.html" })
        .when("/FAQ", { templateUrl: "layout/FAQ.html" })
        .when("/ListTest", { templateUrl: "layout/ListTest.html" })
        .when("/Profile", { templateUrl: "layout/Profile.html" })
        .when("/History", { templateUrl: "layout/History.html" })
        .when("/ChangePassword", { templateUrl: "layout/ChangePassword.html" })
        .when("/listQuestion/:id", { templateUrl: "layout/ListQuestion.html" })
        .when("/informationExam/:id", { templateUrl: "layout/informationExam.html" })
        .when("/createQuetions/:id", { templateUrl: "layout/CreateQuetions.html" })
        .when("/ManagerAccounts", { templateUrl: "layout/ManagerAccounts.html" })
        .when("/ManagerQuetions", { templateUrl: "layout/MangagerQuetions.html" })
        .otherwise({ redirectTo: "/ListTest" });



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

