$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/consultar_manifestacao_total_json", type: "get", success: function (response) {
            document.getElementById('manifestacoes').innerHTML = 'Há ' + response + ' manifestações no total.';
        }, error: function (e) {
            alert("Algo deu errado :( \n" + JSON.stringify(e));
        },
    });

    $.ajax({
        url: "http://localhost:8080/consultar_manifestados_total_json", type: "get", success: function (response) {
            document.getElementById('manifestados').innerHTML = 'Há ' + response + ' manifestados no total.';
        }, error: function (e) {
            alert("Algo deu errado :( \n" + JSON.stringify(e));
        }
    });

    $.ajax({
        url: "http://localhost:8080/consultar_manifestantes_total_json", type: "get", success: function (response) {
            document.getElementById('manifestantes').innerHTML = 'Há ' + response + ' manifestantes no total.';
        }, error: function (e) {
            alert("Algo deu errado :( \n" + JSON.stringify(e));
        }
    });
});
