angular.
  module('app').
  config(['$routeProvider', 'baseRoute', 'homePage',
    function config($routeProvider, baseRoute, homePage) {

      $routeProvider.
      	when('/home', {
          
          templateUrl: homePage,
          controller: 'HomeController',
          controllerAs: 'homeController'
          
        }).
        when('/admin', {
        	
        	templateUrl: baseRoute + 'admin/AdminTemplate.html',
            controller: 'AdminController',
            controllerAs: 'adminController',
            resolve: {
            	
            }
        }).
      	when('/user', {
          
          templateUrl: baseRoute + 'user/userTemplate.html',
          controller: 'UserController',
          controllerAs: 'userController',
          resolve: {
          }
        
        }).
        when('/login', {
        	
        	templateUrl: baseRoute + 'loginParse/loginTemplate.html',
        	controller: 'loginController',
        	controllerAs: 'loginController'
        }).
        otherwise('/home');
    }
  ]);