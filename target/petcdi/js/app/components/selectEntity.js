/**
 * Created by gleiton on 26/04/17.
 */

angular.module('petsis').directive('selectEntity', function() {
  return {
    restrict: 'E',
    scope: {
      entity: '@',
      field: '@',
      modelo: '='
    },
    controller: function ($scope, $injector, $filter) {
      // var orderBy = $filter('orderBy');
      var serviceName = $scope.entity+'Service';
      $injector.invoke([serviceName, function(service){
        $scope.service = service;
      }]);
      $scope.loadFabricantes = function () {
        $scope.itens = $scope.service.todos();
      }

    },
    templateUrl: "js/app/templates/select-entity.html"
  }
});
