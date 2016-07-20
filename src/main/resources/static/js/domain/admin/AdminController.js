angular
  .module('app')
  .controller('AdminController',['AdminService','$location','$routeParams',	function(AdminService, $location, $routeParams) {
	  
	  var ctrl = this;
	  ctrl.urlNum = 1;
	  ctrl.path = $location.path();
	  ctrl.shownLabels;
	  
	  console.log(ctrl.path);
	  
	  this.getAllUrls = function(){
		  AdminService.getAllUrls()
		  .then(function(result){
			  ctrl.allUrls = result.data;
			  console.dir(ctrl.allUrls)
			  ctrl.urlNum = ctrl.allUrls[ctrl.allUrls.length - 1].id + 1
		  })
	  }
	  
	  ctrl.createURL = function() {
		 console.log('Creating new URL');
		 console.log(ctrl.urlNum)
		 var requester = {
					"label": ctrl.urlLabel,
					"url": "/login/"+ctrl.urlNum
		 };
		 AdminService.createURL(requester)
		 .then(function(result){
			 ctrl.newUrl = result.data;
			 console.log(ctrl.newUrl)
			 ctrl.urlNum++;
		 })
	  } 
	  
	  
	  ctrl.timeSpan = 'all';
	  
	  ctrl.setSpan = function(newValue) {
		  ctrl.timeSpan = newValue;
		  console.log(ctrl.timeSpan)
	  }
	  
	  this.tab = 1;

	    this.setTab = function(newValue){
	      this.tab = newValue;
	    };

	    this.isSet = function(tabName){
	      return this.tab === tabName;
	    };
	    
 }])