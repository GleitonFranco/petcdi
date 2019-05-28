angular.module('petsis').factory("ProdutoService", function($resource){
  return $resource('services/produtos/:id', { id: '@id'}, {
    todos: {
      method: 'GET',
      url: 'services/produtos',
      isArray: true
    },
    pagina: {
      method: 'GET',
      url: 'services/produtos/:pagNum/:linhasPorPag',
      isArray: false
    },
    totalPaginas: {
      method: 'GET',
      url: 'services/produtos/paginas/:linhasPorPag',
      isArray: false
    },
    barra: {
      method: 'GET',
      url: 'services/produtos/barra',
      isArray: true
    },
    barraUnico: {
      method: 'GET',
      url: 'services/produtos/barraunico',
      isArray: false
    },
    descricao: {
      method: 'GET',
      url: 'services/produtos/look/descricao/:key',
      isArray: true
    },
    remover: {
      method: 'POST',
      isArray: false
    }
  });
});


angular.module('petsis').controller('ProdutoController', ['$scope', 'ProdutoService', '$location'
  , '$mdDialog', '$rootScope', function($scope, ProdutoService, $location, $mdDialog, $rootScope) {

  $scope.headers = [
    {
      name: 'ID',
      field: 'id'
    },{
      name:'Descricao',
      field: 'descricao'
    },{
      name: 'Barra',
      field: 'barra'
    },{
      name: 'Estoque',
      field: 'estoque'
    },{
      name: 'Pr.Venda',
      field: 'prVenda'
    }
  ];

  $scope.custom = {id:'bold', descricao:'grey', barra:'grey'};
  $scope.sortable = ['id', 'descricao', 'barra'];

  $scope.novo = function () {
    ProdutoService.produtoSelect = {};
    $location.path('/produto');
  }
  $scope.editar = function (obj) {
    ProdutoService.produtoSelect = ProdutoService.get({id:obj.id}, function () {
      $location.path('/produto');
    });
  }
  $scope.excluir = function (obj) {
    $rootScope.confirmaRemover(obj, ['id','descricao'], ProdutoService);
  }

}]);


angular.module('petsis').controller('ProdutoFormController', ['$scope', 'ProdutoService','FabricanteService', '$location'
  , function($scope, ProdutoService, FabricanteService, $location) {

    $scope.produto = ProdutoService.produtoSelect;

    $scope.loadFabricantes = function () {
      $scope.fabricantes = FabricanteService.todos();
    }

    $scope.salvar = function () {
      console.log($scope.produto);
      var produtoSave = new ProdutoService();
      produtoSave.produto = $scope.produto;
      ProdutoService.save(produtoSave, function () {
        $location.path('/produto');
      });
    }

  }]);