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
import ssc.Fachada;
import ssc.modelos.basicas.Usuario;
import java.util.List;
import ssc.modelos.basicas.Acesso;

/**
 *
 * @author Andrew
 */
public class AdminUsuario extends HttpServlet {

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
                
                Usuario usuario = new Usuario();
                List<Usuario> usuarios = fachada.listar(usuario);

                if(acao != null && acao.equals("criar")) {
                    Usuario u = new Usuario();
                    u.setNome(request.getParameter("nome"));
                    u.setEmail(request.getParameter("email"));
                    u.setSenha(request.getParameter("senha"));
                    if("0".equals(request.getParameter("acesso"))) {
                        u.setAcesso(Acesso.ADMIN);
                    }else {
                        u.setAcesso(Acesso.CLIENTE);
                    }                    
                    fachada.criar(u);
                    request.setAttribute("success", "Usuário cadastrado com sucesso.");
                    usuarios = fachada.listar(usuario);
                }else if(acao != null && acao.equals("remover")) {
                    Usuario u = new Usuario();
                    u.setId(Integer.parseInt(request.getParameter("id_usuario")));
                    fachada.remover(u);
                    request.setAttribute("success", "Usuário removido com sucesso.");
                    usuarios = fachada.listar(usuario);
                }else if(acao != null && acao.equals("editar")) {
                    Usuario u = new Usuario();
                    u.setId(Integer.parseInt(request.getParameter("id_usuario")));
                    Usuario usuarioEditar = fachada.selecionar(u);
                    request.setAttribute("usuarioEditar", usuarioEditar);
                }else if(acao != null && acao.equals("atualizar")) {
                    Usuario u = new Usuario();
                    u.setId(Integer.parseInt(request.getParameter("id_usuario")));
                    u.setNome(request.getParameter("nome"));
                    u.setEmail(request.getParameter("email"));
                    u.setSenha(request.getParameter("senha"));
                    if("0".equals(request.getParameter("acesso"))) {
                        u.setAcesso(Acesso.ADMIN);
                    }else {
                        u.setAcesso(Acesso.CLIENTE);
                    }
                    fachada.atualizar(u); 
                    request.setAttribute("success", "Usuário atualizado com sucesso.");
                    usuarios = fachada.listar(usuario);
                }
                
                request.setAttribute("usuarios", usuarios);
                request.getRequestDispatcher("/admin_usuario.jsp").forward(request, response);
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
