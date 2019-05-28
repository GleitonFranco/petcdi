/**
 * Created by gleiton on 15/01/16.
 */

angular.module('petsis').directive('mdTableSimplex', function() {
  return {
    restrict: 'E',
    scope: {
      headers: '=',
      sortable: '=',
      filters: '=',
      editFunction: '=',
      deleFunction: '=',
      newFunction: '=',
      entity: '@',
      customClass: '=customClass'
    },
    controller: function ($scope, $injector) {
      var serviceName = $scope.entity+'Service';
      $injector.invoke([serviceName, function(service){
        $scope.service = service;
        $scope.service.pagina({pagNum:1, linhasPorPag:10}, function (obj) {
          $scope.pagina = obj;
          $scope.tablePage = $scope.pagina.pagNum;
          $scope.linhas = obj.linhas;
        });
      }]);
      $scope.nbOfPages = function () {
        return $scope.pagina ? $scope.pagina.numPags : 1;
      };
      $scope.handleSort = function (field) {
        if ($scope.sortable.indexOf(field) > -1) {
          return true;
        } else {
          return false;
        }
      };
      $scope.getNumber = function (num) {
        return new Array(num);
      };
      $scope.goToPage = function (page) {
        $scope.pagina.pagNum = page;
        $scope.service.pagina({pagNum:page, linhasPorPag:$scope.pagina.linhasPorPag}, function (obj) {
          $scope.pagina = obj;
          $scope.tablePage = $scope.pagina.pagNum;
          $scope.linhas = obj.linhas;
        });
      };
      $scope.andapag = function(inc) {
        $scope.goToPage($scope.pagina.pagNum + inc);
      }
      $scope.editar = function (index) {
        $scope.editFunction($scope.linhas[index]);
      }
      $scope.excluir = function (index) {
        $scope.deleFunction($scope.linhas[index]);
      }
    },
    templateUrl: "js/app/templates/md-table-simplex.html"
  }
});
