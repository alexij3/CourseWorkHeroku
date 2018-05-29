var app = angular.module("demo", []);

app.controller("ImpresarioCtrl", function($scope, $http){
    var idToUpdate;
    var nameValidationRegEx = /^([А-ЯІЇЄҐ]'?([а-яіїєґ](-[А-ЯІЇЄҐ]|')?)+[а-яіїєґ]*\s){2,}[А-ЯІЇЄҐ]'?[а-яіїєґ]{4,}$/;

    var time = performance.now();
    $scope.impresarios = [];
     $http.get('/api/impresario/showall').then(function (response){
         time = performance.now() - time;
         console.log("Виведення відбулося за " + time + " мс.");
        $scope.impresarios=response.data;
        console.log(response);
    });

    $http.get('/api/artist/showall').then(function(response){
        var artists = response.data;
        var select = document.getElementById('selectByArtistArtists');

        for (var i = 0; i < artists.length; i++) {
            var option = document.createElement("option");
            option.text = artists[i].name;
            option.value = artists[i].id;

            select.add(option);

            console.log(select);
        }
    });

    this.deleteImpresario = function deleteImpresario(id){
        var time = performance.now();
        $http.get('/api/impresario/delete?id=' + id).then(function(){
            time = performance.now() - time;
            console.log("Видалення відбулося за " + time + " мс.");
            window.location.reload();
            console.log("deleted impresario with id " + id);
        });
    };

    this.createImpresario = function createImpresario(){
        var name = document.getElementById('ImpresarioName').value;
        var age = document.getElementById('age').value;
        var experience = document.getElementById('experience').value;

        var nameIsCorrect = true;
        var ageIsCorrect = true;
        var experienceIsCorrect = true;

        if (!name.match(nameValidationRegEx)){
            document.getElementById("wrongName").innerHTML = "Некоректне ім'я!";
            nameIsCorrect = false;
        }else this.clearName();

        if (age < 18 || age > 100 || age == null){
            document.getElementById("wrongAge").innerHTML = "Вік повинен бути від 18 до 100 років!";
            ageIsCorrect = false;
        }else this.clearAge();

        if (experience < 0 || age-experience < 17 || experience == null){
            document.getElementById('wrongExperience').innerHTML = "Некоректний досвід!";
            experienceIsCorrect = false;
        }else this.clearExperience();

        if (nameIsCorrect && ageIsCorrect && experienceIsCorrect) {
            var createRequest = {
                method: 'PUT',
                url: '/api/impresario/create',
                data: {
                    name: name,
                    age: age,
                    experience : experience
                }
            };

            var time = performance.now();
            $http(createRequest).then(function (response) {
                time = performance.now() - time;
                console.log("Створення відбулося за " + time + " мс.");
                console.log(response);
                window.location.reload();
            });
        }
    };

    this.startUpdateImpresario = function startUpdateImpresario(id, name, age, experience){
        document.getElementById('updateImpresarioName').value = name;
        document.getElementById('updAge').value = age;
        document.getElementById('updExperience').value = experience;

        idToUpdate = id;
    };

    this.updateImpresario = function updateImpresario(){
        var name = document.getElementById('updateImpresarioName').value;
        var age = document.getElementById('updAge').value;
        var experience = document.getElementById('updExperience').value;

        var nameIsCorrect = true;
        var ageIsCorrect = true;
        var experienceIsCorrect = true;

        if (!name.match(nameValidationRegEx)){
            document.getElementById("editWrongName").innerHTML = "Некоректне ім'я!";
            nameIsCorrect = false;
        }else this.clearName();

        if (age < 18 || age > 100 || age == null){
            document.getElementById("editWrongAge").innerHTML = "Вік повинен бути від 18 до 100 років!";
            ageIsCorrect = false;
        }else this.clearAge();

        if (experience < 0 || age-experience < 17 || experience == null){
            document.getElementById('editWrongExperience').innerHTML = "Некоректний досвід!";
            experienceIsCorrect = false;
        }else this.clearExperience();

        if (nameIsCorrect && ageIsCorrect && experienceIsCorrect){
            var request = {
                method: 'POST',
                url: '/api/impresario/update?id=' + idToUpdate,
                data: {
                    name: name,
                    age : age,
                    experience : experience
                }
            };

            var time = performance.now();
            $http(request).then(function (response) {
                time = performance.now() - time;
                console.log("Оновлення відбулося за " + time + " мс.");
                console.log(response);
                window.location.reload();
            });
        }
    };

    this.clearName = function clearName(){
        document.getElementById('wrongName').innerHTML = "";
        document.getElementById('editWrongName').innerHTML = "";
    };

    this.clearAge = function clearAge(){
        document.getElementById('wrongAge').innerHTML = "";
        document.getElementById('editWrongAge').innerHTML = "";
    };

    this.clearExperience = function clearExperience(){
        document.getElementById('wrongExperience').innerHTML = "";
        document.getElementById('editWrongExperience').innerHTML = "";
    };

    /**
     *
     *
     * QUERIES
     *
     *
     */

    this.showImpresariosByArtist = function showImpresariosByArtist(){
        var id = document.getElementById('selectByArtistArtists').value;


        $http.get('/api/artist/findArtistImpresarios?id=' + id).then(function (response){
            $scope.impresarios = response.data;
        });
    };

    // Список імпресаріо за вказаним жанром
    this.showImpresarioByGenre = function showImpresarioByGenre(){
        var genre = document.getElementById('genres').value;

        $http.get('/api/impresario/findAllByGenreSetContaining?genre=' + genre).then(function(response){
            $scope.impresarios = response.data;
        });
    };

    /* Вибір за вказаним віком */
    this.selectByAge = function selectByAge(){
        var age = document.getElementById('ageRequest').value;

        if (document.getElementById('ageLess').checked){
            $http.get('/api/impresario/findAllByAgeLessThan?age=' + age).then(function(response){
                $scope.impresarios = response.data;
            });
        }else if (document.getElementById('ageMoreEquals').checked){
            $http.get('/api/impresario/findAllByAgeGreaterThanEqual?age=' + age).then(function(response){
                $scope.impresarios = response.data;
            });
        }
    };

    /* Вибір за вказаним досвідом */
    this.selectByExperience = function selectByExperience(){
        var experience = document.getElementById('experienceRequest').value;

        if (document.getElementById('experienceLess').checked){
            $http.get('/api/impresario/findAllByExperienceLessThan?experience=' + experience).then(function(response){
                $scope.impresarios = response.data;
            });
        }else if (document.getElementById('experienceMoreEquals').checked){
            $http.get('/api/impresario/findAllByExperienceGreaterThanEqual?experience=' + experience).then(function(response){
                $scope.impresarios = response.data;
            });
        }
    }


});



