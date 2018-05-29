var app = angular.module("demo", []);

app.controller("ArtistCtrl", function($scope, $http){
    var idToUpdate;
    var nameValidationRegEx = /^([А-ЯІЇЄҐ]'?([а-яіїєґ](-[А-ЯІЇЄҐ]|')?)+[а-яіїєґ]*\s){2,}[А-ЯІЇЄҐ]'?[а-яіїєґ]{4,}$/;

    var time = performance.now();
    $scope.artists = [];
     $http.get('/api/artist/showall').then(function (response){
         time = performance.now() - time;
         console.log("Виведення відбулося за " + time + " мс.");
        $scope.artists=response.data;
        console.log(response);
    });

    this.deleteArtist = function deleteArtist(id){
        var time = performance.now();
        $http.get('/api/artist/delete?id=' + id).then(function(){
            time = performance.now() - time;
            console.log("Видалення відбулося за " + time + " мс.");
            window.alert("Видалено артиста з ІД " + id);
            window.location.reload();
        });
    };

    this.createArtist = function createArtist(){
        var name = document.getElementById('artistName').value;
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
                url: '/api/artist/create',
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

    this.startUpdateArtist = function startUpdateArtist(id, name, age, experience){
        document.getElementById('updateArtistName').value = name;
        document.getElementById('updAge').value = age;
        document.getElementById('updExperience').value = experience;
        idToUpdate = id;
    };

    this.updateArtist = function updateArtist(){
        var name = document.getElementById('updateArtistName').value;
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
                url: '/api/artist/update?id=' + idToUpdate,
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

    this.getArtist = function getArtist(id){
        $http.get('/api/artist/get?id=' + id);
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

    /*
    *
    * ARTIST QUERIES
    *
    *                */


    this.selectByDontParticipate = function selectByDontParticipate(){
        var firstDate = document.getElementById('firstDate').value;
        var secondDate = document.getElementById('secondDate').value;

        $http.get('/api/artist/findAllByContestDateNotBetween?firstDate=' + firstDate + '&secondDate=' + secondDate).then(function(response){
            $scope.artists = response.data;
        });
    };

    /* Вибір за вказаним віком */
    this.selectByAge = function selectByAge(){
        var age = document.getElementById('ageRequest').value;

        if (document.getElementById('ageLess').checked){
            $http.get('/api/artist/findAllByAgeLessThan?age=' + age).then(function(response){
               $scope.artists = response.data;
            });
        }else if (document.getElementById('ageMoreEquals').checked){
            $http.get('/api/artist/findAllByAgeGreaterThanEqual?age=' + age).then(function(response){
                $scope.artists = response.data;
            });
        }
    };

    /* Вибір за вказаним досвідом */
    this.selectByExperience = function selectByExperience(){
        var experience = document.getElementById('experienceRequest').value;

        if (document.getElementById('experienceLess').checked){
            $http.get('/api/artist/findAllByExperienceLessThan?experience=' + experience).then(function(response){
                $scope.artists = response.data;
            });
        }else if (document.getElementById('experienceMoreEquals').checked){
            $http.get('/api/artist/findAllByExperienceGreaterThanEqual?experience=' + experience).then(function(response){
                $scope.artists = response.data;
            });
        }
    }

});



