var app = angular.module("demo", []);

app.controller("ConcertHallCtrl", function($scope, $http){

    var idToUpdate;

    $scope.concertHalls = [];
     $http.get('/api/concerthall/showAll').then(function (response){
        $scope.concertHalls=response.data;
        console.log(response);
    });

    this.deleteConcertHall = function deleteConcertHall(id){
        $http.get('/api/concerthall/delete?id=' + id).then(function(){
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

        $http(createRequest).success(
            console.log('created concertHall with name ' + name)
        ).then(function(){
            window.parent.location.reload();
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

        $http(request).then(function (response){
            console.log(response);
            window.location.reload();
        });

    }
});



