petsis.controller('IndexController', ['$scope', '$location', function($scope, $location) {

  $scope.menu = [
    {
      nome:'Arquivo',
      subitens:[
        {nome:'Produtos', icone:'img/icon/ic_devices_other_black_24px.svg', link:'#/produtos'},
        {nome:'Fabricantes', icone:'img/icon/phone.svg', link:'#/fabricantes'},
        {nome:'Fornecedor', icone:'img/icon/phone.svg', link:'#/fornecedores'},
        {nome:'Grupo', icone:'', link:'#/teste'},
        {nome:'Seção', icone:'', link:'#/'}
      ]
    },
    {
      nome:'Vendas',
      subitens:[
        {nome:'Nova Venda', icone:'', link:'#/venda'},
        {nome:'Vendas Efetuadas', icone:'', link:'#/vendas'},
        {nome:'Abertura Caixa', icone:'', link:'#/'},
        {nome:'Fechamento Caixa', icone:'', link:'#/'}
      ]
    }
  ];
  $scope.menuSelec = $scope.menu[0];

  $scope.$watch('menuSelec', function(item) {
    //console.log(item);
  });

  $scope.selecOpt = function(opcao) {
    // $location.url('/produtos');
    //console.log(opcao);
  };

}]);