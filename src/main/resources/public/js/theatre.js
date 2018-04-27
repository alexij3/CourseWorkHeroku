var app = angular.module("demo", []);

app.controller("TheatreCtrl", function($scope, $http){

    var idToUpdate;

    $scope.theatres = [];
     $http.get('/api/theatre/showAll').then(function (response){
        $scope.theatres=response.data;
        console.log(response);
    });

    this.deleteTheatre = function deleteTheatre(id){
        $http.get('/api/theatre/delete?id=' + id).then(function(){
            window.location.reload();
            console.log("deleted theatre with id " + id);
        });
    };

    this.createTheatre = function createTheatre(){
        var name = document.getElementById('TheatreName').value;
        var address = document.getElementById('TheatreAddress').value;
        var capacity = document.getElementById('TheatreCapacity').value;

        var createRequest ={
            method: 'POST',
            url: '/api/theatre/create',
            data: {
                name : name,
                address : address,
                capacity : capacity
            }
        };

        $http(createRequest).then(function(){
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

        $http(request).then(function (response){
            window.location.reload();
            console.log(response);
        })
    }
});



