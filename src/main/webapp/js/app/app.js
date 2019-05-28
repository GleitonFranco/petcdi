petsis = angular.module("petsis", ["ngRoute", "ngResource", "ngLoad", "ngMaterial"]);

petsis.config(['$routeProvider', function($routeProvider) {

  $routeProvider
    .when('/', {templateUrl:'main.html'})
    .when('/produtos', {templateUrl:'produto.html', controller:'ProdutoController'})
    .when('/produto', {templateUrl:'produtoForm.html', controller:'ProdutoFormController'})
    .when('/fabricantes', {templateUrl:'fabricante.html', controller:'FabricanteController'})
    .when('/fabricante', {templateUrl:'fabricanteForm.html', controller:'FabricanteFormController'})
    .when('/fornecedores', {templateUrl:'fornecedor.html', controller:'FornecedorController'})
    .when('/fornecedor', {templateUrl:'fornecedorForm.html', controller:'FornecedorFormController'})
    .when('/vendas', {templateUrl:'venda.html', controller:'VendaController'})
    .when('/venda', {templateUrl:'vendaForm.html', controller:'VendaFormController'})
    .when('/teste', {templateUrl:'teste.html'})
    .otherwise({redirectTo:'/'});

}]);

petsis.run(function($rootScope, $mdDialog) {
  $rootScope.alerta = function (texto) {
    $mdDialog.show(
      $mdDialog.alert()
        .parent(angular.element(document.querySelector('#popupContainer')))
        .clickOutsideToClose(true)
        .title('Petsis')
        .textContent(texto)
        .ariaLabel('Alert Dialog')
        .ok('OK')
      // .targetEvent(ev)
    );
  };
  $rootScope.confirmaRemover = function (obj, campos, service) {
    var confirm = $mdDialog.confirm()
      .title('Tem certeza que quer remover permanentemente o item?')
      .textContent(obj[campos[0]]+' - '+obj[campos[1]])
      .ariaLabel('Remover')
      .ok('Sim, remova!')
      .cancel('Agora acho q não sei.');
    // .targetEvent(ev)

    $mdDialog.show(confirm).then(function() {
      service.remover({id: obj.id}, function () {
        $rootScope.alerta('Item removido.');
      });
    }, function() {
      $rootScope.alerta('Você decidiu não remover.');
    });
  }
});