app.controller("authori-Ctrl", function ($scope, $http, $location) {
    $scope.roles = [];
    $scope.admin = [];
    $scope.authories = [];

    $scope.initialize = function () {
        // load all roles
        $http.get("/rest/roles").then(resp => {
            $scope.roles = resp.data;
        })


        //   load staff and directors 

        $http.get("/rest/accounts?admin=true").then(resp => {
            $scope.admin = resp.data;
        })


        // load authori of staff and directors
        $http.get("/rest/authories?admin=true").then(resp=>{
            $scope.authories = resp.data;
        }).catch(error =>{
            $location.path("/unauthorized");
        })
    }

    $scope.authori_of = function(acc,role){
        if($scope.authories){
            return $scope.acc.find(ur=> ur.acc.username == acc.username && ur.roles.id == role.id);
        }
    }

    $scope.authori_changed = function(acc,role){
        var authority = $scope.authori_of(acc,role);
        if (authority) {
            
        }
    }


});