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



function actionAjax() {



    var av1 = document.getElementById('av1').value;
    var av2 = document.getElementById('av2').value;
    var select = document.getElementById('matricula').value;
   // var mat = select.options[select.selectedIndex].value;
  
    getCadastroNotasAjax(select, av1, av2);

}

function getCadastroNotasAjax(mat, av1, av2) {
    ajaxRequest = getXMLHttpRequest();
    if (ajaxRequest) {   //  se o navagador suporta ajax
        ajaxRequest.onreadystatechange = ajaxLoginResposta;
        ajaxRequest.open("POST", "CadastrarNotas");
        ajaxRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
        var parametros = "matricula=" + mat + "&av1=" + av1 + "&av2=" + av2;
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
                divMsg.innerHTML = "Cadastro concluído com sucesso!";
                setTimeout(function () {
                    window.location.href = "index.html"
                }, 4000);
                //window.location.href = "index.html";
            }

        }
        else {
            alert("Falhou: " + ajaxRequest.status + " " + ajaxRequest.statusText);
        }
    }
}
function validatePassword() {
    var p = document.getElementById('senha').value,
            errors = [];
    if (p.length < 8) {
        errors.push("Seu password precisa conter 8 letras ou mais");
    }
    if (p.search(/[a-z]/) < 0) {
        errors.push("Deve conter ao menos uma letra minúscula.");
    }
    if (p.search(/[A-Z]/) < 0) {
        errors.push("Deve conter ao menos uma letra maiúscula.");
    }
    if (p.search(/[0-9]/) < 0) {
        errors.push("Deve conter ao menos um número.");
    }
    if (errors.length > 0) {
        alert(errors.join("\n"));
        return false;
    }
    return true;
}
