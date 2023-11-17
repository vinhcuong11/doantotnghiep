
app.controller("productCtrl", function ($scope, $http) {
    $scope.items = [];
    $scope.cates = [];
    $scope.form = {};

    $scope.initialize = function () {
        $http.get("/rest/products/").then(reps => {
            $scope.items = reps.data;
            console.log($scope.items);
            $scope.items.forEach(item => {
                item.createdate = new Date(item.createdate);
            })

        });
    }



    $http.get("/rest/categories").then(reps => {
        $scope.cates = reps.data;
    });


    $scope.reset = function () {
        $scope.form = {
            createdate: new Date(),
            image: ''
        };
    }
    $scope.edit = function (item) {
        $scope.form = angular.copy(item);

    }
    $scope.create = function () {
        var item = angular.copy($scope.form);
        $http.post('/rest/products/', item).then(reps => {
            reps.data.createdate = new Date();

            $scope.items.push(reps.data);
            alert("add success");
        }).catch(error => {
            alert("error add")
            console.log("Error", error);
        });
    }

    $scope.update = function () {
        var item = angular.copy($scope.form);
        $http.put(`/rest/products/${item.productid}`, item).then(reps => {
            var index = $scope.items.findIndex(p => p.productid == item.productid);
            reps.data.createdate = new Date(reps.data.createdate);
            reps.data.createdate = new Date(reps.data.createdate).getTime;
            $scope.items[index] = item;
            alert("update success");
        }).catch(error => {
            alert("error update")
            console.log("Error", error);
        });
    }

    $scope.delete = function (item) {
        var checkDelete = confirm("Are You really delete");
        if (checkDelete == true) {
            var item = angular.copy($scope.form);
            $http.delete(`/rest/products/${item.productid}`).then(reps => {
                var index = $scope.items.findIndex(p => p.productid == item.productid);
                $scope.items.splice(index, 1);
                $scope.reset();


            }).catch(error => {
                alert("error delete")
                console.log("Error", error);
            });
        } else {

        }

    }


    // Upload hình
    $scope.imageChanged = function (files) {
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/images', data, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(resp => {
            $scope.form.image = resp.data.name;
        }).catch(error => {
            alert("Lỗi tải ảnh");
            console.log("Error", error);
        })
    }
    $scope.initialize();

})