<%@page import="java.util.ArrayList"%>
<%
    DAO.AlunoDAO aluno = new DAO.AlunoDAO();
    ArrayList<Model.Aluno> alunos = aluno.listarAluno();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/npm.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <title>Cadastro de Notas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">       
    </head>
    <body>
        <div class="container">
            <jsp:include page="navbar.jsp" flush="true" />
            <div class="jumbotron">
                <form name="frm1" method="POST" >
                    <p>Matricula do Aluno:</p>
                    <select required="required" id="matricula" name="matricula">
                        <option value="">Selecione um aluno..</option>
                        <%
                            for (Model.Aluno lista : alunos) {

                        %>
                        <option value="<%=lista.getMat()%>"><%=lista.getNome()%> - <%=lista.getMat()%></option>
                        <%}%>                      
                    </select>
                    <br><br>
                    <p>Nota AV1</p>
                    <input class="nota" type="number" id="av1" name="av1" ><br><br>
                    <p>Nota AV2</p>
                    <input class="nota" type="number" id="av2" name="av2" ><br><br>
                    <button class="btn btn-primary" type="button" onclick="validarNotas();">Cadastrar</button>
                    <div id="msg" style="color:red"></div>
                </form>
            </div>
        </div>
        <script src="js/ajaxnotas.js" type="text/javascript"></script>
        <script>
                        function validarNotas() {
                            var texto = document.getElementById("av1").value;
                            var texto2 = document.getElementById("av2").value;

                            var RegExp = /^[\d]{1,2}([.|,][\d]{2})?$/;

                            if (RegExp.test(texto) == true & RegExp.test(texto2) == true) {
                                if (texto > 10 || texto < 0) {
                                    alert("O valor deve estar entre 0 e 10!");
                                } else {
                                    alert("Formato valido!");
                                }
                            } else {
                                alert("Formato invalido!");
                            }

                            actionAjax();

                        }



        </script>
    </body>
</html>
