angular
  .module('app')
  .controller('loginController',['loginService','$location','$routeParams',	function(loginService, $location, $routeParams) {
	  
	var ctrl = this;
	
	this.login = function() {
	  var login = {
	  "username" : ctrl.username,
	  "password" : ctrl.password
	  }
	  loginService.getLoginDetails(login)
	  .then(function(result) {
		loginService.setResult()
		ctrl.user = result.data
		console.dir(ctrl.user)
		  if (ctrl.user.role === 1) {
			$location.path('/admin')
		  } else if (ctrl.user.role === 2) {
		    $location.path('user')
		  }
	  })
	}
}])