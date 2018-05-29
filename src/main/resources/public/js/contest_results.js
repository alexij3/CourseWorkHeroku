var app = angular.module("demo", []);

app.controller("ContestResultsCtrl", function($scope, $http){
    var contestResultId;

    $scope.contestResults = [];
    $http.get('/api/contestresults/showall').then(function(response){
        $scope.contestResults = response.data;

        $http.get('/api/contestinpalace/showall').then(function(response){
            var contests = response.data;
            var select = document.getElementById('contestResultContest');
            var selectContestUpd = document.getElementById('updateContestResultContest');
            var selectContestRequest = document.getElementById('selectContestRequest');

            for (var i = 0; i < contests.length; i++) {
                var option = document.createElement("option");
                option.text = contests[i].name;
                option.value = contests[i].id;

                select.add(option);

                console.log(select);
            }

            for (var j = 0; j < contests.length; j++){
                var option2 = document.createElement("option");
                option2.text = contests[j].name;
                option2.value = contests[j].id;

                selectContestUpd.add(option2);

                console.log(selectContestUpd);
            }

            for (var k = 0; k < contests.length; k++){
                var option3 = document.createElement("option");
                option3.text = contests[k].name;
                option3.value = contests[k].id;

                selectContestRequest.add(option3);

                console.log(selectContestRequest);
            }

        });

        $http.get('/api/artist/showall').then(function(response){
            var artists = response.data;
            var select = document.getElementById('contestResultArtist');
            var selectArtistUpd = document.getElementById('updateContestResultArtist');

            for (var i = 0; i < artists.length; i++) {
                var option = document.createElement("option");
                option.text = artists[i].name;
                option.value = artists[i].id;

                select.add(option);

                console.log(select);
            }

            for (var j = 0; j < artists.length; j++) {
                var option2 = document.createElement("option");
                option2.text = artists[j].name;
                option2.value = artists[j].id;

                selectArtistUpd.add(option2);

                console.log(selectArtistUpd);
            }
        });
    });



    this.createContestResult = function createContestResult(){
        var contestId = document.getElementById('contestResultContest').value;
        var artistId = document.getElementById('contestResultArtist').value;
        var place = document.getElementById('place').value;
        var isWinner = document.getElementById('isWinner').value;

        var placeIsCorrect = true;

        if (place <= 0){
            placeIsCorrect = false;
            document.getElementById('wrongPlace').innerHTML = "Некоректне місце!";
        }else this.clearPlace();

        if (placeIsCorrect) {
            var request = {
                method: 'PUT',
                url: '/api/contestresults/insert?artistId=' + artistId + '&contestId=' + contestId + '&place=' + place + '&isWinner=' + isWinner
            };

            $http(request).then(function (response) {
                console.log(response);
                window.location.reload();
            });
        }
    };

    this.startUpdate = function startUpdate(contestResultIdUpd, contestId, artistId, place, isWinner){
        contestResultId = contestResultIdUpd;
        document.getElementById('updateContestResultContest').value = contestId;
        document.getElementById('updateContestResultArtist').value = artistId;
        document.getElementById('updatePlace').value = place;
        document.getElementById('updateIsWinner').value = isWinner;
    };

    this.update = function update(){
        var contestId = document.getElementById('updateContestResultContest').value;
        var artistId = document.getElementById('updateContestResultArtist').value;
        var place = document.getElementById('updatePlace').value;
        var isWinner = document.getElementById('updateIsWinner').value;

        var placeIsCorrect = true;

        if (place <= 0){
            placeIsCorrect = false;
            document.getElementById('editWrongPlace').innerHTML = "Некоректне місце!";
        }else this.clearPlace();

        if (placeIsCorrect) {
            var request = {
                method: 'POST',
                url: '/api/contestresults/update?contestResultId=' + contestResultId +
                '&contestId=' + contestId + '&artistId=' + artistId + '&place=' + place + '&isWinner=' + isWinner
            };

            $http(request).then(function (response) {
                console.log(response);
                window.location.reload();
            });
        }
    };

    this.del = function del(contestResultId){
        $http.post('/api/contestresults/delete?contestResultId=' + contestResultId).then(function(response){
            window.location.reload();
        });
    };

    this.clearPlace = function clearPlace(){
        document.getElementById('wrongPlace').innerHTML = "";
        document.getElementById('editWrongPlace').innerHTML = "";
    };

    /*******************************
     *
     *
     *
     ********* REQUESTS *********
     *
     *
     *
     *****************************/

    this.showContestById = function showContestById(){
        var id = document.getElementById('selectContestRequest').value;

        $http.get('/api/contestresults/findAllByContestId?contestId=' + id).then(function(response){
            $scope.contestResults = response.data;
        });
    };

});



