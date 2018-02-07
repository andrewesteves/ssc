/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssc.modelos.dados;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ssc.modelos.dados.repositorios.UsuarioDAO;
import ssc.modelos.dados.repositorios.ServicoDAO;
import ssc.modelos.dados.repositorios.AtendimentoDAO;
import ssc.modelos.dados.repositorios.MensagemDAO;

/**
 *
 * @author Andrew
 */
public class DAOFabrica {
    private static final EntityManagerFactory factory;
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOFabrica.class.getName()).log(Level.SEVERE, null, ex);
        }
	factory = Persistence.createEntityManagerFactory("ssc");		
    }
    
    public static UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAO(factory);
    }
    
    public static ServicoDAO getServicoDAO() {
        return new ServicoDAO(factory);
    }
    
    public static AtendimentoDAO getAtendimentoDAO() {
        return new AtendimentoDAO(factory);
    }
    
    public static MensagemDAO getMensagemDAO() {
        return new MensagemDAO(factory);
    }
}
