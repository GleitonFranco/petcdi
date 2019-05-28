angular.module('petsis').factory("FabricanteService", function($resource){
    return $resource('services/fabricantes/:id', { id: '@id'}, {
      todos: {
          method: 'GET',
          url: 'services/fabricantes',
          isArray: true
      },
      pagina: {
        method: 'GET',
        url: 'services/fabricantes/:pagNum/:linhasPorPag',
        isArray: false
      },
      totalPaginas: {
        method: 'GET',
        url: 'services/fabricantes/paginas/:linhasPorPag',
        isArray: false
      }
    });
});

angular.module('petsis').controller('FabricanteController', ['$scope', 'FabricanteService', '$location', '$rootScope', function($scope, FabricanteService, $location, $rootScope) {

  $scope.headers = [
    {
      name: 'ID',
      field: 'id'
    },{
      name:'CNPJ',
      field: 'cnpj'
    },{
      name: 'Razão Social',
      field: 'razao'
    },{
      name: 'Fantasia',
      field: 'fantasia'
    }
    ,{
      name: 'Site',
      field: 'site'
    }
  ];
  $scope.custom = {id:'bold', razao:'grey', fantasia:'grey'};
  $scope.sortable = ['id', 'razao'];

  $scope.novo = function () {
    FabricanteService.fabricanteSelect = {};
    $location.path('/fabricante');
  }

  $scope.editar = function (obj) {
    FabricanteService.fabricanteSelect = FabricanteService.get({id:obj.id}, function (fabricante) {
      $location.path('/fabricante')
    });
  }

  $scope.excluir = function (obj) {
    $rootScope.confirmaRemover(obj, ['id','fantasia'], FabricanteService);
  }

}]);


angular.module('petsis').controller('FabricanteFormController', ['$scope', 'FabricanteService', '$location', function($scope, FabricanteService, $location) {
  $scope.fabricante = FabricanteService.fabricanteSelect;

  $scope.salvar = function () {
    var fabricanteSave = new FabricanteService();
    fabricanteSave.fabricante = $scope.fabricante;
    FabricanteService.save(fabricanteSave, function () {
      $location.path('/fabricantes');
    });
  }
}]);