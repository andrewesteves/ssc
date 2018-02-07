/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssc.controladores;

import ssc.modelos.basicas.Usuario;
import ssc.modelos.dados.DAOFabrica;
import ssc.modelos.dados.repositorios.UsuarioDAO;
import java.util.List;

/**
 *
 * @author Andrew
 */
public class UsuarioControlador {
    
    public void criar(Usuario u) throws Exception {
        if(u.getNome().trim().equals("")) {
            throw new Exception("NOME é obrigatório.");
        }
        if(u.getEmail().trim().equals("")) {
            throw new Exception("E-MAIL é obrigatório.");
        }
        if(u.getSenha().trim().equals("")) {
            throw new Exception("SENHA é obrigatória.");
        }
        UsuarioDAO usuarioDAO = DAOFabrica.getUsuarioDAO();
        usuarioDAO.criar(u);
    }
    
    public void atualizar(Usuario u) throws Exception {
        if(u.getId() < 1) {
            throw new Exception("IDENTIFICAÇÃO é obrigatória.");
        }
        if(u.getNome().trim().equals("")) {
            throw new Exception("NOME é obrigatório.");
        }
        if(u.getEmail().trim().equals("")) {
            throw new Exception("E-MAIL é obrigatório.");
        }
        if(u.getSenha().trim().equals("")) {
            throw new Exception("SENHA é obrigatória.");
        }
        UsuarioDAO usuarioDAO = DAOFabrica.getUsuarioDAO();
        usuarioDAO.atualizar(u);
    }
    
    public List<Usuario> listar() throws Exception {
        UsuarioDAO usuarioDAO = DAOFabrica.getUsuarioDAO();
        return usuarioDAO.listar();
    }

    public Usuario selecionar(Usuario u) throws Exception {
        if(u.getId() < 1) {
            throw new Exception("IDENTIFICAÇÃO é obrigatória.");
        }
        UsuarioDAO usuarioDAO = DAOFabrica.getUsuarioDAO();
        return usuarioDAO.selecionar(u.getId());
    }
    
    public void remover(Usuario u) throws Exception {
        if(u.getId() < 1) {
            throw new Exception("IDENTIFICAÇÃO é obrigatória.");
        }
        UsuarioDAO usuarioDAO = DAOFabrica.getUsuarioDAO();
        usuarioDAO.remover(u);
    }
    
    public Usuario autenticar(String email, String senha) throws Exception {
        if(email.trim().equals("")) {
            throw new Exception("Informe o e-mail.");
        }
        if(senha.trim().equals("")) {
            throw new Exception("Informe a senha.");
        }
        UsuarioDAO usuarioDAO = DAOFabrica.getUsuarioDAO();
        return usuarioDAO.autenticar(email, senha);
    }
}
