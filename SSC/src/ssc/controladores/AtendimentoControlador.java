/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssc.controladores;

import ssc.modelos.basicas.Atendimento;
import ssc.modelos.dados.DAOFabrica;
import ssc.modelos.dados.repositorios.AtendimentoDAO;
import java.util.List;

/**
 *
 * @author Andrew
 */
public class AtendimentoControlador {
    
    public void criar(Atendimento a) throws Exception {
        if(a.getUsuario() == null) {
            throw new Exception("USUÁRIO é obrigatório.");
        }
        if(a.getAssunto().trim().equals("")) {
            throw new Exception("ASSUNTO é obrigatório.");
        }
        if(a.getDescricao().trim().equals("")) {
            throw new Exception("DESCRIÇÃO é obrigatório.");
        }
        AtendimentoDAO atendimentoDAO = DAOFabrica.getAtendimentoDAO();
        atendimentoDAO.criar(a);
    }
    
    public void atualizar(Atendimento a) throws Exception {
        if(a.getId() < 1) {
            throw new Exception("IDENTIFICAÇÃO é obrigatória.");
        }
        if(a.getUsuario() == null) {
            throw new Exception("USUÁRIO é obrigatório.");
        }
        if(a.getAssunto().trim().equals("")) {
            throw new Exception("ASSUNTO é obrigatório.");
        }
        if(a.getDescricao().trim().equals("")) {
            throw new Exception("DESCRIÇÃO é obrigatório.");
        }
        AtendimentoDAO atendimentoDAO = DAOFabrica.getAtendimentoDAO();
        atendimentoDAO.atualizar(a);
    }
    
    public List<Atendimento> listar() throws Exception {
        AtendimentoDAO atendimentoDAO = DAOFabrica.getAtendimentoDAO();
        return atendimentoDAO.listar();
    }
    
    public Atendimento selecionar(Atendimento a) throws Exception {
        if(a.getId() < 1) {
            throw new Exception("IDENTIFICAÇÃO é obrigatória.");
        }
        AtendimentoDAO atendimentoDAO = DAOFabrica.getAtendimentoDAO();
        return atendimentoDAO.selecionar(a.getId());
    }
    
    public void remover(Atendimento a) throws Exception {
        if(a.getId() < 1) {
            throw new Exception("IDENTIFICAÇÃO é obrigatória.");
        }
        AtendimentoDAO atendimentoDAO = DAOFabrica.getAtendimentoDAO();
        atendimentoDAO.remover(a);
    }
}
