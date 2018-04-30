var app = angular.module("demo", []);

app.controller("ArtistImpresarioCtrl", function($scope, $http) {
    var artistId;
    var artistName;
    var delImpresarios = [];
    var impresarios = [];

    $scope.artists = [];
    $http.get('/api/artist/showall').then(function (response) {
        $scope.artists = response.data;

        $http.get('/api/impresario/showall').then(function(response){
            var impresarios = response.data;
            var select = document.getElementById('selectImpresarios');

            for (var i = 0; i < impresarios.length; i++) {
                var option = document.createElement("option");
                option.text = impresarios[i].name;
                option.value = impresarios[i].id;

                select.add(option);

                console.log(select);
            }
        });
    });

    this.addImpresario = function addImpresario(){
        impresarios = $('#selectImpresarios').val();
        var request = {
            method: 'PUT',
            url: '/api/artist/updateimpresarios?id=' + artistId,
            data: {
                name : artistName,
                impresarioIds : impresarios
            }
        };

        $http(request).then(function(){
            window.location.reload();
        });
    };

    this.startAddImpresario = function startAddImpresario(id, name){
        artistId = id;
        artistName = name;
        document.getElementById('artistName').innerHTML = name;
    };

    this.startDeleteImpresario = function startDeleteImpresario(idArtist, name, impresariosToDelete){
        artistId = idArtist;
        artistName = name;
        document.getElementById('delArtistName').innerHTML = name;

        impresarios = impresariosToDelete;
        var select = document.getElementById('delSelectImpresario');

        for (var i = 0; i < impresarios.length; i++) {
            var option = document.createElement("option");
            option.text = impresarios[i].name;
            option.value = impresarios[i].id;

            select.add(option);

            console.log(select);
        }
    };

    this.deleteImpresario = function deleteImpresario(){
        impresarios = $('#delSelectImpresario').val();
        var request = {
            method: 'POST',
            url: '/api/artist/deleteimpresarios?artistId=' + artistId,
            data: {
                name : artistName,
                impresarioIds : impresarios
            }
        };

        $http(request).then(function(response){
            document.getElementById('delSelectImpresario').options.length = 0;
            window.location.reload();
        });
    };

    function removeItems(selectBox){
        for (var i = selectBox.length-1; i >= 0; i--){
            selectBox.remove(i);
        }
    }

    this.Names = function Names(impresarios){
        var a = [];
        for (var i = 0; i < impresarios.length; i++)
            a[i] = impresarios[i].name;

        return a;
    };

    this.onClose = function onClose(){
        removeItems(document.getElementById('delSelectImpresario'));
    }
});



