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
import java.util.List;
import ssc.modelos.basicas.Servico;
import ssc.modelos.basicas.Acesso;

/**
 *
 * @author Andrew
 */
public class AdminServico extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        Usuario usuarioAtual = (Usuario) session.getAttribute("usuarioAtual");
        Fachada fachada = new Fachada();
        String acao = request.getParameter("acao");
        if(usuarioAtual != null && usuarioAtual.getAcesso() == Acesso.ADMIN) {
            try{
                Servico servico = new Servico();
                List<Servico> servicos = fachada.listar(servico);              
                
                if(acao != null && acao.equals("criar")) {
                    Servico s = new Servico();
                    s.setTitulo(request.getParameter("titulo"));
                    s.setDescricao(request.getParameter("descricao"));
                    fachada.criar(s);
                    request.setAttribute("success", "Serviço cadastrado com sucesso.");
                    servicos = fachada.listar(servico);
                }else if(acao != null && acao.equals("remover")) {
                    Servico s = new Servico();
                    s.setId(Integer.parseInt(request.getParameter("id_servico")));
                    fachada.remover(s);
                    request.setAttribute("success", "Serviço removido com sucesso.");
                    servicos = fachada.listar(servico);
                }else if(acao != null && acao.equals("editar")) {
                    Servico s = new Servico();
                    s.setId(Integer.parseInt(request.getParameter("id_servico")));
                    Servico servicoEditar = fachada.selecionar(s);
                    request.setAttribute("servicoEditar", servicoEditar);
                }else if(acao != null && acao.equals("atualizar")) {
                    Servico s = new Servico();
                    s.setId(Integer.parseInt(request.getParameter("id_servico")));
                    s.setTitulo(request.getParameter("titulo"));
                    s.setDescricao(request.getParameter("descricao"));
                    fachada.atualizar(s); 
                    request.setAttribute("success", "Serviço atualizado com sucesso.");
                    servicos = fachada.listar(servico);
                }

                request.setAttribute("servicos", servicos);
                request.getRequestDispatcher("/admin_servico.jsp").forward(request, response);
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
