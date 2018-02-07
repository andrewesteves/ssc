/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssc;

import ssc.modelos.basicas.Acesso;
import ssc.modelos.basicas.Usuario;
import ssc.modelos.basicas.Servico;
import ssc.modelos.dados.DAOFabrica;
import ssc.modelos.dados.repositorios.UsuarioDAO;
import ssc.modelos.dados.repositorios.ServicoDAO;

import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class SSC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Inserir
        /*
        Usuario usuario = new Usuario();
        usuario.setNome("Bill Gates");
        usuario.setEmail("bill@microsoft.com");
        usuario.setSenha("123456");
        usuario.setAcesso(Acesso.ADMIN);

        UsuarioDAO usuarioDAO = DAOFabrica.getUsuarioDAO();
        usuarioDAO.criar(usuario);

        Servico servico = new Servico();
        servico.setTitulo("Design gráfica");
        servico.setDescricao("Criação de protópipos e artefatos.");

        ServicoDAO servicoDAO = DAOFabrica.getServicoDAO();
        servicoDAO.criar(servico);

        // Atualizar        
        UsuarioDAO clienteDAO = DAOFabrica.getUsuarioDAO();
        Usuario cliente = clienteDAO.selecionar(1);
        cliente.setServicos(new ArrayList<Servico>(){{
            add(DAOFabrica.getServicoDAO().selecionar(1));
        }});
        clienteDAO.atualizar(cliente);
        */
        
        Servico servico = new Servico();
        servico.setTitulo("Design gráfico");
        servico.setDescricao("Criação de protópipos e artefatos.");
        
        Fachada f = new Fachada();
        try{
            f.criar(servico);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
