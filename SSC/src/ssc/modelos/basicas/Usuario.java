/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssc.modelos.basicas;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Andrew
 */
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private int id;
    
    private String nome;
    private String email;
    private String senha;
    private Acesso acesso;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "servico_usuario", 
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_servico"))
    @Cascade(CascadeType.ALL)
    private List<Servico> servicos;
    
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<Atendimento> atendimentos;

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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the acesso
     */
    public Acesso getAcesso() {
        return acesso;
    }

    /**
     * @param acesso the acesso to set
     */
    public void setAcesso(Acesso acesso) {
        this.acesso = acesso;
    }

    /**
     * @return the servicos
     */
    public List<Servico> getServicos() {
        return servicos;
    }

    /**
     * @param servicos the servicos to set
     */
    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    /**
     * @return the atendimentos
     */
    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    /**
     * @param atendimentos the atendimentos to set
     */
    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }
}
