/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssc.modelos.dados.repositorios;

import ssc.modelos.basicas.Atendimento;
import ssc.modelos.dados.contratos.IAtendimentoDAO;
import ssc.modelos.dados.DAOGenerico;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Andrew
 */
public class AtendimentoDAO extends DAOGenerico<Atendimento> implements IAtendimentoDAO {
    public AtendimentoDAO(EntityManagerFactory emf) {
        super(emf);
    }
}
