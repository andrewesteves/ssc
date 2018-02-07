/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssc.controladores;

import ssc.modelos.basicas.Servico;
import ssc.modelos.dados.DAOFabrica;
import ssc.modelos.dados.repositorios.ServicoDAO;
import java.util.List;

/**
 *
 * @author Andrew
 */
public class ServicoControlador {
    
    public void criar(Servico s) throws Exception {
        if(s.getTitulo().trim().equals("")) {
            throw new Exception("TÍTULO é obrigatório.");
        }
        ServicoDAO servicoDAO = DAOFabrica.getServicoDAO();
        servicoDAO.criar(s);
    }
    
    public void atualizar(Servico s) throws Exception {
        if(s.getId() < 1) {
            throw new Exception("IDENTIFICAÇÃO é obrigatória.");
        }
        if(s.getTitulo().trim().equals("")) {
            throw new Exception("TÍTULO é obrigatório.");
        }
        ServicoDAO servicoDAO = DAOFabrica.getServicoDAO();
        servicoDAO.atualizar(s);
    }
    
    public List<Servico> listar() throws Exception {
        ServicoDAO servicoDAO = DAOFabrica.getServicoDAO();
        return servicoDAO.listar();
    }

    public Servico selecionar(Servico s) throws Exception {
        if(s.getId() < 1) {
            throw new Exception("IDENTIFICAÇÃO é obrigatória.");
        }
        ServicoDAO servicoDAO = DAOFabrica.getServicoDAO();
        return servicoDAO.selecionar(s.getId());
    }
    
    public void remover(Servico s) throws Exception {
        if(s.getId() < 1) {
            throw new Exception("IDENTIFICAÇÃO é obrigatória.");
        }
        ServicoDAO servicoDAO = DAOFabrica.getServicoDAO();
        servicoDAO.remover(s);
    }
}
