angular.module('petsis').factory("FornecedorService", function($resource){
    return $resource('services/fornecedores/:id', { id: '@id'}, {
      todos: {
        method: 'GET',
        url: 'services/fornecedores',
        isArray: true
      },
      pagina: {
        method: 'GET',
        url: 'services/fornecedores/:pagNum/:linhasPorPag',
        isArray: false
      },
      totalPaginas: {
        method: 'GET',
        url: 'services/fornecedores/paginas/:linhasPorPag',
        isArray: false
      }
    });
});

angular.module('petsis').controller('FornecedorController', ['$scope', 'FornecedorService', '$location', '$rootScope', function($scope, FornecedorService, $location, $rootScope) {

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
    },{
      name: 'Site',
      field: 'site'
    }
  ];
  $scope.custom = {id:'bold', razao:'grey', fantasia:'grey'};
  $scope.sortable = ['id', 'razao'];

  $scope.novo = function () {
    FornecedorService.fornecedorSelect = {};
    $location.path('/fornecedor');
  }

  $scope.editar = function (obj) {
    FornecedorService.fornecedorSelect = FornecedorService.get({id:obj.id}, function (fornecedor) {
      $scope.fornecedor = fornecedor;
      $location.path('/fornecedor');
    });
  }

  $scope.excluir = function (obj) {
    $rootScope.confirmaRemover(obj, ['id','fantasia'], FornecedorService);
  }

}]);


angular.module('petsis').controller('FornecedorFormController', ['$scope', 'FornecedorService', '$location', function($scope, FornecedorService, $location) {

  $scope.fornecedor = FornecedorService.fornecedorSelect;
  $scope.salvar = function () {
    var fornecedorSave = new FornecedorService();
    fornecedorSave.fornecedor = $scope.fornecedor;
    FornecedorService.save(fornecedorSave, function () {
      $location.path('/fornecedores');
    });
  }
}]);