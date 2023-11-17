app = angular.module("myshop", ["ngRoute"]);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/product', {
            templateUrl: '/assets/admin/product/listProduct.html',
            controller: 'productCtrl'
        })
        .when('/user', {
            templateUrl: '/assets/admin/authori/index.html',
            controller: 'authori-Ctrl'
        })
        .otherwise({ template: "<h1>Not Found 404</h1>" })
});
