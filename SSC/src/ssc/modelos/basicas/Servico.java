/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssc.modelos.basicas;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Andrew
 */
@Entity
public class Servico {
    @Id
    @GeneratedValue
    private int id;
    
    private String titulo;
    private String descricao;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "servico_usuario", 
            joinColumns = @JoinColumn(name = "id_servico"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario"))
    @Cascade(CascadeType.ALL)
    private List<Usuario> clientes;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the clientes
     */
    public List<Usuario> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(List<Usuario> clientes) {
        this.clientes = clientes;
    }
}
