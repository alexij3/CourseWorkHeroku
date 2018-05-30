var app = angular.module("demo", []);

app.controller("CulturePalaceCtrl", function($scope, $http){
    var idToUpdate;
    var nameRegEx = /^(Палац|Культурний центр){1}\s".+"$/;
    var addressRegEx = /^(вул.|бульвар|проспект|площа){1}\s./;

    $("#selectDates").modal('show');

    $scope.culturePalaces = [];

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

        var nameIsValid = true;
        var addressIsValid = true;
        var capacityIsValid = true;

        if (!name.match(nameRegEx)){
            document.getElementById("wrongName").innerHTML = "Некоректна назва!";
            nameIsValid = false;
        }else this.clearName();

        if (!address.match(addressRegEx)){
            document.getElementById("wrongAddress").innerHTML = "Некоректна адреса!";
            addressIsValid = false;
        }else this.clearAddress();

        if (capacity < 1){
            capacityIsValid = false;
            document.getElementById("wrongCapacity").innerHTML = "Некоректна місткість!";
        }else this.clearCapacity();

        if (nameIsValid && addressIsValid && capacityIsValid) {
            var createRequest = {
                method: 'PUT',
                url: '/api/culturepalace/create',
                data: {
                    name: name,
                    address: address,
                    capacity: capacity
                }
            };

            var time = performance.now();
            $http(createRequest).then(function () {
                time = performance.now() - time;
                console.log("Створення відбулося за " + time + " мс.");
                window.location.reload();
            });
        }
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

        var nameIsValid = true;
        var addressIsValid = true;
        var capacityIsValid = true;

        if (!name.match(nameRegEx)){
            document.getElementById("editWrongName").innerHTML = "Некоректна назва!";
            nameIsValid = false;
        }else this.clearName();

        if (!address.match(addressRegEx)){
            document.getElementById("editWrongAddress").innerHTML = "Некоректна адреса!";
            addressIsValid = false;
        }else this.clearAddress();

        if (capacity < 1){
            capacityIsValid = false;
            document.getElementById("editWrongCapacity").innerHTML = "Некоректна місткість!";
        }else this.clearCapacity();

        if (nameIsValid && addressIsValid && capacityIsValid) {
            var request = {
                method: 'POST',
                url: '/api/culturepalace/update?id=' + idToUpdate,
                data: {
                    name: name,
                    address: address,
                    capacity: capacity
                }
            };

            var time = performance.now();
            $http(request).then(function (response) {
                time = performance.now() - time;
                console.log("Оновлення відбулося за " + time + " мс.");
                console.log(response);
                window.location.reload();
            });
        }
    };

    this.clearName = function clearName(){
        document.getElementById('wrongName').innerHTML = "";
        document.getElementById('editWrongName').innerHTML = "";
    };

    this.clearAddress = function clearAddress(){
        document.getElementById('wrongAddress').innerHTML = "";
        document.getElementById('editWrongAddress').innerHTML = "";
    };

    this.clearCapacity = function clearCapacity(){
        document.getElementById('wrongCapacity').innerHTML = "";
        document.getElementById('editWrongCapacity').innerHTML = "";
    };

    /*******************************
     *
     *
     *
     ********* QUERIES *********
     *
     *
     *
     *****************************/

    this.showByCapacity = function showByCapacity(){
        var capacity = document.getElementById('capacity').value;

        $http.get('/api/culturepalace/findAllByCapacityGreaterThanEqual?capacity=' + capacity).then(function(response){
            $scope.culturePalaces = response.data;
        });
    };

    this.selectDates = function selectDates(){
        var firstDate = document.getElementById('firstDate').value;
        var secondDate = document.getElementById('secondDate').value;

        $http.get('/api/contestinpalace/findPalacesAndContestsDates?firstDate=' + firstDate + '&secondDate=' + secondDate).then(function(response){
            $scope.culturePalaces = response.data;
        });
    }
});



