$('#addModal').on("hidden.bs.modal", function(){
    onCloseData();
});

$('#editModal').on("hidden.bs.modal", function(){
    onCloseData();
});

$('#deleteModal').on("hidden.bs.modal", function(){
    onCloseGenres();
});

function onCloseData(){
    var errors = document.getElementsByClassName('error');
    for (var i = 0; i < errors.length; i++){
        errors[i].innerHTML = "";
    }

    var errorsCinemaMovie = document.getElementsByClassName('error cinemamovie');
    for (var k = 0; k < errorsCinemaMovie.length; k++){
        errorsCinemaMovie[k].innerHTML = "";
    }

    var data = document.getElementsByClassName('data');
    for (var j = 0; j < data.length; j++){
        data[j].value = null;
    }
}

function onCloseGenres(){
    removeItems(document.getElementById('delSelectGenre'));
    onCloseImpresarios();
}

function onCloseImpresarios(){
    removeItems(document.getElementById('delSelectImpresario'));
}

function removeItems(selectBox){
    for (var i = selectBox.length-1; i >= 0; i--){
        selectBox.remove(i);
    }
}