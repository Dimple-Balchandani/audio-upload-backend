var app = angular.module('StarterApp', ['ui.router', 'ngMaterial', 'ngAudio']);

app.config(['$stateProvider', '$urlRouterProvider', '$mdDateLocaleProvider', function($stateProvider, $urlRouterProvider, $mdDateLocaleProvider) {


	$mdDateLocaleProvider.formatDate = function(date) {
		return date ? moment(date).format('DD-MM-YYYY') : '';
	};

	$stateProvider
	.state('index', {
		url: '/index',
		templateUrl: 'Login/loginView.html'
	})

	.state('home', {
		url: '/home',
		templateUrl: 'Home/homeView.html',
		controller: 'AddSnippetCtrl'
	})


	.state('episode', {
		url: '/episode',
		templateUrl: 'Episode/episode.html',
		controller: 'EpisodeCtrl'
	})

	

	$urlRouterProvider.otherwise('/home');
}]);

