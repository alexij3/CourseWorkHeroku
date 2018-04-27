var app = angular.module("demo", []);

app.controller("CinemaMovieCtrl", function($scope, $http){
    var idToUpdate;

    $http.get('/api/cinema/showall').then(function(response) {
        console.log(response);
        var cinemas = response.data;
        var select = document.getElementById('CinemaMovieCinema');
        var selectCinemaUpd = document.getElementById('updateCinemaMovieCinema');

        for (var i = 0; i < cinemas.length; i++) {
            var option = document.createElement("option");
            option.text = cinemas[i].name;
            option.value = cinemas[i].id;

            select.add(option);

            console.log(select);
        }

        for (var j = 0; j < cinemas.length; j++){
            var option2 = document.createElement("option");
            option2.text = cinemas[j].name;
            option2.value = cinemas[j].id;

            selectCinemaUpd.add(option2);
            console.log(selectCinemaUpd);
        }


    });



    $scope.cinemaMovies = [];
     $http.get('/api/cinemamovie/showAll').then(function (response){
        $scope.cinemaMovies=response.data;
        console.log(response);
    });

    this.deleteCinemaMovie = function deleteCinemaMovie(id){
        $http.get('/api/cinemamovie/delete?id=' + id).then(function(response){
            console.log(response);
            window.location.reload();

        });
    };

    this.startCreateCinemaMovie = function startCreateCinemaMovie(){

    };

    this.createCinemaMovie = function createCinemaMovie(){
        var id = document.getElementById('CinemaMovieId').value;
        var cinemaId = document.getElementById('CinemaMovieCinema').value;
        var name = document.getElementById('CinemaMovieName').value;
        var genre = document.getElementById('CinemaMovieGenre').value;
        var date = document.getElementById('datePicker').value;

        var request = {
            method: 'POST',
            url: '/api/cinemamovie/create?id=' + id,
            data: {
                name : name,
                genre: genre,
                cinemaId: cinemaId,
                date: date
            }
        };

        $http(request).then(function(response){
            console.log(response);
        });

        window.location.reload();
    };

    this.startUpdateCinemaMovie = function startUpdateCinemaMovie(id, name, genre, cinemaId, date) {
        idToUpdate = id;
            document.getElementById('updateCinemaMovieName').value = name;
            document.getElementById('updateCinemaMovieGenre').value = genre;
            document.getElementById('updateCinemaMovieCinema').value = cinemaId;
            document.getElementById('updateDatePicker').value = date;

    };

    this.updateCinemaMovie = function updateCinemaMovie(){
        var name = document.getElementById('updateCinemaMovieName').value;
        var genre = document.getElementById('updateCinemaMovieGenre').value;
        var cinemaId = document.getElementById('updateCinemaMovieCinema').value;
        var date = document.getElementById('updateDatePicker').value;

        var request = {
            method: 'POST',
            url : '/api/cinemamovie/update?id=' + idToUpdate,
            data: {
                name : name,
                genre : genre,
                cinemaId : cinemaId,
                date : date
            }
        };

        $http(request).then(function (response){
            console.log(response);
        });

        window.location.reload();
    }
});



