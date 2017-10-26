var baseAPI = 'http://syntoy-env.us-east-1.elasticbeanstalk.com'

var CONSTANTS = (function() {
     var private = {
                        
           'PROD_LOGIN_DATA_JSON_API':baseAPI+'/airtel-genie/user/login'
           ,'PROD_RESET_PASSWORD_API':baseAPI+'/airtel-genie/user/resetPwd'
           ,'PROD_FORGOT_PASSWORD_API':baseAPI+'/airtel-genie/user/forgotPwd'
           ,'PROD_GET_EPISODE':baseAPI+'/episode/'
           ,'PROD_ADD_EPISODE':baseAPI+'/episode/add'
           ,'PROD_EDIT_EPISODE':baseAPI+'/episode/'           
           ,'SUCCESS':'success'

           , 'ERROR_LOGIN_BLANK_MESSAGE': 'Please fill all details first'
           , 'ERROR_LOGIN_MESSAGE': 'Incorrect Username or Password'
           , 'ERROR_LOGOUT_MESSAGE': 'Problem In LogOut.Please Refresh the page'
           , 'ERROR_PASSWORD_NOT_MATCH_MESSAGE': 'New & Confirm Password not matched'
     };

     return {
        get: function(name) { return private[name]; }
    };
})();

