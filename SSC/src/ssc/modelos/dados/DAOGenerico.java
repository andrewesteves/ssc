/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssc.modelos.dados;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.io.Serializable;

/**
 *
 * @author Andrew
 */
public abstract class DAOGenerico<Entity> {
    private EntityManagerFactory entityManagerFactory;
    private Class<Entity> persistentClass;
    
    public DAOGenerico(EntityManagerFactory emf) {
        entityManagerFactory = emf;
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass(); 
        persistentClass = (Class<Entity>) parameterizedType.getActualTypeArguments()[0];
    }
    
    public List<Entity> listar() {
        List<Entity> instance = null;
        EntityManager em = this.entityManagerFactory.createEntityManager();
        try {
            instance = ((List<Entity>) em.createQuery("from " + persistentClass.getName()).getResultList());
        }catch(RuntimeException e) {
            e.printStackTrace();
        }
        return instance;
    }
    
    public Entity selecionar(int chave) {
        Entity instance = null;
        EntityManager em = this.entityManagerFactory.createEntityManager();
        try {
            instance = (Entity) em.find(persistentClass, chave);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        em.close();
        return instance;
    }
    
    public void criar(Entity objeto) {
        EntityManager em = this.entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(objeto);
            et.commit();
        }catch(PersistenceException e) {
            et.rollback();
        }finally{
            em.close();
        }
    }
    
    public void criarColecao(List<Entity> colecao) {
        EntityManager em = this.entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            for(Entity objeto : colecao) {
                em.persist(objeto);
            }
            et.commit();
            em.close();
        }catch(PersistenceException e) {
            et.rollback();
        }
    }
    
    public Entity atualizar(Entity objeto) {
        EntityManager em = this.entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        objeto = em.merge(objeto);
        et.commit();
        em.close();
        return objeto;
    }
    
    public void remover(Entity objeto) {
        EntityManager em = this.entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        objeto = em.merge(objeto);
        em.remove(objeto);
        et.commit();
        em.close();
    }
}
