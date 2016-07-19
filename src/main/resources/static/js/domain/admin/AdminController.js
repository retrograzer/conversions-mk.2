angular
  .module('app')
  .controller('AdminController',['AdminService','$location','$routeParams',	function(AdminService, $location, $routeParams) {
	  
	  var ctrl = this;
	  ctrl.path = $location.path();
	  
	  console.log(ctrl.path)
	  
	  AdminService.getAllUrls()
		 .then(function(result){
			 
		 })
	  
	  ctrl.createURL = function() {
		 console.log('Creating new URL')
	  } 
 }])