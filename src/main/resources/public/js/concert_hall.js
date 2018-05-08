var app = angular.module("demo", []);

app.controller("ConcertHallCtrl", function($scope, $http){

    var idToUpdate;

    var time = performance.now();
    $scope.concertHalls = [];
     $http.get('/api/concerthall/showAll').then(function (response){
         time = performance.now()-time;
         console.log("Виведення відбулося за " + time + " мс.");
        $scope.concertHalls=response.data;
        console.log(response);
    });

    this.deleteConcertHall = function deleteConcertHall(id){
        var time = performance.now();
        $http.get('/api/concerthall/delete?id=' + id).then(function(){
            time = performance.now()-time;
            console.log("Видалення відбулося за " + time + " мс.");
            window.location.reload();
            console.log("deleted concertHall with id " + id);
        });
    };

    this.createConcertHall = function createConcertHall(){
        var name = document.getElementById('ConcertHallName').value;
        var address = document.getElementById('ConcertHallAddress').value;
        var capacity = document.getElementById('ConcertHallCapacity').value;

        var createRequest ={
            method: 'POST',
            url: '/api/concerthall/create',
            data: {
                name : name,
                address : address,
                capacity : capacity
            }
        };

        var time = performance.now();
        $http(createRequest).then(function(response){
            time = performance.now()-time;
            console.log("Створення відбулося за " + time + " мс.");
            console.log(response);
            window.location.reload();
        });
    };

    this.startUpdateConcertHall = function startUpdateConcertHall(id, name, address, capacity){
        document.getElementById('updateConcertHallName').value = name;
        document.getElementById('updateConcertHallAddress').value = address;
        document.getElementById('updateConcertHallCapacity').value = capacity;

        idToUpdate = id;
    };

    this.updateConcertHall = function updateConcertHall(){
        var name = document.getElementById('updateConcertHallName').value;
        var address = document.getElementById('updateConcertHallAddress').value;
        var capacity = document.getElementById('updateConcertHallCapacity').value;

        var request = {
            method: 'POST',
            url : '/api/concerthall/update?id=' + idToUpdate,
            data: {
                name : name,
                address : address,
                capacity : capacity
            }
        };

        var time = performance.now();
        $http(request).then(function (response){
            time = performance.now()-time;
            console.log("Оновлення відбулося за " + time + " мс.");
            console.log(response);
            window.location.reload();
        });
    }
});



