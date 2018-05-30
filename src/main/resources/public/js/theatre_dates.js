var app = angular.module("demo", []);

app.controller("TheatreCtrl", function($scope, $http){
    var idToUpdate;
    var nameRegEx = /^(Театр){1}\s".+"$/;
    var addressRegEx = /^(вул.|бульвар|проспект|площа){1}\s./;

    $("#selectDates").modal('show');

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
                url: '/api/theatre/create',
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
                url: '/api/theatre/update?id=' + idToUpdate,
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

    this.selectDates = function selectDates(){
        var firstDate = document.getElementById('firstDate').value;
        var secondDate = document.getElementById('secondDate').value;

        $http.get('/api/theatreperformance/findTheatresAndPerformancesDates?firstDate=' + firstDate + '&secondDate=' + secondDate).then(function(response){
            $scope.theatres = response.data;
        });
    }
});



