(function() {

    var RegistrationController = function() {
        var model = this;

        // model.message = "";

        model.user = {
            username: "",
            password: "",
            confirmPassword: ""
        };

        model.submit = function(isValid) {
            if (isValid) {
                //model.message = "Submitted " + model.user.username;
            } else {
                // model.message = "There are still invalid fields below";
            }
        };

    };

    var compareTo = function() {
        return {
            require: "ngModel",
            scope: {
                otherModelValue: "=compareTo"
            },
            link: function(scope, element, attributes, ngModel) {

                ngModel.$validators.compareTo = function(modelValue) {
                    return modelValue == scope.otherModelValue;
                };

                scope.$watch("otherModelValue", function() {
                    ngModel.$validate();
                });
            }
        };
    };

    storeApp.directive("compareTo", compareTo);
    storeApp.controller("RegistrationController", RegistrationController);

}());
