/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssc.modelos.dados.repositorios;

import ssc.modelos.basicas.Usuario;
import ssc.modelos.dados.contratos.IUsuarioDAO;
import ssc.modelos.dados.DAOGenerico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Andrew
 */
public class UsuarioDAO extends DAOGenerico<Usuario> implements IUsuarioDAO {
    private EntityManagerFactory emf;
    
    public UsuarioDAO(EntityManagerFactory emf) {
        super(emf);
        this.emf = emf;
    }
    
    public Usuario autenticar(String email, String senha) {
        EntityManager em = this.emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        
        Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha", Usuario.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        
        Usuario usuarioAtual = (Usuario) query.getSingleResult();
        
        em.close();
        return usuarioAtual;
    }
}
