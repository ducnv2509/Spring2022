app.controller('myRegisterCtrl', function ($scope, $rootScope, $http) {
  const api = "https://620cffe3b573632593a1edf4.mockapi.io/Accounts";
  $scope.register = function () {
    $http.post(api, $scope.studentRegister).then(function (response) {
      $scope.students.push(response.data)
      $scope.student.id = response.data.id;
      console.log(response)
    })
    // $rootScope.students.push(angular.copy($scope.studentRegister));
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

app.directive('checkUser', function () {
  return {
      require: 'ngModel',
      link: function (scope, element, attr, mCtrl) {
          const fnCheckUser = function (value) {
              let checkValid = true;
              for (let index = 0; index < scope.students.length; index++) {
                  if (scope.students[index].username == value) {
                      checkValid = false;
                  }
                  mCtrl.$setValidity("check_user", checkValid);
              }
              // console.log('ok', value);
              return value;
          }
          mCtrl.$parsers.push(fnCheckUser)
      }
  }
})

app.directive('checkEmail', function () {
  return {
      require: 'ngModel',
      link: function (scope, element, attr, mCtrl) {
          const fnCheckEmail = function (value) {
              let checkValid = true;
              for (let index = 0; index < scope.students.length; index++) {
                  if (scope.students[index].email == value) {
                      checkValid = false;
                  }
                  mCtrl.$setValidity("check_email", checkValid);
              }
              // console.log('ok', value);
              return value;
          }
          mCtrl.$parsers.push(fnCheckEmail)
      }
  }
})
