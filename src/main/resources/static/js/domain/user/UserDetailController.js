angular.module('app').controller('UserDetailController', ['UserDetailService', '$routeParams', function(UserDetailService, $routeParams)
{
	
	var ctrl = this;
	
	UserDetailService.getUserDetails($routeParams.id).then(function(result){
		ctrl.user = result.data;
	});
	
	ctrl.availableRoles = ['admin', 'user', 'guest'];
	
	ctrl.roleSelected = function(role)
	{
		ctrl.user.role.role = role;
	}
	
}]);