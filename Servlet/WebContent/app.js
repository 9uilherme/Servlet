angular.module('app', [])
  .controller('ListaController', function($scope) {
    var app = this;
    
	$scope.init = function () {
		$scope.produtos = [{nome: "Amaciante", valor: 10.90, quantidade: 1}, {nome: "Detergente", valor: 4.99, quantidade: 3}];
		
	};
	
	$scope.init();
	$scope.somaValores = 0.0;
	for(var i = 0; i < $scope.produtos.length; i++){
		var item = $scope.produtos[i];
		if(item.valor){
			$scope.somaValores += item.valor;
		}
	
	}
	$scope.comprar = function () {
		$scope.compras = {};
		$scope.compras = {pagamento : "Dinheiro", produtos : $scope.produtos };
	};
  	})

  
	.controller('MyController',['$scope', '$http', '$window', function ($scope, $http, $window) {
		$scope.produtos = [{codigo: null, nome: null, preco: null}];
		$scope.tipo = "PRODUTO";
		$scope.init = function () {
			$scope.getDataFromServer();
		};
      $scope.getDataFromServer = function() {
      	$http({
      		  method: 'GET',
      		  url: 'produtoServlet'
      		}).then(function successCallback(response) {
      			
      			$scope.produtos = response.data;
      		}, function errorCallback(response) {
      			$window.alert("fail " + response);
      		});
      	

      };
      $scope.init();
	}])


	.controller('CarrinhoController',['$scope', '$http', '$window', function ($scope, $http, $window) {
		$scope.produtos = [{codigo: null, nome: null, preco: null}];
		$scope.tipo = "CARRINHO";
        $scope.adicionarCarrinho = function(produtos) {
        	$http({
        		  method: 'POST',
        		  url: 'produtoServlet',
        		  data: {data: $scope.produtos},
		            headers: {
		                'Content-Type': 'application/json'
		            }
        		}).then(function successCallback(response) {
        			console(data);
        		});
        	

        };
        $scope.init();
	}])

;