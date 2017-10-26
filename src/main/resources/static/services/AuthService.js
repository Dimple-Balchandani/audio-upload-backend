angular.module('StarterApp').service('Auth', function($http, session, Network, Utility, $location, $window, $timeout) {

    this.logIn = function(credentials) {

        Utility.showLoader();
        return $http.post(CONSTANTS.get('PROD_LOGIN_DATA_JSON_API'), credentials)
            .success(function(response) {
                if (response.status == true) {
                    var responseObj = response.responseObject;
                    session.setId(responseObj.id);
                    session.setEmailId(responseObj.emailId);
                    session.setUserId(responseObj.userId);
                    session.setErrorMessage(response.message);
                }
                Utility.hideLoader();
            }).error(function() {
                Utility.hideLoader();
            });
    };

    this.logOut = function() {

        if (CONSTANTS.get('MOCK_JSON_RESPONSE') == true) {
            session.destroy();
            return true;
        } else {
            Utility.showLoader();
            return Network.postService(CONSTANTS.get('PROD_LOGOUT_JSON_API'))
                .success(function(response) {
                    session.destroy();
                    Utility.hideLoader();
                })
                .error(function(response) {
                    Utility.hideLoader();
                    $mdDialog.show(
                        $mdDialog.alert()
                        .clickOutsideToClose(true)
                        .title(CONSTANTS.get('ERROR_LOGOUT_MESSAGE'))
                        .ariaLabel('Alert')
                        .ok('OK')
                    );
                });
        }
    };
});