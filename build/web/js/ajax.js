var ajaxRequest;

function getXMLHttpRequest() {
    if (window.XMLHttpRequest) {
        return new window.XMLHttpRequest();
    }
    else {
        try {
            return new ActiveXObject("Msxml2.XMLHTTP");
        }
        catch (ex) {
            return null;
        }
    }
}

function teclaPressionadaLogin(e) {

    var login = document.frm1.login.value;
    var senha = document.frm1.senha.value;
    var div = document.getElementById("msg");
    if (!login.length) {
        div.innerHTML = "O login deve ser preenchido!";
        return false;
    }
    if (!senha.length) {
        div.innerHTML = "A senha deve ser preenchida!";
        return false;
    }

    getLoginAjax(login, senha);
    

}

function getLoginAjax(login, senha) {
    ajaxRequest = getXMLHttpRequest();
    if (ajaxRequest) {   //  se o navagador suporta ajax
        ajaxRequest.onreadystatechange = ajaxLoginResposta;
        ajaxRequest.open("POST", "Login");
        ajaxRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
        var parametros = "login=" + login + "&senha=" + senha;
        ajaxRequest.send(parametros);
    }
}

function ajaxLoginResposta() {
    if (ajaxRequest.readyState != 4)  //  Checa se a requisição foi completada
    {
        return;
    }
    else {

        if (ajaxRequest.status == 200) //  Checa se o código HTTP é de sucesso
        {
            var divMsg = document.getElementById("msg");
            var resposta = ajaxRequest.responseText;
            if (resposta == "OK") {
                divMsg.innerHTML = "Usuario Autenticado! <br> Voce sera redirecionado";
                setTimeout(function () {
                    window.location.href = "index.html"
                }, 5000);
                window.location.href = "index.html";
            }
            if (resposta == "Erro") {
                divMsg.innerHTML = "Usuario e/ou Senha incorretos!";
                setTimeout(function () {
                    window.location.href = "index.html"
                }, 5000);
            }
        }
        else {
            alert("Falhou: " + ajaxRequest.status + " " + ajaxRequest.statusText);
        }
    }
}
function procuraSugestao(nome) {
    ajaxRequest = getXMLHttpRequest();
    if (ajaxRequest) {   //  se o navagador suporta ajax
        ajaxRequest.onreadystatechange = ajaxSugestaoResposta;
        ajaxRequest.open("GET", "exemplo/sugestao?pesq=" + nome);
        ajaxRequest.send(null);
    }
}

function ajaxSugestaoResposta( )  //Callback chamada na resposta
{
    if (ajaxRequest.readyState == 4 && (ajaxRequest.status == 200)) {
        var div = document.getElementById("sugestao");
        div.innerHTML = ajaxRequest.responseText;
    }
}

function montaTabelaProduto(nome) {
    ajaxRequest = getXMLHttpRequest();
    if (ajaxRequest) {   //  se o navagador suporta ajax
        var indice = document.getElementsByTagName("select")[0].selectedIndex;
        var produto = document.getElementsByTagName("option")[indice].value;
        ajaxRequest.onreadystatechange = ajaxMontaTabelaXML;
        ajaxRequest.open("GET", "exemplo/xml?produto=" + produto);
        ajaxRequest.send(null);
    }
}

function montaTabelaProdutoJSON(nome) {
    ajaxRequest = getXMLHttpRequest();
    if (ajaxRequest) {   //  se o navagador suporta ajax
        var indice = document.getElementsByTagName("select")[0].selectedIndex;
        var produto = document.getElementsByTagName("option")[indice].value;
        ajaxRequest.onreadystatechange = ajaxMontaTabelaJSON;
        ajaxRequest.open("GET", "exemplo/json?produto=" + produto);
        ajaxRequest.send(null);
    }
}

function ajaxMontaTabelaXML( )  //Callback chamada na resposta
{
    if (ajaxRequest.readyState != 4)  //  Checa se a requisição foi completada
    {
        return;
    }
    else {
        if (ajaxRequest.status == 200) //  Checa se o código HTTP é de sucesso
        {
            var div = document.getElementById("produto");
            var divResposta = document.getElementById("resposta");
            var xmlDoc = ajaxRequest.responseXML;
            var produto = xmlDoc.getElementsByTagName("produto");
            if (produto[0]) {
                var nome = produto[0].getElementsByTagName("nome")[0].firstChild.nodeValue;
                var descricao = produto[0].getElementsByTagName("descricao")[0].firstChild.nodeValue;
                var preco = produto[0].getElementsByTagName("preco")[0].firstChild.nodeValue;
                div.innerHTML = "Nome: " + nome + "<br>Descricao: " + descricao + "<br>Preco: " + preco;
            } else {
                div.innerHTML = "Produto Desconhecido!";
            }
            divResposta.innerHTML = ajaxRequest.responseText.trim();
        }
        else {
            alert("Falhou: " + ajaxRequest.status + " " + ajaxRequest.statusText);
        }
    }
}


function ajaxMontaTabelaJSON( )  //Callback chamada na resposta
{
    if (ajaxRequest.readyState != 4)  //  Checa se a requisição foi completada
    {
        return;
    }
    else {
        if (ajaxRequest.status == 200) //  Checa se o código HTTP é de sucesso
        {
            var div = document.getElementById("produto");
            var divResposta = document.getElementById("resposta");
            var jsonstring = ajaxRequest.responseText;
            var json = JSON.parse(jsonstring);
            if (json) {
                var nome = json.produto.nome;
                var descricao = json.produto.descricao;
                var preco = json.produto.preco;
                div.innerHTML = "Nome: " + nome + "<br>Descricao: " + descricao + "<br>Preco: " + preco;
            } else {
                div.innerHTML = "Produto Desconhecido!";
            }
            divResposta.innerHTML = jsonstring.trim();
        }
        else {
            alert("Falhou: " + ajaxRequest.status + " " + ajaxRequest.statusText);
        }
    }
}

