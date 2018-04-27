var app = angular.module("demo", []);

app.controller("ArtistGenreCtrl", function($scope, $http) {
    var artistId;
    var oldGenre;
    var genres = [];

    $scope.artists = [];
    $http.get('/api/artist/showall').then(function (response) {
        $scope.artists = response.data;
            var select = document.getElementById('selectedArtist');
            for (var i = 0; i < $scope.artists.length; i++){
                var option = document.createElement("option");
                option.text = $scope.artists[i].name;
                option.value = $scope.artists[i].id;

                select.add(option);
            }
        });


    this.addGenre = function addGenre(){
        artistId = document.getElementById('selectedArtist').value;
        var optionIndex = document.getElementById('selectedArtist').selectedIndex;
        var artistName = (document.getElementById('selectedArtist').options[optionIndex].text);
        genres = $scope.selectedGenres;
            var request = {
                method: 'PUT',
                url: '/api/artist/update?id=' + artistId,
                data: {
                    name : artistName,
                    genreSet : genres
                }
            };

            $http(request).then(function(){
                window.location.reload();
            });
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



