var app = angular.module("demo", []);

app.controller("ArtistCtrl", function($scope, $http){
    var idToUpdate;
    var genres = [];

    $scope.artists = [];
     $http.get('/api/artist/showall').then(function (response){
        $scope.artists=response.data;
        console.log(response);
    });

    this.deleteArtist = function deleteArtist(id){
        $http.get('/api/artist/delete?id=' + id).then(function(){
            window.alert("Видалено артиста з ІД " + id);
            window.location.reload();
        });
    };

    this.createArtist = function createArtist(){
        console.log("In createartist()");
        var name = document.getElementById('artistName').value;
        var createRequest = {
            method: 'PUT',
            url: '/api/artist/create',
            data : {
                name : name
            }
        };

        $http(createRequest).then(function(response){
            console.log(response);
            window.location.reload();
        });
    };

    this.startUpdateArtist = function startUpdateArtist(id, name){
        document.getElementById('updateArtistName').value = name;
        idToUpdate = id;
    };

    this.updateArtist = function updateArtist(){
        var name = document.getElementById('updateArtistName').value;
        var request = {
            method: 'POST',
            url : '/api/artist/update?id=' + idToUpdate,
            data: {
                name : name
            }
        };

        $http(request).then(function (response){
            console.log(response);
        });

        window.location.reload();
    };

    this.getArtist = function getArtist(id){
        $http.get('/api/artist/get?id=' + id);
    }
});



