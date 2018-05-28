var app = angular.module("demo", []);

app.controller("ContestInPalaceCtrl", function($scope, $http){
    var idToUpdate;

    $http.get('/api/culturepalace/showAll').then(function(response) {
        console.log(response);
        var culturePalaces = response.data;
        var select = document.getElementById('ContestInPalaceCulturePalace');
        var selectCulturePalaceUpd = document.getElementById('updateContestInPalaceCulturePalace');
        var selectPalaceRequest = document.getElementById('selectPalaceRequest');

        for (var i = 0; i < culturePalaces.length; i++) {
            var option = document.createElement("option");
            option.text = culturePalaces[i].name;
            option.value = culturePalaces[i].id;

            select.add(option);

            console.log(select);
        }

        for (var j = 0; j < culturePalaces.length; j++){
            var option2 = document.createElement("option");
            option2.text = culturePalaces[j].name;
            option2.value = culturePalaces[j].id;

            selectCulturePalaceUpd.add(option2);
            console.log(selectCulturePalaceUpd);
        }

        for (var k = 0; k < culturePalaces.length; k++){
            var option3 = document.createElement("option");
            option3.text = culturePalaces[k].name;
            option3.value = culturePalaces[k].id;

            selectPalaceRequest.add(option3);
            console.log(selectPalaceRequest);
        }

        $http.get('/api/organizer/showAll').then(function(response){
            var organizers = response.data;
            var select = document.getElementById('ContestInPalaceOrganizer');
            var selectOrganizersUpd = document.getElementById('updateContestInPalaceOrganizer');
            var selectOrgRequest = document.getElementById('selectOrg');

            for (var i = 0; i < organizers.length; i++) {
                var option = document.createElement("option");
                option.text = organizers[i].name;
                option.value = organizers[i].id;

                select.add(option);

                console.log(select);
            }

            for (var j = 0; j < organizers.length; j++) {
                var option2 = document.createElement("option");
                option2.text = organizers[j].name;
                option2.value = organizers[j].id;

                selectOrganizersUpd.add(option2);

                console.log(selectOrganizersUpd);
            }

            for (var k = 0; k < organizers.length; k++){
                var option3 = document.createElement("option");
                option3.text = organizers[k].name;
                option3.value = organizers[k].id;

                selectOrgRequest.add(option3);

                console.log(selectOrgRequest);
            }
        });

    });

    $scope.contestInPalaces = [];
     $http.get('/api/contestinpalace/showall').then(function (response){
        $scope.contestInPalaces=response.data;
        console.log(response);
    });

    this.deleteContestInPalace = function deleteContestInPalace(id){
        $http.post('/api/contestinpalace/delete?id=' + id).then(function(response){
            console.log(response);
            window.location.reload();
        });
    };

    this.startCreateContestInPalace = function startCreateContestInPalace(){

    };

    this.createContestInPalace = function createContestInPalace(){
        var culturePalaceId = document.getElementById('ContestInPalaceCulturePalace').value;
        var name = document.getElementById('ContestInPalaceName').value;
        var organizerId = document.getElementById('ContestInPalaceOrganizer').value;
        var date = document.getElementById('datePicker').value;

        var request = {
            method: 'PUT',
            url: '/api/contestinpalace/insert',
            data: {
                name : name,
                culturePalaceId : culturePalaceId,
                organizerId: organizerId,
                date : date
            }
        };

        $http(request).then(function(response){
            window.location.reload();
        })

        //window.alert(date);
    };

    this.startUpdateContestInPalace = function startUpdateContestInPalace(id, name, culturePalaceId, organizerId, date) {
        idToUpdate = id;
        document.getElementById('updateContestInPalaceName').value = name;
        document.getElementById('updateContestInPalaceCulturePalace').value = culturePalaceId;
        document.getElementById('updateContestInPalaceOrganizer').value = organizerId;
        document.getElementById('updateDatePicker').value = date;

    };

    this.updateContestInPalace = function updateContestInPalace(){
        var culturePalaceId = document.getElementById('updateContestInPalaceCulturePalace').value;
        var name = document.getElementById('updateContestInPalaceName').value;
        var organizerId = document.getElementById('updateContestInPalaceOrganizer').value;
        var date = document.getElementById('updateDatePicker').value;

        var request = {
            method: 'POST',
            url : '/api/contestinpalace/update',
            data: {
                id: idToUpdate,
                culturePalaceId : culturePalaceId,
                name: name,
                organizerId: organizerId,
                date: date
            }
        };

        $http(request).then(function (response){
            window.location.reload();
            console.log(response);
        });
    };

    /**
     *
     *
     *
     * REQUESTS
     *
     *
     *
     */

    /* Одержати список концертних заходів, проведених протягом
      вказаного періоду загалом */

    this.showConcertsByDate = function showConcertsByDate(){
        var firstDate = document.getElementById('firstDate').value;
        var secondDate = document.getElementById('secondDate').value;

        $http.get('/api/contestinpalace/findAllByDateBetween?firstDate=' + firstDate + '&secondDate=' + secondDate).then(function(response){
            $scope.contestInPalaces = response.data;
        });
    };

    /* Одержати список концертних заходів, проведених протягом
      вказаного періоду вказаним організатором */

    this.showConcertsByDateOrganizer = function showConcertsByDateOrganizer(){
        var firstDate = document.getElementById('orgFirstDate').value;
        var secondDate = document.getElementById('orgSecondDate').value;
        var organizerId = document.getElementById('selectOrg').value;

        $http.get('/api/contestinpalace/findAllByDateBetweenAndOrganizer?firstDate=' + firstDate + '&secondDate=' + secondDate +
            '&organizerId=' + organizerId).then(function(response){
            $scope.contestInPalaces = response.data;
        });
    };

    /* Одержати список заходів, проведених у вказаній культурній споруді
    *                           (в даному випадку - в культурному палаці)*/


    this.showContestByPalace = function showContestByPalace(){
        var id = document.getElementById('selectPalaceRequest').value;

        $http.get('/api/contestinpalace/findAllByCulturePalaceId?id='+ id).then(function (response){
            $scope.contestInPalaces = response.data;
        });
    };
});



