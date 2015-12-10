package controller;

import dao.AlunoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AtualizarController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            int mat = Integer.parseInt(request.getParameter("matricula"));
            String nome = request.getParameter("nome");
            double av1 = Double.parseDouble(request.getParameter("av1"));
            double av2 = Double.parseDouble(request.getParameter("av2"));
            char n[] = nome.toCharArray();
            if (av1 > 10 || av2 > 10) {
                response.sendRedirect("/sistemaalunos/erro.html");
            } else if (av1 < 0 || av2 < 0) {
                response.sendRedirect("/sistemaalunos/erro.html");
            } else if(nome.length() == 0 || n[0]== ' '){
                response.sendRedirect("/sistemaalunos/erro.html");           
            }else{
                AlunoDAO aluno = new AlunoDAO();
                aluno.updateAluno(mat, nome, av1, av2);
                response.sendRedirect("/sistemaalunos/confirmacao.html");
            }

        } catch (Exception e) {
            response.sendRedirect("/sistemaalunos/erro.html");
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("/sistemaalunos/ServletErro");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
