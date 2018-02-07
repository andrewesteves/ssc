/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssc;

import ssc.modelos.basicas.Usuario;
import ssc.controladores.UsuarioControlador;
import ssc.modelos.basicas.Servico;
import ssc.controladores.ServicoControlador;
import ssc.modelos.basicas.Atendimento;
import ssc.controladores.AtendimentoControlador;
import ssc.modelos.basicas.Mensagem;
import ssc.controladores.MensagemControlador;
import java.util.List;

/**
 *
 * @author Andrew
 */
public class Fachada {
    
    // Usuario
    public void criar(Usuario u) throws Exception {
        UsuarioControlador c = new UsuarioControlador();
        c.criar(u);
    }
    
    public void atualizar(Usuario u) throws Exception {
        UsuarioControlador c = new UsuarioControlador();
        c.atualizar(u);
    }
    
    public List<Usuario> listar(Usuario u) throws Exception {
        UsuarioControlador c = new UsuarioControlador();
        return c.listar();
    }
    
    public Usuario selecionar(Usuario u) throws Exception {
        UsuarioControlador c = new UsuarioControlador();
        return c.selecionar(u);
    }
    
    public void remover(Usuario u) throws Exception {
        UsuarioControlador c = new UsuarioControlador();
        c.remover(u);
    }
    
    public Usuario autenticar(String email, String senha) throws Exception {
        UsuarioControlador c = new UsuarioControlador();
        return c.autenticar(email, senha);
    }

    // Servico
    public void criar(Servico s) throws Exception {
        ServicoControlador c = new ServicoControlador();
        c.criar(s);
    }
    
    public void atualizar(Servico s) throws Exception {
        ServicoControlador c = new ServicoControlador();
        c.atualizar(s);
    }
    
    public List<Servico> listar(Servico s) throws Exception {
        ServicoControlador c = new ServicoControlador();
        return c.listar();
    }
    
    public Servico selecionar(Servico s) throws Exception {
        ServicoControlador c = new ServicoControlador();
        return c.selecionar(s);
    }
    
    public void remover(Servico s) throws Exception {
        ServicoControlador c = new ServicoControlador();
        c.remover(s);
    }

    // Atendimento
    public void criar(Atendimento a) throws Exception {
        AtendimentoControlador c = new AtendimentoControlador();
        c.criar(a);
    }
    
    public void atualizar(Atendimento a) throws Exception {
        AtendimentoControlador c = new AtendimentoControlador();
        c.atualizar(a);
    }
    
    public List<Atendimento> listar(Atendimento a) throws Exception {
        AtendimentoControlador c = new AtendimentoControlador();
        return c.listar();
    }
    
    public Atendimento selecionar(Atendimento a) throws Exception {
        AtendimentoControlador c = new AtendimentoControlador();
        return c.selecionar(a);
    }
    
    public void remover(Atendimento a) throws Exception {
        AtendimentoControlador c = new AtendimentoControlador();
        c.remover(a);
    }

    // Mensagem
    public void criar(Mensagem m) throws Exception {
        MensagemControlador c = new MensagemControlador();
        c.criar(m);
    }
    
    public void atualizar(Mensagem m) throws Exception {
        MensagemControlador c = new MensagemControlador();
        c.atualizar(m);
    }
    
    public List<Mensagem> listar(Mensagem m) throws Exception {
        MensagemControlador c = new MensagemControlador();
        return c.listar();
    }
    
    public Mensagem selecionar(Mensagem m) throws Exception {
        MensagemControlador c = new MensagemControlador();
        return c.selecionar(m);
    }
    
    public void remover(Mensagem m) throws Exception {
        MensagemControlador c = new MensagemControlador();
        c.remover(m);
    }
}
