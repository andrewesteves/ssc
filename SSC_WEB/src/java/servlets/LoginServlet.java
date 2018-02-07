/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ssc.modelos.basicas.Usuario;
import ssc.Fachada;
import ssc.modelos.basicas.Acesso;

/**
 *
 * @author Andrew
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
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
        String acao = request.getParameter("acao");
        
        if(acao != null && acao.equals("logout")) {
            HttpSession session = request.getSession(true);
            session.invalidate();
        }
        
        request.getRequestDispatcher("/login.jsp").forward(request, response);
        processRequest(request, response);
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
        Fachada fachada = new Fachada();
        try{
            Usuario usuarioAtual = fachada.autenticar(request.getParameter("email"), request.getParameter("senha"));
            HttpSession session = request.getSession(true);
            session.setAttribute("usuarioAtual", usuarioAtual);
            if(usuarioAtual.getAcesso() == Acesso.ADMIN) {
                response.sendRedirect("http://localhost:8080/SSC_WEB/AdminAtendimento");
                return;
            }           
            response.sendRedirect("http://localhost:8080/SSC_WEB/ClienteAtendimento");
        }catch(Exception e) {
            response.sendRedirect("http://localhost:8080/SSC_WEB/Login?error=invalid&message=" + e.getMessage());
        }        
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
