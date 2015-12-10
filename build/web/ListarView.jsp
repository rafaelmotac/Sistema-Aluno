<%@page import="java.util.ArrayList"%>
<%@page import="Model.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Model.Aluno> alunos = (ArrayList<Model.Aluno>) request.getAttribute("alunos");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Alunos</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/npm.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="container">
            <jsp:include page="navbar.jsp" flush="true" />
            <div class="jumbotron">
                <table class="table">
                    <tr>
                        <th>Nome</th>
                        <th>Matrícula</th>
                        <th>Nota AV1</th>
                        <th>Nota AV2</th>
                        <th>Média</th>
                    </tr>
                    <%
                        for (Model.Aluno lista : alunos) {
                    %>

                    <tr>                      
                        <td><%=lista.getNome()%></td>
                        <td><%=lista.getMat()%></td>
                        <td><%=lista.getAv1()%></td>
                        <td><%=lista.getAv2()%></td>
                        <td><%=(lista.getAv1() + lista.getAv2()) / 2%></td>
                    </tr>
                    <% }%>
                </table>
            </div>
        </div>
    </body>
</html>
