angular.module('myapp', []).controller('myctrl', function ($scope) {
    $scope.items = [

        {
            name: 'Nuoc ngot',
            price: 10000
        },
        {
            name: 'Cafe',
            price: 8000
        },
        {
            name: 'Bim Bim',
            price: 5000
        },
        {
            name: 'Thuoc la',
            price: 15000
        },
        {
            name: 'Nuoc',
            price: 1000
        }
    ]

    $scope.getAmount = function () {
        var amount = 0;
        $scope.items.forEach(element => {
            if (element.buy) {
                amount += element.price * element.quantity;
            }
        })

        return amount
    }
})