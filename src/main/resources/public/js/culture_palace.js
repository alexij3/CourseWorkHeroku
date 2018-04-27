var app = angular.module("demo", []);

app.controller("CulturePalaceCtrl", function($scope, $http){
    var idToUpdate;

    $scope.culturePalaces = [];
     $http.get('/api/culturepalace/showAll').then(function (response){
        $scope.culturePalaces=response.data;
        console.log(response);
    });

    this.deleteCulturePalace = function deleteCulturePalace(id){
        $http.get('/api/culturepalace/delete?id=' + id).then(function(){
            window.location.reload();
            console.log("deleted culturePalace with id " + id);
        });
    };

    this.createCulturePalace = function createCulturePalace(){
        var name = document.getElementById('CulturePalaceName').value;
        var address = document.getElementById('CulturePalaceAddress').value;
        var capacity = document.getElementById('CulturePalaceCapacity').value;

        var createRequest ={
            method: 'POST',
            url: '/api/culturepalace/create',
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

    this.startUpdateCulturePalace = function startUpdateCulturePalace(id, name, address, capacity){
        document.getElementById('updateCulturePalaceName').value = name;
        document.getElementById('updateCulturePalaceAddress').value = address;
        document.getElementById('updateCulturePalaceCapacity').value = capacity;

        idToUpdate = id;
    };

    this.updateCulturePalace = function updateCulturePalace(){
        var name = document.getElementById('updateCulturePalaceName').value;
        var address = document.getElementById('updateCulturePalaceAddress').value;
        var capacity = document.getElementById('updateCulturePalaceCapacity').value;

        var request = {
            method: 'POST',
            url : '/api/culturepalace/update?id=' + idToUpdate,
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



