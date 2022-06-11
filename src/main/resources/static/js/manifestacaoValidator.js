const manifestante = document.getElementById('manifestante')
const manifestado = document.getElementById('manifestado')
const tipoManifestacao = document.getElementById('tipoManifestacao')
const tag = document.getElementById('tag')
const manifestacao = document.getElementById('manifestacao')
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

            if (manifestante.value == null || manifestante.value == 0) {
                msg.push('Selecione um manifestante!')
                e.preventDefault()
                erro.innerText = msg.join(', ')
                return;
            }

            if (manifestado.value == null || manifestado.value == 0) {
                msg.push('Selecione um manifestado!')
                e.preventDefault()
                erro.innerText = msg.join(', ')
                return;
            }

            if (tipoManifestacao.value == null || tipoManifestacao.value == 0) {
                msg.push('Selecione um tipo de manifestação!')
                e.preventDefault()
                erro.innerText = msg.join(', ')
                return;
            }

            if (tag.value == null || tag.value == 0) {
                msg.push('Selecione uma tag!')
                e.preventDefault()
                erro.innerText = msg.join(', ')
                return;
            }

            if (manifestacao.value == null || manifestacao.value == 0) {
                msg.push('Informe a manifestação!!')
                e.preventDefault()
                erro.innerText = msg.join(', ')
                return;
            }
        }
    )
})