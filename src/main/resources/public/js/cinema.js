var app = angular.module("demo", []);

app.controller("CinemaCtrl", function($scope, $http){
    var idToUpdate;
    var nameRegEx = /^(Кінопалац|Кінотеатр){1}\s".+"$/;
    var addressRegEx = /^(вул.|бульвар|проспект|площа){1}\s./;

    var time = performance.now();
    $scope.cinemas = [];
     $http.get('/api/cinema/showall').then(function (response){
         time = performance.now() - time;
         console.log("Виведення відбулося за " + time + " мс.");
        $scope.cinemas=response.data;
        console.log(response);
    });

    this.deleteCinema = function deleteCinema(id){
        var time = performance.now();
        $http.get('/api/cinema/delete?id=' + id).then(function(){
            time = performance.now() - time;
            console.log("Виадлення відбулося за " + time + " мс.");
            window.location.reload();
            console.log("deleted Cinema with id " + id);
        });
    };

    this.createCinema = function createCinema(){
        var name = document.getElementById('CinemaName').value;
        var address = document.getElementById('CinemaAddress').value;
        var screenSize = document.getElementById('CinemaScreenSize').value;

        var nameIsValid = true;
        var addressIsValid = true;
        var screenSizeIsValid = true;

        if (!name.match(nameRegEx)){
            document.getElementById("wrongName").innerHTML = "Некоректна назва!";
            nameIsValid = false;
        }else this.clearName();

        if (!address.match(addressRegEx)){
            document.getElementById("wrongAddress").innerHTML = "Некоректна адреса!";
            addressIsValid = false;
        }else this.clearAddress();

        if (screenSize < 1){
            screenSizeIsValid = false;
            document.getElementById("wrongSize").innerHTML = "Некоректний розмір екрану!";
        }else this.clearScreenSize();

        if (nameIsValid && addressIsValid && screenSizeIsValid) {
            var createRequest = {
                method: 'PUT',
                url: '/api/cinema/create',
                data: {
                    name: name,
                    address: address,
                    screenSize: screenSize
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

    this.startUpdateCinema = function startUpdateCinema(id, name, address, screenSize){
        document.getElementById('updateCinemaName').value = name;
        document.getElementById('updateCinemaAddress').value = address;
        document.getElementById('updateCinemaScreenSize').value = screenSize;

        idToUpdate = id;
    };

    this.updateCinema = function updateCinema(){
        var name = document.getElementById('updateCinemaName').value;
        var address = document.getElementById('updateCinemaAddress').value;
        var screenSize = document.getElementById('updateCinemaScreenSize').value;

        var nameIsValid = true;
        var addressIsValid = true;
        var screenSizeIsValid = true;

        if (!name.match(nameRegEx)){
            document.getElementById("editWrongName").innerHTML = "Некоректна назва!";
            nameIsValid = false;
        }else this.clearName();

        if (!address.match(addressRegEx)){
            document.getElementById("editWrongAddress").innerHTML = "Некоректна адреса!";
            addressIsValid = false;
        }else this.clearAddress();

        if (screenSize < 1){
            screenSizeIsValid = false;
            document.getElementById("editWrongSize").innerHTML = "Некоректний розмір екрану!";
        }else this.clearScreenSize();

        if (nameIsValid && addressIsValid && screenSizeIsValid) {
            var request = {
                method: 'POST',
                url: '/api/cinema/update?id=' + idToUpdate,
                data: {
                    name: name,
                    address: address,
                    screenSize: screenSize
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

    this.clearScreenSize = function clearScreenSize(){
        document.getElementById('wrongSize').innerHTML = "";
        document.getElementById('editWrongSize').innerHTML = "";
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

    this.selectByScreenSize = function selectByScreenSize(){
        var screenSize = document.getElementById('screenSize').value;

        $http.get('/api/cinema/findAllByScreenSizeGreaterThanEqual?size=' + screenSize).then(function(response){
           $scope.cinemas = response.data;
        });
    }
});



