/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            Usuario user = null;
            try {
                user = UsuarioDAO.getUsuario(login, senha);
            } catch (Exception ex) {
                throw new ServletException("SQL erro - Login do Usuario");
            }
            if (user == null) {
                enviarTexto(response, "Erro");
            } else {
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(2000);
                session.setAttribute("usuario.logado", user);
                enviarTexto(response, "OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    private void enviarTexto(HttpServletResponse response, String texto) throws IOException {
        PrintWriter out = response.getWriter();
        out.print(texto);
        out.close();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("/sistemaalunos/ServletErro");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
