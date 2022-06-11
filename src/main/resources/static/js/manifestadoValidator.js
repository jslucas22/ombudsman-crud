const nome = document.getElementById('nome')
const sobrenome = document.getElementById('sobrenome')
const endereco = document.getElementById('endereco')
const email = document.getElementById('email')
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

            if (nome.value === '' || nome.value == null) {
                msg.push('Informe seu nome!')
                e.preventDefault()
                erro.innerText = msg.join(', ')
                return;
            }

            if (sobrenome.value === '' || sobrenome.value == null) {
                msg.push('Informe seu sobrenome!')
                e.preventDefault()
                erro.innerText = msg.join(', ')
                return;
            }

            if (email.value === '' || email.value == null) {
                msg.push('Informe seu e-mail!')
                e.preventDefault()
                erro.innerText = msg.join(', ')
                return;
            }

            if (endereco.value === '' || endereco.value == null) {
                msg.push('Informe seu endereço!')
                e.preventDefault()
                erro.innerText = msg.join(', ')
                return;
            }
        }
    )
})