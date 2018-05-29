var app = angular.module("demo", []);

app.controller("ConcertHallCtrl", function($scope, $http){
    var idToUpdate;
    var nameRegEx = /^(Майданчик|Площадка){1}\s".+"$/;
    var addressRegEx = /^(вул.|бульвар|проспект|площа){1}\s./;

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
                method: 'POST',
                url: '/api/concerthall/create',
                data: {
                    name: name,
                    address: address,
                    capacity: capacity
                }
            };

            var time = performance.now();
            $http(createRequest).then(function (response) {
                time = performance.now() - time;
                console.log("Створення відбулося за " + time + " мс.");
                console.log(response);
                window.location.reload();
            });
        }
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
                url: '/api/concerthall/update?id=' + idToUpdate,
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

        $http.get('/api/concerthall/findAllByCapacityGreaterThanEqual?capacity=' + capacity).then(function(response){
            $scope.concertHalls = response.data;
        });
    }
});



