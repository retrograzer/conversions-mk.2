angular
	.module("app")
	.service('AdminService', ['$http', function($http) {
		var ctrl = this;
		
		var url = "/urls"
		
		this.getAllUrls = function() {
			return $http.get(url + "login", login)
		}
	}])