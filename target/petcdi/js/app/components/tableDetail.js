/**
 * Created by gleiton on 15/01/16.
 */

angular.module('petsis').directive('mdTableDetail', function() {
  return {
    restrict: 'E',
    scope: {
      headers: '=',
      linhas: '=',
      editFunction: '=',
      deleFunction: '=',
      customClass: '=customClass'
    },
    controller: function ($scope, $injector) {
      $scope.editar = function (index) {
        $scope.editFunction($scope.linhas[index]);
      }
      $scope.excluir = function (index) {
        $scope.deleFunction($scope.linhas[index]);
      }
    },
    templateUrl: "js/app/templates/md-table-detail.html"
  }
});
