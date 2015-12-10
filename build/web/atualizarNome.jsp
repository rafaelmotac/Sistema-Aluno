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
        <title>Atualizar Nome</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="container">
            <jsp:include page="navbar.jsp" flush="true" />
            <div class="jumbotron">
                <form action="AtualizarNome" method="POST">
                    <p>Matricula do Aluno:</p>
                    <select required="required" name="matricula">
                        <option value="">Selecione um aluno..</option>
                        <%
                            for (Model.Aluno lista : alunos) {

                        %>
                        <option value="<%=lista.getMat()%>"><%=lista.getNome()%> - <%=lista.getMat()%></option>
                        <%}%>                      
                    </select>
                    <br><br>
                    <p>Nome do aluno:</p>
                    <input type="text"  required="required" name="nome" placeholder="A-Z"><br><br>              
                    <input class="btn btn-primary" type="submit" value="Atualizar"/>
                </form>
            </div>
        </div>
    </body>
</html>
