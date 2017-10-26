angular.module('StarterApp').controller("EpisodeCtrl", function ($scope, $state, $mdDialog, $http, $timeout, ngAudio, DataService) {

	$scope.episodes = [];
	
	DataService.getEpisodes(function(_episodes){
		$timeout(function(){
			$scope.episodes = _episodes;	
		})
	}, true);

	$scope.episodeDetails = function(episode){
		DataService.setEpisodeDataForDetailsPage(episode);
		$state.go("addepisode");
	}
});