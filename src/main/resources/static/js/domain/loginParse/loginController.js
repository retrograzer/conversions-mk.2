angular
  .module('app')
  .controller('loginController',['loginService','$location','$routeParams',	function(loginService, $location, $routeParams) {
	  
	var ctrl = this;
	
	this.login = function() {
	  var login = {
	  "username" : ctrl.username,
	  "password" : ctrl.password,
	  "num": ctrl.num,
	  "role": ctrl.role
	  }
	  loginService.getLoginDetails(login)
	  .then(function(result) {
		ctrl.user = result.data
		console.dir(ctrl.user)
		  if (ctrl.user.role === 1) {
			$location.path('/admin')
		  } else if (ctrl.user.role === 2) {
		    $location.path('user')
		  }
	  })
	}
	
	this.register = function() {
		var register = {
				"password": ctrl.Rpassword,
				"role": ctrl.role,
				"username": ctrl.Rusername,
		}
		loginService.createUser(register)
		.then(function(result) {
			ctrl.user = result.data
			console.dir(ctrl.user)
		})
	}
}])