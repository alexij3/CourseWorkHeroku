var app = angular.module("demo", []);

app.controller("ArtistImpresarioCtrl", function($scope, $http) {
    var artistId;
    var oldImpresarioId;
    var impresariosToAdd = [];

    $scope.artists = [];
    $http.get('/api/artistimpresario/showall').then(function(response){
       $scope.artists = response.data;

        $http.get('/api/artist/showall').then(function(response){
            var artists = response.data;
            var select = document.getElementById('selectArtist');
            for (var i = 0; i < artists.length; i++){
                var option = document.createElement("option");
                option.text = artists[i].name;
                option.value = artists[i].id;

                select.add(option);
            }

            $http.get('/api/impresario/showAll').then(function(response) {
                var impresarios = response.data;
                var select = document.getElementById('selectImpresarios');
                var select2 = document.getElementById('updSelectImpresarios');

                for (var i = 0; i < impresarios.length; i++) {
                    var option = document.createElement("option");
                    option.text = impresarios[i].name;
                    option.value = impresarios[i].id;

                    select.add(option);

                    console.log(select);
                }


                for (var j = 0; j < impresarios.length; j++) {
                    var option2 = document.createElement("option");
                    option2.text = impresarios[j].name;
                    option2.value = impresarios[j].id;

                    select2.add(option2);

                    console.log(select2);
                }

            });
        });
    });

    this.addImpresario = function addImpresario(){
        impresariosToAdd = $scope.selectedImpresarios;
        artistId = document.getElementById('selectArtist').value;
        for (var i = 0; i < impresariosToAdd.length; i++){
            var request = {
                method: 'PUT',
                url: '/api/artistimpresario/insert',
                data: {
                    artistId: artistId,
                    impresarioId : impresariosToAdd[i]
                }
            };

            $http(request).then(function(){
                window.location.reload();
            });
        }
    };

    this.startUpdateArtistImpresarios = function startUpdateArtistImpresarios(id, name, impresarioOldId){
        artistId = id;
        oldImpresarioId = impresarioOldId;
        document.getElementById('labelArtist').innerHTML = name;
        document.getElementById('updSelectImpresarios').value = impresarioOldId;
    };

    this.updateArtistImpresario = function updateArtistImpresario(){
        var impresarioId = document.getElementById('updSelectImpresarios').value;
        var request = {
            method: 'POST',
            url: '/api/artistimpresario/update?oldImpresarioId=' + oldImpresarioId,
            data: {
                artistId : artistId,
                impresarioId : impresarioId
            }
        };

        $http(request).then(function(){
            window.location.reload();
        });
    };

    this.deleteArtistImpresario = function deleteArtistImpresario(artistId, impresarioId){
        var request = {
            method: 'POST',
            url: '/api/artistimpresario/delete',
            data: {
                artistId : artistId,
                impresarioId : impresarioId
            }
        };

        $http(request).then(function(response){
            window.location.reload();
        });
    }
});