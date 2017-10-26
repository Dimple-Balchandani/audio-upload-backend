function LoginDialogController($scope, $mdDialog, $location, Auth, session, Utility, $timeout) {

    $scope.login = CONSTANTS.get('LOG_IN');
    $scope.cancel = CONSTANTS.get('CANCEL');
    $scope.errorMessage = "";


    $scope.hide = function() {
        $mdDialog.cancel();
    };

    $scope.submit = function() {

        if ($scope.username && $scope.userpassword) {

            Utility.showLoader();
            Auth.logIn({
                    username: $scope.username,
                    password: $scope.userpassword
                })
                .success(function() {
                    Utility.hideLoader();
                    if (session.getErrorMessage() != "Successfully logged in!")
                        $scope.errorMessage = CONSTANTS.get('ERROR_LOGIN_MESSAGE');
                    else {
                        $scope.errorMessage = "";
                        $scope.username = "";
                        $scope.userpassword = "";
                        $mdDialog.hide();
                        $location.path('/home');
                    }
                })
                .error(function() {
                    Utility.hideLoader();
                    $scope.errorMessage = CONSTANTS.get('ERROR_LOGIN_MESSAGE');
                });
        } else {
            $scope.errorMessage = CONSTANTS.get('ERROR_LOGIN_BLANK_MESSAGE');
        }
    }
}