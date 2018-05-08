var app = angular.module("demo", []);

app.controller("CulturePalaceCtrl", function($scope, $http){
    var idToUpdate;

    var time = performance.now();
    $scope.culturePalaces = [];
     $http.get('/api/culturepalace/showAll').then(function (response){
         time = performance.now()-time;
         console.log("Виведення відбулося за " + time + " мс.");
        $scope.culturePalaces=response.data;
        console.log(response);
    });

    this.deleteCulturePalace = function deleteCulturePalace(id){
        var time = performance.now();
        $http.get('/api/culturepalace/delete?id=' + id).then(function(){
            time = performance.now()-time;
            console.log("Видалення відбулося за " + time + " мс.");
            window.location.reload();
            console.log("deleted culturePalace with id " + id);
        });
    };

    this.createCulturePalace = function createCulturePalace(){
        var name = document.getElementById('CulturePalaceName').value;
        var address = document.getElementById('CulturePalaceAddress').value;
        var capacity = document.getElementById('CulturePalaceCapacity').value;

        var createRequest ={
            method: 'PUT',
            url: '/api/culturepalace/create',
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

        var time = performance.now();
        $http(request).then(function (response){
            time = performance.now() - time;
            console.log("Оновлення відбулося за " + time + " мс.");
            console.log(response);
            window.location.reload();
        });
    }
});



