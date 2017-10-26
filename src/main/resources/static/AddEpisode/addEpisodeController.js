angular.module('StarterApp').controller("AddEpisodeCtrl", function ($scope, $mdDialog, $http, $state, $timeout, ngAudio, DataService, Network) {

	$scope.detailsMode = false;
	$scope.isEditingDisabled = false;
	$scope.data = {
		"episodeDesc": "",
	  	"episodeHours": 0,
	  	"episodeIdentifier": "",
	  	"episodeMin": 0,
	  	"episodeName": "",
	  	"episodeS3Link": "",
	  	"episodeSec": 0,
	  	"syntlkersNames":[],
	  	"releaseDate":new Date()
	}


	$scope.pageTitle = "Create New Episode";

	var detailsData = DataService.getEpisodeDataForDetailsPage();
	if(detailsData != null){
		$scope.detailsMode = true;
		$scope.pageTitle = "Episode details";
		$scope.isEditingDisabled = true;

		$scope.data = detailsData;
		if($scope.data.syntlkers){
			$scope.data.syntlkersNames = $scope.data.syntlkers.split(",");
		}
		else{
			$scope.data.syntlkersNames = [];	
		}

		if($scope.data.releaseDate){
			$scope.data.releaseDate = new Date($scope.data.releaseDate);
		}
	}


	$scope.submitData =function(){

		//validate
		if($scope.data.episodeName == ""){
			$scope.alert("Please fill episode name");
			return;
		}

		if($scope.data.episodeIdentifier == ""){
			$scope.alert("Please fill episode identifier");
			return;
		}

		if($scope.data.episodeS3Link == ""){
			$scope.alert("Please fill episode s3 link");
			return;
		}


		// if($scope.data.episodeDesc == ""){
		// 	$scope.alert("Please fill episode description");
		// 	return;
		// }


		$scope.data.syntlkers = $scope.data.syntlkersNames.join();

		var finalData = JSON.parse(JSON.stringify($scope.data));
		delete finalData['syntlkersNames'];

		//console.log("Data", JSON.stringify(finalData));


		if($scope.detailsMode){
			Network.putService(CONSTANTS.get('PROD_EDIT_EPISODE')+$scope.data.episodeIdentifier, finalData)
			.success(function (response){

				//console.log("Data", response);
				if(response.message == CONSTANTS.get('SUCCESS'))
				{
					$scope.alert("Successfully updated the episode");
					$state.go("episode");
				}
				else
				{
					$scope.alert("Error in updating Episode");
				}
			})
			.error(function (response){
				$scope.alert("Error in updating Episode:");
				console.error(response);
			});



		}
		else{
			Network.postService(CONSTANTS.get('PROD_ADD_EPISODE'), finalData)
				.success(function (response){

					//console.log("Data", response);
					if(response.message == CONSTANTS.get('SUCCESS'))
					{
						$scope.alert("Successfully added the episode");
						$state.go("episode");
					}
					else
					{
						$scope.alert("Error in creating Episode");
					}
				})
				.error(function (response){
					$scope.alert("Error in creating Episode:");
					console.error(response);
				});


		}

	}

});