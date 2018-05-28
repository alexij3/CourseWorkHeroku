var app = angular.module("demo", []);

app.controller("CinemaMovieCtrl", function($scope, $http){
    var idToUpdate;

    $http.get('/api/cinema/showall').then(function(response) {
        console.log(response);
        var cinemas = response.data;
        var select = document.getElementById('CinemaMovieCinema');
        var selectCinemaUpd = document.getElementById('updateCinemaMovieCinema');
        var selectCinemaRequest = document.getElementById('selectCinemaRequest');

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

        for (var k = 0; k < cinemas.length; k++){
            var option3 = document.createElement("option");
            option3.text = cinemas[k].name;
            option3.value = cinemas[k].id;

            selectCinemaRequest.add(option3);
            console.log(selectCinemaRequest);
        }


    });

    var time = performance.now();
    $scope.cinemaMovies = [];
     $http.get('/api/cinemamovie/showAll').then(function (response){
         time = performance.now() - time;
         console.log("Виведення відбулося за " + time + " мс.");
        $scope.cinemaMovies=response.data;
        console.log(response);
    });

    this.deleteCinemaMovie = function deleteCinemaMovie(id){
        var time = performance.now();
        $http.get('/api/cinemamovie/delete?id=' + id).then(function(response){
            time = performance.now() - time;
            console.log("Видалення відбулося за " + time + " мс.");
            console.log(response);
            window.location.reload();

        });
    };

    this.startCreateCinemaMovie = function startCreateCinemaMovie(){

    };

    this.createCinemaMovie = function createCinemaMovie(){
        var cinemaId = document.getElementById('CinemaMovieCinema').value;
        var name = document.getElementById('CinemaMovieName').value;
        var genre = document.getElementById('CinemaMovieGenre').value;
        var date = document.getElementById('datePicker').value;

        var request = {
            method: 'POST',
            url: '/api/cinemamovie/create',
            data: {
                name : name,
                genre: genre,
                cinemaId: cinemaId,
                date: date
            }
        };

        var time = performance.now();
        $http(request).then(function(response){
            time = performance.now() - time;
            console.log("Створення відбулося за " + time + " мс.");
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

        var time = performance.now();
        $http(request).then(function (response){
            time = performance.now() - time;
            console.log("Оновлення відбулося за " + time + " мс.");
            console.log(response);
        });

        window.location.reload();
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

    /* Одержати список заходів, проведених у вказаній культурній споруді
    *                           (в даному випадку - в кінотеатрі)*/


    this.showCinemaMoviesByCinema = function showCinemaMoviesByCinema(){
        var id = document.getElementById('selectCinemaRequest').value;

        $http.get('/api/cinemamovie/findAllByCinemaId?id='+ id).then(function (response){
            $scope.cinemaMovies = response.data;
        });
    };

    /* Одержати список фільмів, показаних протягом
                                вказаного періоду */

    this.showByDate = function showByDate(){
        var firstDate = document.getElementById('firstDate').value;
        var secondDate = document.getElementById('secondDate').value;

        $http.get('/api/cinemamovie/findAllByDateBetween?firstDate=' + firstDate + '&secondDate=' + secondDate).then(function(response){
            $scope.cinemaMovies = response.data;
        });
    };

    /* Одержати список фільмів у вказаному жанрі */

    this.showCinemaMoviesByGenre = function showCinemaMoviesByGenre(){
        var genre = document.getElementById('genresRequest').value;

        $http.get('/api/cinemamovie/findAllByGenre?genre=' + genre).then(function(response){
           $scope.cinemaMovies = response.data;
        });
    };
});



