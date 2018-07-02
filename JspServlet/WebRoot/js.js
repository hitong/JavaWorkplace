var app = angular.module('myApp', ['ngAnimate']);
app.controller('personCtrl', function($scope,$timeout,$http) {
    $scope.userName = "";
    $scope.userPassWord = "";
    $scope.yanzheng = function () {
        $http.get("http://www.runoob.com/try/angularjs/data/sites.php")
        .then(function (response) {$scope.names = response.data.sites;alert($scope.names[0].Name);});
        alert($scope.names[0].Name);
    }
});

function MessageObj(number,name,col,pro,gra,c,age) {
    this.number = number;
    this.name = name;
    this.col = col;
    this.pro = pro;
    this.gra = gra;
    this.c = c;
    this.age = age;
    this.check = false;
}
