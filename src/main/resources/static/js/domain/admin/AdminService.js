angular
	.module("app")
	.service('AdminService', ['$http', function($http) {
		var ctrl = this;
		
		var url = "urls/"
		
		this.getAllUrls = function() {
			console.log('getting urls')
			return $http.get(url + "get")
		}
		
		this.createURL = function(requester) {
			return $http.post(url + "create", requester)
		}
	}])