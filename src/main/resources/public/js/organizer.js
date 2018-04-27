var app = angular.module("demo", []);

app.controller("OrganizerCtrl", function($scope, $http){

    var idToUpdate;

    $scope.organizers = [];
     $http.get('/api/organizer/showAll').then(function (response){
        $scope.organizers=response.data;
        console.log(response);
    });

    this.deleteOrganizer = function deleteOrganizer(id){
        $http.get('/api/organizer/delete?id=' + id).then(function(){
            window.location.reload();
            console.log("deleted organizer with id " + id);
        });
    };

    this.createOrganizer = function createOrganizer(){
        var name = document.getElementById('organizerName').value;
        $http.get('/api/organizer/create?name=' + name).then(function(){
            window.location.reload();
        });
    };

    this.startUpdateOrganizer = function startUpdateOrganizer(id, name){
        document.getElementById('updateOrganizerName').value = name;

        idToUpdate = id;
    };

    this.updateOrganizer = function updateOrganizer(){
        var name = document.getElementById('updateOrganizerName').value;
        var request = {
            method: 'POST',
            url : '/api/organizer/update?id=' + idToUpdate,
            data: {
                name : name
            }
        };

        $http(request).then(function (response){
            window.location.reload();
            console.log(response);
        })
    }
});



