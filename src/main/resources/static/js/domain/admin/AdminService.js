angular
	.module("app")
	.service('AdminService', ['$http', function($http) {
		var ctrl = this;
		var myPath = ctrl.$location.path();
	}])