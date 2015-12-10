<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/signin.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="container">
            <form name="frm1" class="form-signin" action="Login"  method="post" >
                <h2 class="form-signin-heading">Sistema de Alunos</h2>
                <label for="inputEmail" class="sr-only">Login</label>
                <input type="text" id="login" class="form-control" placeholder="Login" name="login">
                <label for="inputPassword" class="sr-only">Senha</label>
                <input type="password" id="senha" class="form-control" placeholder="Senha" name="senha">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Lembrar-me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="button" onclick="javascript:teclaPressionadaLogin(event);">Sign in</button>
                <div id="msg" style="color:red"</div>
            </form>

        </div>

        <script>
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
                    return true;
                }
                //exp = /(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/;

               /* if (!exp.test(senha)) {
                    div.innerHTML = "A senha deve ter mais de 8 caracteres e\n\
                        possuir pelo menos 1 letra minúscula(ex: abc), 1 letra maiúscula(ex: ABC) e 1 dígito(0 a 9)";
                    return true;
                }*/
                
               
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
                getLoginAjax(login,senha);
                return true;

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
                            }, 4000);
                            //window.location.href = "index.html";
                        }
                        if (resposta == "Erro") {
                            divMsg.innerHTML = "Usuario e/ou Senha incorretos!";
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

        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/npm.js" type="text/javascript"></script>

    </body>
</html>

