angular.module('petsis').factory("VendaService", function($resource){
    return $resource('services/vendas/:id', { id: '@id'}, {
      todos: {
        method: 'GET',
        url: 'services/vendas',
        isArray: true
      },
      pagina: {
        method: 'GET',
        url: 'services/vendas/:pagNum/:linhasPorPag',
        isArray: false
      },
      totalPaginas: {
        method: 'GET',
        url: 'services/vendas/paginas/:linhasPorPag',
        isArray: false
      }
    });
});

angular.module('petsis').controller('VendaController', ['$scope', 'VendaService', '$location', '$rootScope', function($scope, VendaService, $location, $rootScope) {

  $scope.headers = [
    {
      name: 'ID',
      field: 'id'
    },{
      name:'Data',
      field: 'data'
    },{
      name: 'Total',
      field: 'venTotalLiq'
    }
  ];
  $scope.custom = {id:'bold', data:'grey', venTotalLiq:'grey'};
  $scope.sortable = ['id', 'data'];

  $scope.novo = function () {
    VendaService.vendaSelect = {};
    VendaService.linhas = [];
    $location.path('/venda');
  }

  $scope.editar = function (obj) {
    VendaService.vendaSelect = VendaService.get({id:obj.id}, function (venda) {
      $scope.venda = venda;
      $location.path('/venda');
    });
  }

  $scope.excluir = function (obj) {
    $rootScope.confirmaRemover(obj, ['id','fantasia'], VendaService);
  }

}]);


angular.module('petsis').controller('VendaFormController', ['$scope', 'VendaService', 'ProdutoService', '$location','$q', '$timeout', '$log', function($scope, VendaService, ProdutoService, $location, $q, $timeout, $log) {

  $scope.venda = VendaService.vendaSelect;
  $scope.isDisabled = false;
  $scope.simulateQuery = true;
  $scope.noCache = false;
  $scope.produtos = [];
  $scope.venda = VendaService.vendaSelect || {};
  $scope.linhas = VendaService.linhas || [];
  $scope.initVendaItem = function () {
    $scope.vendaItem = { qtde: 1};
    $scope.searchText = "";
    // $('#codigo')[0].focus();
    $('#codigo').focus()
  }
  // $scope.$on('$viewContentLoaded', function() {
  //   $scope.initVendaItem();
  // });
  // angular.element(document)[0].load(function () {
  //   $scope.initVendaItem();
  // });

  $scope.headers = [
    {
      name: 'Produto',
      field: 'produto.descricao'
    },{
      name:'Qtde',
      field: 'qtde'
    },{
      name: 'Pr Unit',
      field: 'prUnit'
    },{
      name: 'desconto',
      field: 'desconto'
    },{
      name: 'subtotal',
      field: 'subtotal'
    }
  ];
  $scope.querySearch = function(query) {
    // var results = query ? $scope.produtos.filter( $scope.createFilterFor(query) ) : $scope.produtos, deferred;
    var deferred;
    var results = ProdutoService.descricao({key: query});
    if ($scope.simulateQuery) {
      deferred = $q.defer();
      // $timeout(function () { deferred.resolve( results ); }, Math.random() * 1000, false);
      deferred.resolve( results );
      return deferred.promise;
    } else {
      return results;
    }
  }
  $scope.searchTextChange = function(text) {
    $log.info('Text changed to ' + text);
  }

  $scope.selectedItemChange = function(item) {
    $log.info('Item changed to ' + JSON.stringify(item));
    if ($scope.produto) _.extend($scope.vendaItem,
      {
        produto: $scope.produto,
        prUnit: $scope.produto.prVenda,
        desconto: 0
      });
    // angular.element(document).find('#qt')[0].focus();
    $('#qt')[0].focus(function() {
      var $this = $(this);
      $this.select();
    });
  }

  $scope.createFilterFor = function(query) {
    var upperercaseQuery = angular.uppercase(query);
    return function filterFn(state) {
      return (state.value.indexOf(upperercaseQuery) === 0);
    };
  }

  $scope.newItem = function (texto) {
    $log.info("criar agendado para "+texto);
  }

  $scope.lancar = function () {
    _.extend($scope.vendaItem, {
      subtotal: $scope.produto.prVenda * $scope.vendaItem.qtde - $scope.vendaItem.desconto
    });
    $scope.linhas[$scope.linhas.length] = angular.copy($scope.vendaItem);
    $scope.initVendaItem();
  }

  $scope.salvar = function () {
    var vendaSave = new VendaService();
    vendaSave.venda = $scope.venda;
    VendaService.save(vendaSave, function () {
      $location.path('/vendas');
    });
  }
}]);
