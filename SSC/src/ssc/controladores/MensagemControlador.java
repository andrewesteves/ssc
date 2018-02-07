/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssc.controladores;

import ssc.modelos.basicas.Mensagem;
import ssc.modelos.dados.DAOFabrica;
import ssc.modelos.dados.repositorios.MensagemDAO;
import java.util.List;

/**
 *
 * @author Andrew
 */
public class MensagemControlador {
    
    public void criar(Mensagem m) throws Exception {
        if(m.getUsuario() == null) {
            throw new Exception("USUÁRIO é obrigatório.");
        }
        if(m.getAtendimento() == null) {
            throw new Exception("ATENDIMENTO é obrigatório.");
        }
        if(m.getDescricao().trim().equals("")) {
            throw new Exception("DESCRIÇÃO é obrigatório.");
        }
        MensagemDAO mensagemDAO = DAOFabrica.getMensagemDAO();
        mensagemDAO.criar(m);
    }
    
    public void atualizar(Mensagem m) throws Exception {
        if(m.getId() < 1) {
            throw new Exception("IDENTIFICAÇÃO é obrigatória.");
        }
        if(m.getUsuario() == null) {
            throw new Exception("USUÁRIO é obrigatório.");
        }
        if(m.getAtendimento() == null) {
            throw new Exception("ATENDIMENTO é obrigatório.");
        }
        if(m.getDescricao().trim().equals("")) {
            throw new Exception("DESCRIÇÃO é obrigatório.");
        }
        MensagemDAO mensagemDAO = DAOFabrica.getMensagemDAO();
        mensagemDAO.atualizar(m);
    }
    
    public List<Mensagem> listar() throws Exception {
        MensagemDAO mensagemDAO = DAOFabrica.getMensagemDAO();
        return mensagemDAO.listar();
    }
    
    public Mensagem selecionar(Mensagem m) throws Exception {
        if(m.getId() < 1) {
            throw new Exception("IDENTIFICAÇÃO é obrigatória.");
        }
        MensagemDAO mensagemDAO = DAOFabrica.getMensagemDAO();
        return mensagemDAO.selecionar(m.getId());
    }
    
    public void remover(Mensagem m) throws Exception {
        if(m.getId() < 1) {
            throw new Exception("IDENTIFICAÇÃO é obrigatória.");
        }
        MensagemDAO mensagemDAO = DAOFabrica.getMensagemDAO();
        mensagemDAO.remover(m);
    }
}
