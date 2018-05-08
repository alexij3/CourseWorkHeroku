var app = angular.module("demo", []);

app.controller("ArtistGenreCtrl", function($scope, $http) {
    var artistId;
    var artistName;
    var delGenres = [];
    var genres = [];

    var time = performance.now();
    $scope.artists = [];
    $http.get('/api/artist/showall').then(function (response) {
        time = performance.now() - time;
        console.log("Виведення відбулося за " + time + " мс.");
        $scope.artists = response.data;
    });

    this.addGenre = function addGenre(){
        genres = $scope.selectedGenres;
        var request = {
            method: 'PUT',
            url: '/api/artist/updategenres?id=' + artistId,
            data: {
                name : artistName,
                genreSet : genres
            }
        };

        var time = performance.now();
        $http(request).then(function(){
            time = performance.now() - time;
            console.log("Створення відбулося за " + time + " мс.");
            window.location.reload();
        });
    };

    this.startAddGenre = function startAddGenre(id, name){
        artistId = id;
        artistName = name;
        document.getElementById('artistName').innerHTML = name;
    };

    this.startDeleteGenre = function startDeleteGenre(idArtist, name, genresToDelete){
        artistId = idArtist;
        artistName = name;
        document.getElementById('delArtistName').innerHTML = name;

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
            url: '/api/artist/deletegenre?artistId=' + artistId,
            data: {
                name : artistName,
                genreSet : genres
            }
        };

        var time = performance.now();
        $http(request).then(function(response){
            time = performance.now() - time;
            console.log("Видалення відбулося за " + time + " мс.");
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



