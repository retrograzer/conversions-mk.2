angular.module('app').controller('UserController', ['UserService','allUsers', function UserController(UserService, allUsers) {

	var ctrl = this;
	
	ctrl.users = getAllUsers.data;
	
	console.dir(ctrl.users);
	
}]);