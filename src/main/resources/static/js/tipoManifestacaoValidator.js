const tipo = document.getElementById('tipo')
const descricao = document.getElementById('descricao')
const form = document.getElementsByTagName('form')[0]
const erro = document.getElementById('erro')

$(document).ready(function () {
    let msg = []

    if (msg.length === 0) {
        $('#erro').hide();
    }

    form.addEventListener('submit', (e) => {
            if (msg.length > 0 || msg.length != null) {
                $('#erro').show();
            }

            msg.length = 0

            if (tipo.value === '' || tipo.value == null) {
                msg.push('Informe o tipo da manifestação!')
                e.preventDefault()
                erro.innerText = msg.join(', ')
                return;
            }

            if (descricao.value === '' || descricao.value == null) {
                msg.push('Informe a descrição do tipo de manifestação!')
                e.preventDefault()
                erro.innerText = msg.join(', ')
                return
            }
        }
    )
})