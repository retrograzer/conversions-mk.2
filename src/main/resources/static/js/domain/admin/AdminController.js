angular
  .module('app')
  .controller('AdminController',['AdminService','$location','$routeParams',	function(AdminService, $location, $routeParams) {
	  var ctrl = this;
	  
	  var myPath = ctrl.$location.path();
	  
	  console.log('Pa ' + myPath)
 }])