angular
  .module('app')
  .controller('AdminController',['AdminService','$location','$routeParams',	function(AdminService, $location, $routeParams) {
	  
	  var ctrl = this;
	  ctrl.urlNum = 1;
	  ctrl.path = $location.path();
	  ctrl.shownLabels;
	  
	  console.log(ctrl.path);
	  
	  ctrl.timeSpan = 'all';
	  
	  ctrl.setSpan = function(newValue) {
		  ctrl.timeSpan = newValue;
		  console.log(ctrl.timeSpan)
	  }
	  
	  this.getHitsSpan = function() {
		  AdminService.getTimeSpans(ctrl.timeSpan)
		  .then(function(result){
			  ctrl.allHitsThing = result.data
			  ctrl.hitNum = ctrl.allHitsThing.length
			  console.dir(ctrl.allHitsThing)
			  console.log(ctrl.hitNum)
		  })
	  }
	  
	  this.getAllUrls = function(){
		  AdminService.getAllUrls()
		  .then(function(result) {
			  ctrl.allUrls = result.data;
			  console.log(ctrl.allUrls.urlHits)
			  console.dir(ctrl.allUrls)
			  var hits = 0
			  ctrl.urlNum = ctrl.allUrls[ctrl.allUrls.length - 1].id + 1
//			  for (var i = 0; i < ctrl.allUrls.length; i++) {
//				  console.log('i: ' + ctrl.allUrls[i].url.slice(-1))
//				  hits = 0
//				  for (var h = 0; h < ctrl.allHitsThing.length; h++) {
//					  console.log('h: ' + ctrl.allHitsThing[h].hitRegion)
//					  if (ctrl.allUrls[i].url.slice(-1) == ctrl.allHitsThing[h].hitRegion){
//						  console.log('th9i9ng');
//						  hits++;
//					  }
//				  }
//			  }	  
		  })
	  }
	  
	  this.countHits = function(allUrls){
		  
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
	  
	  this.tab = 1;

	    this.setTab = function(newValue){
	      this.tab = newValue;
	    };

	    this.isSet = function(tabName){
	      return this.tab === tabName;
	    };
	    
	    
	    
 }])