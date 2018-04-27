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
        });

    });

    $scope.contestInPalaces = [];
    $http.get('/api/concertinhall/showall').then(function (response){
        $scope.contestInPalaces=response.data;
        console.log(response);
    });

    this.deleteConcertInHall = function deleteConcertInHall(id){
        $http.post('/api/concertinhall/delete?id=' + id).then(function(response){
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

        $http(request).then(function(response){
            window.location.reload();
        })

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

        $http(request).then(function (response){
            window.location.reload();
            console.log(response);
        });
    }
});



