
window.onload = function (){
    let imagemBotao = document.getElementById("adicionarBotao");
    imagemBotao.addEventListener("click", adicionarSePreenchido);

    let botaoLimpar = document.querySelector(".botao");
    botaoLimpar.addEventListener("click", function(){limparItems()});
}

function adicionarSePreenchido() {
    let novoItemTexto = document.getElementById("caixaNovoItem").value;
    if (novoItemTexto != "") {
        adicionarItemLista(novoItemTexto);
        alternarEstadoBotao("Ativo");
    }
}

function adicionarItemLista(nomeItem) {
    let lista = document.querySelector("#lista");
    lista.innerHTML += `<li>${nomeItem}</li>`;
    document.getElementById("caixaNovoItem").value = "";
}

function limparItems() {
    const listaTarefas = document.querySelectorAll("#lista li");

    for (const tarefa of listaTarefas) {
        tarefa.parentNode.removeChild(tarefa);
        alternarEstadoBotao("Inativo");
    }
}


function alternarEstadoBotao(novoEstado) {
    let botaoLimpar = document.getElementsByClassName("botao")[0];
    botaoLimpar.disabled = novoEstado == "Ativo" ? false : true;
}

