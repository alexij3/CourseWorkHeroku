var app = angular.module("demo", []);

app.controller("TheatreCtrl", function($scope, $http){

    var idToUpdate;

    var time = performance.now();
    $scope.theatres = [];
     $http.get('/api/theatre/showAll').then(function (response){
         time = performance.now() - time;
         console.log("Виведення відбулося за " + time + " мс.");
        $scope.theatres=response.data;
        console.log(response);
    });

    this.deleteTheatre = function deleteTheatre(id){
        var time = performance.now();
        $http.get('/api/theatre/delete?id=' + id).then(function(){
            time = performance.now() - time;
            console.log("Видалення відбулося за " + time + " мс.");
            console.log("deleted theatre with id " + id);
            window.location.reload();

        });
    };

    this.createTheatre = function createTheatre(){
        var name = document.getElementById('TheatreName').value;
        var address = document.getElementById('TheatreAddress').value;
        var capacity = document.getElementById('TheatreCapacity').value;

        var createRequest ={
            method: 'PUT',
            url: '/api/theatre/create',
            data: {
                name : name,
                address : address,
                capacity : capacity
            }
        };

        var time = performance.now();
        $http(createRequest).then(function(){
            time = performance.now() - time;
            console.log("Створення відбулося за " + time + " мс.");
            window.location.reload();
        });
    };

    this.startUpdateTheatre = function startUpdateTheatre(id, name, address, capacity){
        document.getElementById('updateTheatreName').value = name;
        document.getElementById('updateTheatreAddress').value = address;
        document.getElementById('updateTheatreCapacity').value = capacity;

        idToUpdate = id;
    };

    this.updateTheatre = function updateTheatre(){
        var name = document.getElementById('updateTheatreName').value;
        var address = document.getElementById('updateTheatreAddress').value;
        var capacity = document.getElementById('updateTheatreCapacity').value;

        var request = {
            method: 'POST',
            url : '/api/theatre/update?id=' + idToUpdate,
            data: {
                name : name,
                address : address,
                capacity : capacity
            }
        };

        var time = performance.now();
        $http(request).then(function (response){
            time = performance.now() - time;
            console.log("Оновлення відбулося за " + time + " мс.");
            console.log(response);
            window.location.reload();
        });
    }
});



