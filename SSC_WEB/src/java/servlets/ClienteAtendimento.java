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
import ssc.modelos.basicas.Atendimento;
import ssc.modelos.basicas.Acesso;
import ssc.Fachada;
import java.util.List;
import java.util.GregorianCalendar;

/**
 *
 * @author Andrew
 */
public class ClienteAtendimento extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Usuario usuarioAtual = (Usuario) session.getAttribute("usuarioAtual");
        Fachada fachada = new Fachada();
        String acao = request.getParameter("acao");
        if(usuarioAtual != null && usuarioAtual.getAcesso() == Acesso.CLIENTE) {
            try{
                if(acao != null && acao.equals("criar")) {
                    Atendimento a = new Atendimento();
                    a.setAssunto(request.getParameter("assunto"));
                    a.setDescricao(request.getParameter("descricao"));
                    a.setSituacao("Aberto");
                    a.setCriadoEm(new GregorianCalendar());
                    a.setUsuario(usuarioAtual);
                    fachada.criar(a);
                    usuarioAtual = fachada.autenticar(usuarioAtual.getEmail(), usuarioAtual.getSenha()); 
                    request.setAttribute("success", "Atendimento registrado com sucesso.");
                }                               
                List<Atendimento> atendimentos = usuarioAtual.getAtendimentos();
                request.setAttribute("atendimentos", atendimentos);
                request.getRequestDispatcher("/cliente_atendimento.jsp").forward(request, response);
            }catch(Exception e) {
               response.sendRedirect("http://localhost:8080/SSC_WEB/Login?error=invalid&message=" + e.getMessage()); 
            }            
        }else {
            response.sendRedirect("http://localhost:8080/SSC_WEB/Login?error=invalid");
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
