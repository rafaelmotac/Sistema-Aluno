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
        <title>Deletar Aluno</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">       
    </head>
    <body>
        <div class="container">
            <jsp:include page="navbar.jsp" flush="true" />

            <!--
            <nav class="navbar navbar-default">   
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="/sistemaalunos/index.html">Sistema de Alunos</a>
                    </div>  
                    <div class="collapse navbar-collapse">
                        <ul class="nav navbar-nav">                           
                            <li><a href="/sistemaalunos/cadastraraluno.html">Cadastrar Alunos</a></li>
                            <li><a href="/sistemaalunos/Listar">Listar Alunos</a></li>
                            <li><a href="/sistemaalunos/atualizarNome.jsp">Atualizar Nome</a></li>
                            <li><a href="/sistemaalunos/atualizaralunoJSP.jsp">Atualizar Alunos</a></li>
                            <li><a href="/sistemaalunos/deletaralunoJSP.jsp">Deletar Alunos</a></li>                          
                            <li><a href="/sistemaalunos/cadastrarnotasJSP.jsp">Cadastrar Notas</a></li>
                        </ul>
                    </div>
                </div> 
            </nav>
            -->
            <div class="jumbotron">
                <form action="Deletar" method="POST">
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
                    <input class="btn btn-danger" type="submit" value="Deletar Aluno">*<br><br>
                    *Cuidado, a operação não poderá ser desfeita.
                </form>
            </div>
        </div>
    </body>
</html>
