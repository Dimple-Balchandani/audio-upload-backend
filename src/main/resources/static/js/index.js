app.controller('AppCtrl', ['$scope', '$mdBottomSheet', '$mdSidenav', '$mdDialog', '$location', '$state', function($scope, $mdBottomSheet, $mdSidenav, $mdDialog, $location, $state) {

//	var token = session.getUserId();
//	$scope.isLoggedin = false;
//	if(token == 'null' || token == null || token == "" || token == 'undefined' || token == undefined) {
//		$location.path('/index');
//		$scope.isLoggedin = false;
//		$mdDialog.show({
//			controller: LoginDialogController,
//			templateUrl: "app/Login/loginDialog.html",
//			parent: angular.element(document.body),
//			clickOutsideToClose: true
//		}).then(function() {}, function() {});
//	} else {
//		console.info("User Already Logged In");
//		$location.path('/home');
//		$scope.isLoggedin = true;
//	}
//	
//	$scope.logOut = function(ev) {
//		session.destroy();
//		$location.path('/index');
//	}

$scope.menuList = [{
		"title": "Snippet",
		"detailType": "snippet",
		"icon":"",
		"action":"home"
	},
	{
		"title": "Episode",
		"detailType": "Episode",
		"icon":"",
		"action":"episode"
	},
	{
		"title": "Add Episode",
		"detailType": "Add Episode",
		"icon":"",
		"action":"addepisode"
	}
	];


	$scope.navigateTo = function(path) {
		$state.go(path);
	}

	$scope.alert = function(message){
		$mdDialog.show(
					$mdDialog.alert()
					.clickOutsideToClose(true)
					.title(message)
					.ariaLabel('Alert')
					.ok('OK')
			);
	}

}]);