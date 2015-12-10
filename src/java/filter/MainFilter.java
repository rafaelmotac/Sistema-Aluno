/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import model.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RMC
 */
public class MainFilter implements Filter {

    @Override
    public void init(FilterConfig fc) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sr;
        HttpServletResponse response = (HttpServletResponse) sr1;
        String url = request.getServletPath();       
        String usuario = getUsuario(request, response);
        System.out.println("Usuario \"" + usuario + "\" acessando a url: " + url);             
        //fc.doFilter(sr, sr1);
      
        
        if (!(url.startsWith("/login") || (url.startsWith("/Login")) || (url.startsWith("/css/bootstrap.cs")) || (url.startsWith("/css/signin.css")))) {
            HttpSession session = request.getSession(false);

            if ((session != null) && (session.getAttribute("usuario.logado") != null)) {
                fc.doFilter(sr, sr1);
            } else {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        } else {
            fc.doFilter(sr, sr1);
        }
    }

    private String getUsuario(HttpServletRequest request, HttpServletResponse response) {
        Usuario user = (Usuario) request.getSession().getAttribute("usuario.logado");
        if (user == null) {
            return "<deslogado>";
        } else {
            return user.getLogin();
        }
    }

    @Override
    public void destroy() {

    }

}
