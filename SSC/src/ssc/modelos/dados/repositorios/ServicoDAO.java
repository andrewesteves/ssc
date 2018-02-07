/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssc.modelos.dados.repositorios;

import ssc.modelos.basicas.Servico;
import ssc.modelos.dados.contratos.IServicoDAO;
import ssc.modelos.dados.DAOGenerico;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Andrew
 */
public class ServicoDAO extends DAOGenerico<Servico> implements IServicoDAO {
    public ServicoDAO(EntityManagerFactory emf) {
        super(emf);
    }
}
