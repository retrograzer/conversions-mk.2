angular
  .module('app')
  .controller('UserController',['$location','$routeParams',	function(UserService, $location, $routeParams) {

	this.tab = 1;
	this.jumbo = 'Welcome!';
	
	this.setTab = function(newValue){
	  this.tab = newValue;
	  if (this.tab === 2) {
		  this.jumbo = 'Technical Resume';
	  } else {
		  this.jumbo = 'Professional Biography';
	  }
	};
	
	this.isSet = function(tabName){
	  return this.tab === tabName;
	};
}])