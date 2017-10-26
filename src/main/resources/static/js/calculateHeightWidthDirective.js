angular.module('StarterApp').directive('calculateDataContainerHeight', [ '$timeout', function($timeout) {
	return {
		restrict : 'A',
		link : function($scope, iElement, iAttrs) {

			var adjustHeight = function() {
				resetHeight();
				$scope.viewContainerHeight = (parseInt($(".main-container").height()) - parseInt($(".header-container").height()) - parseInt($(".footer-container").height())) + "px";
				$(".data-div-container").css("height",$scope.viewContainerHeight);
			}

			var resetHeight = function() {
				iElement.css("height", "");
			}

			$scope.$watch("viewContainerHeight",function(newVal, oldVal) {
				adjustHeight();
			});

			$(window).on('resize', function() {
				$timeout(function() {
					resetHeight();
					adjustHeight();
				}, 100);
			});
		}
	};
} ]);

angular.module('StarterApp').directive('calculateDataContainerWidth', [ '$timeout', function($timeout) {
	return {
		restrict : 'A',
		link : function($scope, iElement, iAttrs) {

			var adjustWidth = function() {
				resetWidth();
				$scope.dataContainerWidth = parseInt($(".main-container").width()) +"px";
				$(".data-content-wrapper").css("width",$scope.dataContainerWidth);
			}

			var resetWidth = function() {
				iElement.css("width", "");
			}

			$scope.$watch("dataContainerWidth",function(newVal, oldVal) {
				adjustWidth();
			});

			$(window).on('resize', function() {
				$timeout(function() {
					resetWidth();
					adjustWidth();
				}, 100);
			});
		}
	};
} ]);


angular.module('StarterApp').directive("myAudioTimeElapsed", function(){
	return function(scope, element, attrs){
		element.bind("timeupdate", function(){
			scope.timeElapsed = element[0].currentTime;
			scope.$apply();
		});
	}
});

