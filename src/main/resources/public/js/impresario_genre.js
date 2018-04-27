var app = angular.module("demo", []);

app.controller("ImpresarioGenreCtrl", function($scope, $http) {
    var impresarioId;
    var oldGenre;
    var genres = [];

    $scope.impresarios = [];
    $http.get('/api/impresariogenre/showgenres').then(function (response) {
        $scope.impresarios = response.data;

    });


    $http.get('/api/impresario/showall').then(function(response){
        var impresarios = response.data;
        var select = document.getElementById('selectedImpresario');
        for (var i = 0; i < impresarios.length; i++){
            var option = document.createElement("option");
            option.text = impresarios[i].name;
            option.value = impresarios[i].id;

            select.add(option);
        }
    });



    this.addGenre = function addGenre(){
        impresarioId = document.getElementById('selectedImpresario').value;
        genres = $scope.selectedGenres;
        for (var i = 0; i < genres.length; i++){
            var request = {
                method: 'PUT',
                url: '/api/impresariogenre/insertgenre?id=' + impresarioId,
                data: {
                    genre : genres[i]
                }
            };

            $http(request).then(function(){
                window.location.reload();
            });
        }
    };

    this.startUpdateGenres = function startUpdateGenres(id, name, genre){
        impresarioId = id;
        oldGenre = genre;
        document.getElementById('updLabelImpresario').innerHTML = name;
        document.getElementById('selectedGenre').value = genre;

    };

    this.updateGenre = function updateGenre(){
        var genre = document.getElementById('selectGenre').value;
        var request = {
            method: 'PUT',
            url: '/api/impresariogenre/updategenre?oldGenre=' + oldGenre,
            data: {
                impresarioId : impresarioId,
                genre : genre
            }
        };

        $http(request).then(function(){
            window.location.reload();
        });
    };

    this.deleteGenre = function deleteGenre(impresarioId, genreName){
        var request = {
            method: 'POST',
            url: '/api/impresariogenre/deletegenre?id=' + impresarioId,
            data: {
                impresario : null,
                genre : genreName
            }
        };

        $http(request).then(function(response){
            window.location.reload();
        });
    }
});



