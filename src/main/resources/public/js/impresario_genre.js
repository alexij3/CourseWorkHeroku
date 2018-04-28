var app = angular.module("demo", []);

app.controller("ImpresarioGenreCtrl", function($scope, $http) {
    var impresarioId;
    var impresarioName;
    var delGenres = [];
    var genres = [];

    $scope.impresarios = [];
    $http.get('/api/impresario/showall').then(function (response) {
        $scope.impresarios = response.data;
    });

    this.addGenre = function addGenre(){
        genres = $scope.selectedGenres;
        var request = {
            method: 'PUT',
            url: '/api/impresario/update?id=' + impresarioId,
            data: {
                name : impresarioName,
                genreSet : genres
            }
        };

        $http(request).then(function(){
            window.location.reload();
        });
    };

    this.startAddGenre = function startAddGenre(id, name){
        impresarioId = id;
        impresarioName = name;
        document.getElementById('impresarioName').innerHTML = name;
    };

    this.startDeleteGenre = function startDeleteGenre(idImpresario, name, genresToDelete){
        impresarioId = idImpresario;
        impresarioName = name;
        document.getElementById('delImpresarioName').innerHTML = name;

        genres = genresToDelete;
        var select = document.getElementById('delSelectGenre');

        for (var i = 0; i < genres.length; i++) {
            var option = document.createElement("option");
            option.text = genres[i];
            option.value = genres[i];

            select.add(option);

            console.log(select);
        }
    };

    this.deleteGenre = function deleteGenre(){
        genres = $('#delSelectGenre').val();
        var request = {
            method: 'POST',
            url: '/api/impresario/deletegenre?impresarioId=' + impresarioId,
            data: {
                name : impresarioName,
                genreSet : genres
            }
        };

        $http(request).then(function(response){
            document.getElementById('delSelectGenre').options.length = 0;
            window.location.reload();
        });
    };

    function removeItems(selectBox){
        for (var i = selectBox.length-1; i >= 0; i--){
            selectBox.remove(i);
        }
    }

    this.onClose = function onClose(){
        removeItems(document.getElementById('delSelectGenre'));
    }
});



