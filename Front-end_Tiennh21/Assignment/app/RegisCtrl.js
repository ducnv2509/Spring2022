app.controller('myRegisterCtrl', function ($scope, $rootScope, $http) {
  const api = "https://620cffe3b573632593a1edf4.mockapi.io/Accounts";
  $scope.register = function () {
    $http.post(api, $scope.studentRegister).then(function (response) {
      $scope.students.push(response.data)
      console.log(response)
    })
    $rootScope.students.push(angular.copy($scope.studentRegister));
    $scope.studentRegister = {};
    $scope.repassword = '';
    Swal.fire({
      icon: 'success',
      title: 'Đăng ký thành công !',
      text: 'Quay lại trang chủ',
      showConfirmButton: false,
      closeOnClickOutside: false,
      allowOutsideClick: false,
      timer: 1600
    });
    window.location.href = "#!ListTest";

    $scope.validationmsg = false;
    var chkselct = $scope.chkselct;

    if (chkselct == false || chkselct == undefined) {
      $scope.validationmsg = true;
    }
    else {
      $scope.validationmsg = false;
    }
  }


})


app.directive('validPasswordC', function () {
  return {
    require: 'ngModel',
    scope: {

      reference: '=validPasswordC'

    },
    link: function (scope, elm, attrs, ctrl) {
      ctrl.$parsers.unshift(function (viewValue, $scope) {

        var noMatch = viewValue != scope.reference
        ctrl.$setValidity('noMatch', !noMatch);
        return (noMatch) ? noMatch : !noMatch;
      });

      scope.$watch("reference", function (value) {
        ;
        ctrl.$setValidity('noMatch', value === ctrl.$viewValue);

      });
    }
  }
});
