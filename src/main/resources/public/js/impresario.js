var app = angular.module("demo", []);

app.controller("ImpresarioCtrl", function($scope, $http){
    var idToUpdate;

    var time = performance.now();
    $scope.impresarios = [];
     $http.get('/api/impresario/showall').then(function (response){
         time = performance.now() - time;
         console.log("Виведення відбулося за " + time + " мс.");
        $scope.impresarios=response.data;
        console.log(response);
    });

    $http.get('/api/artist/showall').then(function(response){
        var artists = response.data;
        var select = document.getElementById('selectByArtistArtists');

        for (var i = 0; i < artists.length; i++) {
            var option = document.createElement("option");
            option.text = artists[i].name;
            option.value = artists[i].id;

            select.add(option);

            console.log(select);
        }
    });

    this.deleteImpresario = function deleteImpresario(id){
        var time = performance.now();
        $http.get('/api/impresario/delete?id=' + id).then(function(){
            time = performance.now() - time;
            console.log("Видалення відбулося за " + time + " мс.");
            window.location.reload();
            console.log("deleted impresario with id " + id);
        });
    };

    this.createImpresario = function createImpresario(){
        var name = document.getElementById('ImpresarioName').value;
        var time = performance.now();
        $http.put('/api/impresario/create?name=' + name).then(function(){
            time = performance.now() - time;
            console.log("Створення відбулося за " + time + " мс.");
            window.location.reload();
        });
    };

    this.startUpdateImpresario = function startUpdateImpresario(id, name){
        document.getElementById('updateImpresarioName').value = name;
        idToUpdate = id;
    };

    this.updateImpresario = function updateImpresario(){
        var name = document.getElementById('updateImpresarioName').value;
        var request = {
            method: 'POST',
            url : '/api/impresario/update?id=' + idToUpdate,
            data: {
                name : name
            }
        };

        var time = performance.now();
        $http(request).then(function (response){
            time = performance.now() - time;
            console.log("Оновлення відбулося за " + time + " мс.");
            window.location.reload();
            console.log(response);
        });
    };

    /**
     *
     *
     * QUERIES
     *
     *
     */

    this.showImpresariosByArtist = function showImpresariosByArtist(){
        var id = document.getElementById('selectByArtistArtists').value;


        $http.get('/api/artist/findArtistImpresarios?id=' + id).then(function (response){
            $scope.impresarios = response.data;
        });
    };

    // Список імпресаріо за вказаним жанром
    this.showImpresarioByGenre = function showImpresarioByGenre(){
        var genre = document.getElementById('genres').value;

        $http.get('/api/impresario/findAllByGenreSetContaining?genre=' + genre).then(function(response){
            $scope.impresarios = response.data;
        });
    }


});



