angular.module('app').service('loginService', ['$http', function($http) {
	
	var url = 'user/';
	
	this.getLoginDetails = function(login) { return $http.post(url + "login", login) };
	
}])