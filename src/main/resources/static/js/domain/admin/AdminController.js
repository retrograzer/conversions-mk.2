angular
  .module('app')
  .controller('AdminController',['AdminService','$location','$routeParams',	function(AdminService, $location, $routeParams) {
	  
	  var ctrl = this;
	  var tester = 'yoyoyo';
	  ctrl.path = $location.path();
	  
	  console.log(ctrl.path)
	  
	  ctrl.createURL = function() {
		  var response = {
					"urlLabel": ctrl.urlLabel
			}
	  }
 }])