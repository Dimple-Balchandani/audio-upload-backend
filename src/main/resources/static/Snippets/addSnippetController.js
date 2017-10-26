angular.module('StarterApp').controller("AddSnippetCtrl", function ($scope, $sce, $mdDialog, $http, $timeout, ngAudio, Network, DataService) {

	$scope.pageTitle = "Create New Snippet";
	$scope.detailsMode = false;
	$scope.isEditingDisabled = false;


	$scope.timeElapsed = 0;
	$scope.startTime = "00:00:00";
	$scope.endTime = "00:00:00";
	$scope.redColor = 0;
	$scope.greenColor = 0;
	$scope.blueColor = 0;

	$scope.hexCode = "";
	$scope.episodes = [];
	$scope.selectedEpisode = null;

	$scope.data = {
		snippetName:"",
		syntalkerName:""
	}


	DataService.getEpisodes(function(_episodes){
		$timeout(function(){
			$scope.episodes = _episodes;	
		})
	}, false);

	
	$scope.getS3Url = function(selectedEpisode){
		if(selectedEpisode == null){
			return "";
		}

		return "https://s3.amazonaws.com/syntoy-bucket/"+selectedEpisode.episodeS3Link;
		//return $sce.trustAsResourceUrl("https://s3.amazonaws.com/syntoy-bucket/"+selectedEpisode.episodeS3Link);
	}

	$scope.onSelectedItemChange = function(){
		console.log("updating url");
		
		//Reset
		$scope.data.snippetName = "";
		$scope.data.syntalkerName = "";
		$scope.startTime = "00:00:00";
		$scope.endTime = "00:00:00";
		document.getElementById('myAudio').src = $scope.getS3Url($scope.selectedEpisode);
	}

	$scope.loadGroupsData = function() {

		Network.getService("http://localhost:8080/Syntoy/group/")
		.success(function (response){

			if(response.length > 0) {

				$scope.groupList = response;
			}
			else
			{
				$mdDialog.show(
						$mdDialog.alert()
						.clickOutsideToClose(true)
						.title("No Data Found")
						.ariaLabel('Alert')
						.ok('OK')
				);
			}
		})
		.error(function (response){
			$mdDialog.show(
					$mdDialog.alert()
					.clickOutsideToClose(true)
					.title("Error in API")
					.ariaLabel('Alert')
					.ok('OK')
			);
		});
	}

	$scope.loadQuestionData = function() {

		Network.getService("/Syntoy/question/")
		.success(function (response){

			if(response.length > 0) {

				$scope.questionList = response;
			}
			else
			{
				$mdDialog.show(
						$mdDialog.alert()
						.clickOutsideToClose(true)
						.title("No Data Found")
						.ariaLabel('Alert')
						.ok('OK')
				);
			}
		})
		.error(function (response){
			$mdDialog.show(
					$mdDialog.alert()
					.clickOutsideToClose(true)
					.title("Error in API")
					.ariaLabel('Alert')
					.ok('OK')
			);
		});
	}

	$scope.getData = function() {

		var dataArray = [];

		for(var i = 0; i<=100;i++) {

			var obj = {
					id:i,
					value:i
			};

			dataArray.push(obj);
		}

		return dataArray;
	}

	$scope.dataArray = $scope.getData();


	$scope.getAudioUrl= function() {
		return $scope.selectedEpisode.audioUrl;
	};


	$scope.startSnippet = function() {
		$scope.startTime = $scope.formatSeconds(parseInt($scope.timeElapsed));
	}

	$scope.endSnippet = function() {
		$scope.endTime = $scope.formatSeconds(parseInt($scope.timeElapsed));
	}

	$scope.formatSeconds = function(secs){
		var date = new Date(null);
		date.setSeconds(secs); // specify value for SECONDS here
		return date.toISOString().substr(11, 8);
	}

	$scope.rgbToHex = function() {
		var r = Math.round($scope.redColor.value*2.55);
		var g = Math.round($scope.greenColor.value*2.55);
		var b = Math.round($scope.blueColor.value*2.55);

		var rgb = 'rgba('+r+', '+g+ ', '+b+', 1)';
		rgb = rgb.match(/^rgba?[\s+]?\([\s+]?(\d+)[\s+]?,[\s+]?(\d+)[\s+]?,[\s+]?(\d+)[\s+]?/i);
		$scope.hexCode =  (rgb && rgb.length === 4) ? "#" +
				("0" + parseInt(rgb[1],10).toString(16)).slice(-2) +
				("0" + parseInt(rgb[2],10).toString(16)).slice(-2) +
				("0" + parseInt(rgb[3],10).toString(16)).slice(-2) : '';
	}

	$scope.componentToHex = function(c) {
		var hex = c.toString(16);
		return hex.length == 1 ? "0" + hex : hex;
	}


	//Auto complete Search Client
	$scope.groupDetails= [
	                      {
	                    	  "id": 1,
	                    	  "groupName": "admin"
	                      },
	                      {
	                    	  "id": 2,
	                    	  "groupName": "Ujwala"
	                      },
	                      {
	                    	  "id": 80,
	                    	  "groupName": "Mandar123"
	                      },
	                      {
	                    	  "id": 3,
	                    	  "groupName": "Ranjana"
	                      },
	                      {
	                    	  "id": 4,
	                    	  "groupName": "Sandesh"
	                      },
	                      {
	                    	  "id": 5,
	                    	  "groupName": "Mandar"
	                      },
	                      {
	                    	  "id": 6,
	                    	  "groupName": "Deepali"
	                      },
	                      {
	                    	  "id": 7,
	                    	  "groupName": "Mandar1"
	                      },
	                      {
	                    	  "id": 8,
	                    	  "groupName": "Pramod"
	                      },
	                      {
	                    	  "id": 9,
	                    	  "groupName": "Mandar2"
	                      },
	                      {
	                    	  "id": 10,
	                    	  "groupName": "PRAMOD-1"
	                      }
	                      ];



	$scope.loadAllSavedGroup = function () {
		return $scope.groupDetails.map(function (repo) {
			repo.value = repo.groupName.toLowerCase();
			return repo;
		});
	}

	$scope.queryGroupSearch = function (query) {

		var results = query ? $scope.group.filter($scope.createFilterFor(query)) : $scope.group,
				deferred;
		if ($scope.simulateQuery) {
			deferred = $q.defer();
			$timeout(function () {
				deferred.resolve(results);
			}, Math.random() * 1000, false);
			return deferred.promise;
		} else {
			return results;
		}
	}


	$scope.searchGroupTextChange = function (text) {
	}

	$scope.createGroup = function (text) {

		//To Do: Integrate a create group API
	}

	$scope.deleteGroup = function (group) {

		//To Do: Integrate a delete group API
	}

	$scope.selectedGroupItemChange = function (item) {

		if(item != undefined)
		{
		}
		else
		{
		}
	}

	$scope.createFilterFor = function (query) {
		var lowercaseQuery = angular.lowercase(query);
		return function filterFn(item) {
			return (item.value.indexOf(lowercaseQuery) === 0);
		};
	}

	$scope.group = $scope.loadAllSavedGroup();

	$scope.searchGroupTextChange = $scope.searchGroupTextChange;
	$scope.selectedGroupItemChange = $scope.selectedGroupItemChange;
	$scope.queryGroupSearch = $scope.queryGroupSearch;	


	$scope.cancel = function() {

	}


	$scope.submit = function() {

	}


});
