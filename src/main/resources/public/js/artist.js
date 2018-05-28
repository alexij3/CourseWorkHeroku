var app = angular.module("demo", []);

app.controller("ArtistCtrl", function($scope, $http){
    var idToUpdate;
    var nameValidationRegEx = /^([А-ЯІЇЄҐ]'?([а-яіїєґ](-[А-ЯІЇЄҐ]|')?)+[а-яіїєґ]*\s){2,}[А-ЯІЇЄҐ]'?[а-яіїєґ]{4,}$/;

    var time = performance.now();
    $scope.artists = [];
     $http.get('/api/artist/showall').then(function (response){
         time = performance.now() - time;
         console.log("Виведення відбулося за " + time + " мс.");
        $scope.artists=response.data;
        console.log(response);
    });

    this.deleteArtist = function deleteArtist(id){
        var time = performance.now();
        $http.get('/api/artist/delete?id=' + id).then(function(){
            time = performance.now() - time;
            console.log("Видалення відбулося за " + time + " мс.");
            window.alert("Видалено артиста з ІД " + id);
            window.location.reload();
        });
    };

    this.createArtist = function createArtist(){
        console.log("In createartist()");
        var name = document.getElementById('artistName').value;
        if (!name.match(nameValidationRegEx)){
            document.getElementById("wrongName").innerHTML = "Некоректне ім'я!";
        }else {
            var createRequest = {
                method: 'PUT',
                url: '/api/artist/create',
                data: {
                    name: name
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

    this.startUpdateArtist = function startUpdateArtist(id, name){
        document.getElementById('updateArtistName').value = name;
        idToUpdate = id;
    };

    this.updateArtist = function updateArtist(){
        var name = document.getElementById('updateArtistName').value;
        if (!name.match(nameValidationRegEx)){
            document.getElementById("editWrongName").innerHTML = "Некоректне ім'я!";
        }else {
            var request = {
                method: 'POST',
                url: '/api/artist/update?id=' + idToUpdate,
                data: {
                    name: name
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

    this.getArtist = function getArtist(id){
        $http.get('/api/artist/get?id=' + id);
    };

    /*
    *
    * ARTIST QUERIES
    *
    *                */


    this.selectByDontParticipate = function selectByDontParticipate(){
        var firstDate = document.getElementById('firstDate').value;
        var secondDate = document.getElementById('secondDate').value;

        $http.get('/api/artist/findAllByContestDateNotBetween?firstDate=' + firstDate + '&secondDate=' + secondDate).then(function(response){
            $scope.artists = response.data;
        });
    }

});



