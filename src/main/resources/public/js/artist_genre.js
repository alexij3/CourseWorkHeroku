var app = angular.module("demo", []);

app.controller("ArtistGenreCtrl", function($scope, $http) {
    var artistId;
    var oldGenre;
    var genres = [];

    $scope.artists = [];
    $http.get('/api/artistgenre/showgenres').then(function (response) {
        $scope.artists = response.data;
    });

    $http.get('/api/artist/showall').then(function(response){
        var artists = response.data;
        var select = document.getElementById('selectedArtist');
        for (var i = 0; i < artists.length; i++){
            var option = document.createElement("option");
            option.text = artists[i].name;
            option.value = artists[i].id;

            select.add(option);
        }
    });

    this.addGenre = function addGenre(){
        artistId = document.getElementById('selectedArtist').value;
        genres = $scope.selectedGenres;
        for (var i = 0; i < genres.length; i++){
            var request = {
                method: 'PUT',
                url: '/api/artistgenre/insertgenre?id=' + artistId,
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
        artistId = id;
        oldGenre = genre;
        document.getElementById('updLabelArtist').innerHTML = name;
        document.getElementById('selectedGenre').value = genre;

    };

    this.updateGenre = function updateGenre(){
        var genre = document.getElementById('selectGenre').value;
        var request = {
            method: 'PUT',
            url: '/api/artistgenre/updategenre?oldGenre=' + oldGenre,
            data: {
                artistId : artistId,
                genre : genre
            }
        };

        $http(request).then(function(){
            window.location.reload();
        });
    };

    this.deleteGenre = function deleteGenre(artistId, genreName){
        var request = {
            method: 'POST',
            url: '/api/artistgenre/deletegenre?id=' + artistId,
            data: {
                artist : null,
                genre : genreName
            }
        };

        $http(request).then(function(response){
            window.location.reload();
        });
    }
});



