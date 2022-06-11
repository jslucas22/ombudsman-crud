$(document).ready(function () {
    //----------------------------------------------------------------------------------------------------------------->
    // --> Carrega o drop down do manifestante
    //----------------------------------------------------------------------------------------------------------------->
    $(document).on('click', "#manifestante", function (event) {
        let manifestante = $("#manifestante option:selected").val();

        $.ajax({
            url: "http://localhost:8080/consultar_manifestante_json", type: "get", success: function (response) {
                $('#manifestante').empty();
                $('#manifestante').append($('<option>', {
                    value: 0, text: ' '
                }));

                for (let item in response) {
                    $('#manifestante').append($('<option>', {
                        value: response[item].id,
                        text: response[item].nome + ' ' + response[item].sobrenome
                    }));
                }
                $('#manifestante').val(manifestante);
            }, error: function (e) {
                alert("Algo deu errado :( \n" + JSON.stringify(e));
            }
        });
    });
    //----------------------------------------------------------------------------------------------------------------->
    // --> Carrega o drop down do manifestado
    //----------------------------------------------------------------------------------------------------------------->
    $(document).on('click', "#manifestado", function (event) {
        let manifestado = $("#manifestado option:selected").val();

        $.ajax({
            url: "http://localhost:8080/consultar_manifestado_json", type: "get", success: function (response) {
                $('#manifestado').empty();
                $('#manifestado').append($('<option>', {
                    value: 0, text: ' '
                }));

                for (let item in response) {
                    $('#manifestado').append($('<option>', {
                        value: response[item].id,
                        text: response[item].nome + ' ' + response[item].sobrenome
                    }));
                }
                $('#manifestado').val(manifestado);
            }, error: function (e) {
                alert("Algo deu errado :( \n" + JSON.stringify(e));
            }
        });
    });
    //----------------------------------------------------------------------------------------------------------------->
    // --> Carrega o drop down de tipo de manifestação
    //----------------------------------------------------------------------------------------------------------------->
    $(document).on('click', "#tipoManifestacao", function (event) {
        let tipoManifestacao = $("#tipoManifestacao option:selected").val();

        $.ajax({
            url: "http://localhost:8080/consultar_tipo_manifestacao_json", type: "get", success: function (response) {
                $('#tipoManifestacao').empty();
                $('#tipoManifestacao').append($('<option>', {
                    value: 0, text: ' '
                }));

                for (let item in response) {
                    $('#tipoManifestacao').append($('<option>', {
                        value: response[item].id,
                        text: response[item].tipo
                    }));
                }
                $('#tipoManifestacao').val(tipoManifestacao);
            }, error: function (e) {
                alert("Algo deu errado :( \n" + JSON.stringify(e));
            }
        });
    });
    //----------------------------------------------------------------------------------------------------------------->
    // --> Carrega o drop down de tag
    //----------------------------------------------------------------------------------------------------------------->
    $(document).on('click', "#tag", function (event) {
        let tag = $("#tag option:selected").val();

        $.ajax({
            url: "http://localhost:8080/consultar_tag_json", type: "get", success: function (response) {
                $('#tag').empty();
                $('#tag').append($('<option>', {
                    value: 0, text: ' '
                }));

                for (let item in response) {
                    $('#tag').append($('<option>', {
                        value: response[item].id,
                        text: response[item].tipo
                    }));
                }
                $('#tag').val(tag);
            }, error: function (e) {
                alert("Algo deu errado :( \n" + JSON.stringify(e));
            }
        });
    });
});