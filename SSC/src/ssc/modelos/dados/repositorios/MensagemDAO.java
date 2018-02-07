/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssc.modelos.dados.repositorios;

import ssc.modelos.basicas.Mensagem;
import ssc.modelos.dados.contratos.IMensagemDAO;
import ssc.modelos.dados.DAOGenerico;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Andrew
 */
public class MensagemDAO extends DAOGenerico<Mensagem> implements IMensagemDAO {
    public MensagemDAO(EntityManagerFactory emf) {
        super(emf);
    }
}
