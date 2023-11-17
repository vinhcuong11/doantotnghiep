var app = angular.module("myapp", []);
app.controller("myctrl", function ($scope, $http) {

    $scope.cart = {
        items: [],

        add(id) {
            var item = this.items.find(item => item.productid == id);
            if (item) {
                item.qty++;
                this.saveToLocalStorage();
                alert("success add")
            } else {
                $http.get(`/rest/products/${id}`).then(resp => {
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                    alert("success add")
                })
            }


        },
        remove(id) {
            var index = this.items.findIndex(item => item.productid == id);
            var checkremove = confirm("bạn có chắc muốn xóa sp này ?")
            if (checkremove == true) {
                this.items.splice(index, 1);
                this.saveToLocalStorage();
            }

        },
        clear() {
            this.items=[]
            this.saveToLocalStorage();
        },
        get count() {
            return this.items
                .map(item => item.qty)
                .reduce((total, qty) => total += qty, 0);
        },
        get amount() {
            return this.items
                .map(item => item.qty * item.price)
                .reduce((total, qty) => total += qty, 0);
        },
        saveToLocalStorage() {
            var json = JSON.stringify(angular.copy(this.items))
            localStorage.setItem("cart", json);
        },
        loadFromLocalStorage() {
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];
        }
    }

    $scope.cart.loadFromLocalStorage();


    

    $scope.order = {
        createDate: new Date(),
        address: "",
        purchase() {
            alert("Đặt hàng thành công!")
        }
    }
})