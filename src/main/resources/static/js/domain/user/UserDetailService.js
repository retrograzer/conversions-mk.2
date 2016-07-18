angular.module('app').service('UserDetailService', ['$http', function($http) {
	
	var url = 'user/';
	
	this.getUserDetails = function(id) { return $http.get(url + id) };
	
}])