angular.module('StarterApp').service('Network', function ($http) {

	$http.defaults.headers.common['Authorization'] = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTQ5NjEyMjgyMn0.tnTcaI9q3DqXEOSyZSOup65oWGlJ2qKpM2bZeTsXpjsuZDS7mc-mVaZ9o8cTyXOMUXtH5jmrn0abRqExi-jFXw"
	$http.defaults.headers.common['Access-Control-Allow-Headers'] = "*";

	this.getService = function (apiPath) {
		//console.log("GET API PATH :"+apiPath);
		
		return $http.get(apiPath)
		.success(function (response) {
			//console.log("GET API SUCCESS RESPONSE :"+JSON.stringify(response));
			return response;	
		}).error(function (response) {
			//console.log("GET API ERROR RESPONSE :"+JSON.stringify(response));
			return response;	
		});
	}
	
	this.postService = function (apiPath, data) {
		//console.log("POST API PATH :"+apiPath);
		//console.log("POST API DATA :"+JSON.stringify(data));
		
		return $http.post(apiPath, JSON.stringify(data))
		.success(function (response) {
			//console.log("POST API SUCCESS RESPONSE :"+JSON.stringify(response));
			return response;	
		}).error(function (response) {
			//console.log("POST API ERROR RESPONSE :"+JSON.stringify(response));
			return response;	
		});
	}
	
	this.putService = function (apiPath, data) {

		//console.log("PUT API PATH :"+apiPath);
		//console.log("PUT API DATA :"+JSON.stringify(data));
		
		return $http.put(apiPath, data)
		.success(function (response) {
			//console.log("PUT API SUCCESS RESPONSE :"+JSON.stringify(response));
			return response;	
		}).error(function (response) {
			//console.log("PUT API ERROR RESPONSE :"+JSON.stringify(response));
			return response;	
		});
	}
	
	this.deleteService = function (apiPath) {
		
		//console.log("API PATH :"+apiPath);

		return $http.delete(apiPath)
		.success(function (response) {
			//console.log("DELETE API SUCCESS RESPONSE :"+JSON.stringify(response));
			return response;	
		}).error(function (response) {
			//console.log("DELETE API ERROR RESPONSE :"+JSON.stringify(response));
			return response;	
		});
	}
	
	this.uploadAttachment = function (apiPath, data) {

		//console.log("POST API PATH :"+apiPath);
		//console.log("POST API DATA :"+JSON.stringify(data));
		
		return $http.post(apiPath, data, {
			transformRequest: angular.identity,
			headers: {'Content-Type': undefined}
		})
		.success(function(response){
			return response;
		})
		.error(function(response){
			return response;	
		});
	}

});