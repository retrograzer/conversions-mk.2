angular.
  module('app').
  config(['$routeProvider', 'baseRoute', 'homePage',
    function config($routeProvider, baseRoute, homePage) {
	  console.log('Yo mic check');

      $routeProvider.
      	when('/home', {
          
          templateUrl: homePage,
          controller: 'HomeController',
          controllerAs: 'homeController'
          
        }).
      	when('/user', {
          
          templateUrl: baseRoute + 'user/userTemplate.html',
          controller: 'UserController',
          controllerAs: 'userController',
          resolve: {
              allUsers: function(UserService){
	                  return UserService.getAllUsers();
	          }
          }
        
        }).
        when('/user/:id', {
        	
        	templateUrl: baseRoute + 'user/userDetailTemplate.html',
        	controller: 'UserDetailController',
        	controllerAs: 'userDetailController'
        }).
        when('/login', {
        	
        	templateUrl: baseRoute + 'loginParse/loginTemplate.html',
        	controller: 'loginController',
        	controllerAs: 'loginController'
        }).
        otherwise('/home');
    }
  ]);