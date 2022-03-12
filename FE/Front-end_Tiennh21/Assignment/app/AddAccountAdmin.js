app.controller('myAddAccount', function ($scope, $rootScope, $http) {
  $scope.index = -1;

    const api = "https://620cffe3b573632593a1edf4.mockapi.io/Accounts";
    // $scope.isLoading = true;
    $scope.register = function () {
      $http.post(api, $scope.studentRegister).then(function (response) {
        $scope.students.push(response.data)
        $scope.student.id = response.data.id;
      })
      // $rootScope.students.push(angular.copy($scope.studentRegister));
      $scope.studentRegister = {};
      $scope.repassword = '';
      
      Swal.fire({
        icon: 'success',
        title: 'Đăng ký thành công !',
        showConfirmButton: false,
        closeOnClickOutside: false,
        allowOutsideClick: false,
        timer: 1600
      });
  
      $scope.validationmsg = false;
      var chkselct = $scope.chkselct;
  
      if (chkselct == false || chkselct == undefined) {
        $scope.validationmsg = true;
      }
      else {
        $scope.validationmsg = false;
      }
    }
    $scope.clear = function () {
      $scope.studentRegister = {};
      $scope.index = -1;
  }

    $scope.edit = function (index) {
      $scope.index = index;
      $scope.studentRegister = angular.copy($scope.students[index]);
  }
  $scope.onDelete = function (index) {
    const id = $scope.students[index].id;
    const deleteApi = api + '/' + id;
    $http.delete(deleteApi).then(response => {
        $scope.students.splice(index, 1);
    }).catch(error => {
    })
    
  Swal.fire({
    icon: 'success',
    title: 'Xoá thành công !',
    showConfirmButton: false,
    closeOnClickOutside: false,
    allowOutsideClick: false,
    timer: 1600
})
$scope.clear();
  }

  $scope.update = function () {
  const id = $scope.studentRegister.id;
  const updateAPI = api + '/' + id;
  $http.put(updateAPI, $scope.studentRegister).then(response => {
      // $scope.student.id = response.data.Id;
      // $scope.students.push(response.data);
      $rootScope.students[$scope.index] = angular.copy($scope.studentRegister);

  })
  // $rootScope.students[$rootScope.indexStudent] = angular.copy($rootScope.student);

  Swal.fire({
      icon: 'success',
      title: 'Cập nhập thông tin thành công !',
      showConfirmButton: false,
      closeOnClickOutside: false,
      allowOutsideClick: false,
      timer: 1600
  })
  // window.location.href = '#!ListTest'
}
  
  })

  
  
  // app.directive('validPasswordC', function () {
  //   return {
  //     require: 'ngModel',
  //     scope: {
  
  //       reference: '=validPasswordC'
  
  //     },
  //     link: function (scope, elm, attrs, ctrl) {
  //       ctrl.$parsers.unshift(function (viewValue, $scope) {
  
  //         var noMatch = viewValue != scope.reference
  //         ctrl.$setValidity('noMatch', !noMatch);
  //         return (noMatch) ? noMatch : !noMatch;
  //       });
  
  //       scope.$watch("reference", function (value) {
  //         ;
  //         ctrl.$setValidity('noMatch', value === ctrl.$viewValue);
  
  //       });
  //     }
  //   }
  // });

