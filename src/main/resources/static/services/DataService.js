angular.module('StarterApp').service('DataService', function ($http, Network) {

	var _episodes = [];
	var _episodeDataForDetailsPage = null;

	this.setEpisodeDataForDetailsPage = function(data){
		_episodeDataForDetailsPage = data;
	}

	this.getEpisodeDataForDetailsPage = function(){
		return _episodeDataForDetailsPage;
	}

	this.getEpisodes = function(callback, forceRefresh){

		if(!forceRefresh && _episodes.length > 0){
			callback(_episodes);
		}

		Network.getService(CONSTANTS.get('PROD_GET_EPISODE'))
		.success(function (response){

			 if(response && response.length > 0)
			{
				_episodes = response;
				callback(_episodes);
			}
			else
			{
				callback(_episodes);
				$mdDialog.show(
						$mdDialog.alert()
						.clickOutsideToClose(true)
						.title(response.message)
						.ariaLabel('Alert')
						.ok('OK')
				);
			}
		})
		.error(function (response){
			callback(_episodes);
			$mdDialog.show(
					$mdDialog.alert()
					.clickOutsideToClose(true)
					.title(CONSTANTS.get('ERROR_IN_AGENT_API'))
					.ariaLabel('Alert')
					.ok('OK')
			);
		});
	}

	
});