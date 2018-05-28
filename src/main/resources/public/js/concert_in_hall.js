var app = angular.module("demo", []);

app.controller("ConcertInHallCtrl", function($scope, $http){
    var idToUpdate;

    $http.get('/api/concerthall/showAll').then(function(response) {
        console.log(response);
        var concertHalls = response.data;
        var select = document.getElementById('ConcertInHallConcertHall');
        var selectConcertHallUpd = document.getElementById('updateConcertInHallConcertHall');

        for (var i = 0; i < concertHalls.length; i++) {
            var option = document.createElement("option");
            option.text = concertHalls[i].name;
            option.value = concertHalls[i].id;

            select.add(option);

            console.log(select);
        }

        for (var j = 0; j < concertHalls.length; j++){
            var option2 = document.createElement("option");
            option2.text = concertHalls[j].name;
            option2.value = concertHalls[j].id;

            selectConcertHallUpd.add(option2);
            console.log(selectConcertHallUpd);
        }

        $http.get('/api/organizer/showAll').then(function(response){
            var organizers = response.data;
            var select = document.getElementById('ConcertInHallOrganizer');
            var selectOrganizersUpd = document.getElementById('updateConcertInHallOrganizer');
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

    var time = performance.now();
    $scope.concertInHalls = [];
    $http.get('/api/concertinhall/showall').then(function (response){
        time = performance.now()-time;
        console.log("Виведення відбулося за " + time + " мс.");
        $scope.concertInHalls=response.data;
        console.log(response);
    });

    this.deleteConcertInHall = function deleteConcertInHall(id){
        var time = performance.now();
        $http.post('/api/concertinhall/delete?id=' + id).then(function(response){
            time = performance.now()-time;
            console.log("Видалення відбулося за " + time + " мс.");
            window.location.reload();
            console.log(response);
        });
    };

    this.startCreateConcertInHall = function startCreateConcertInHall(){

    };

    this.createConcertInHall = function createConcertInHall(){
        /*window.alert(document.getElementById('ConcertInHallConcertHall').value);
        window.alert(document.getElementById('ConcertInHallName').value);
        window.alert(document.getElementById('ConcertInHallOrganizer').value);
        window.alert(document.getElementById('datePicker').value);*/
        var concertHallId = document.getElementById('ConcertInHallConcertHall').value;
        var name = document.getElementById('ConcertInHallName').value;
        var organizerId = document.getElementById('ConcertInHallOrganizer').value;
        var date = document.getElementById('datePicker').value;

        var request = {
            method: 'PUT',
            url: '/api/concertinhall/insert',
            data: {
                name : name,
                concertHallId : concertHallId,
                organizerId: organizerId,
                date : date
            }
        };

        var time = performance.now();
        $http(request).then(function(response){
            time = performance.now() - time;
            console.log("Створення відбулося за " + time + " мс.");
            window.location.reload();
        });

        //window.alert(date);
    };

    this.startUpdateConcertInHall = function startUpdateConcertInHall(id, name, concertHallId, organizerId, date) {
        idToUpdate = id;
        document.getElementById('updateConcertInHallName').value = name;
        document.getElementById('updateConcertInHallConcertHall').value = concertHallId;
        document.getElementById('updateConcertInHallOrganizer').value = organizerId;
        document.getElementById('updateDatePicker').value = date;

    };

    this.updateConcertInHall = function updateConcertInHall(){
        var concertHallId = document.getElementById('updateConcertInHallConcertHall').value;
        var name = document.getElementById('updateConcertInHallName').value;
        var organizerId = document.getElementById('updateConcertInHallOrganizer').value;
        var date = document.getElementById('updateDatePicker').value;

        var request = {
            method: 'POST',
            url : '/api/concertinhall/update',
            data: {
                id: idToUpdate,
                concertHallId : concertHallId,
                name: name,
                organizerId: organizerId,
                date: date
            }
        };

        var time = performance.now();
        $http(request).then(function (response){
            time = performance.now() - time;
            console.log("Оновлення відбулося за " + time + " мс.");
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

        $http.get('/api/concertinhall/findAllByDateBetween?firstDate=' + firstDate + '&secondDate=' + secondDate).then(function(response){
            $scope.concertInHalls = response.data;
        });
    };

    /* Одержати список концертних заходів, проведених протягом
      вказаного періоду вказаним організатором */

    this.showConcertsByDateOrganizer = function showConcertsByDateOrganizer(){
        var firstDate = document.getElementById('orgFirstDate').value;
        var secondDate = document.getElementById('orgSecondDate').value;
        var organizerId = document.getElementById('selectOrg').value;

        $http.get('/api/concertinhall/findAllByDateBetweenAndOrganizer?firstDate=' + firstDate + '&secondDate=' + secondDate +
                                                                        '&organizerId=' + organizerId).then(function(response){
            $scope.concertInHalls = response.data;
        });
    };

});



