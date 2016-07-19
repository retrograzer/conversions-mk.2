angular
  .module('app')
  .controller('loginController',['loginService','$location','$routeParams',	function(loginService, $location, $routeParams) {
	var ctrl = this;
	this.login = function() {
	  var login = {
	  "username" : ctrl.username,
	  "password" : ctrl.password
	  }
	  console.log("User: " + login)
	  loginService.getLoginDetails(login)
	  .then(function(result) {
		 console.log("Inside the result thingy" + result)
		ctrl.user = result.data
		console.dir(ctrl.user)
		console.log(ctrl.user.role)
		//if (ctrl.user.code === 'OK') {
		console.log("What the hecky?")
		  if (ctrl.user.role === 1) {
			 console.log("Ooh admins!")
			$location.path('/admin')
		  } else if (ctrl.user.role === 2) {
			  console.log("Ooh users...dang")
		    $location.path('user')
		  }
		//} else {
		   //alert('Login Failed')
		  //}
	  })
	}
}])