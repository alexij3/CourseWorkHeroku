var app = angular.module("demo", []);

app.controller("ArtistCtrl", function($scope, $http){
    var idToUpdate;
    var genres = [];

    $scope.artists = [];
    $http.get('/api/artist/findAllByHavingMoreThanOneGenre').then(function (response){
        $scope.artists = response.data;
    });
});



