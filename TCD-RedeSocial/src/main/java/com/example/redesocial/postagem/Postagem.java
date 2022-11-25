package com.example.redesocial.postagem;

import com.example.redesocial.comunidade.Comunidade;
import com.example.redesocial.postagem.reacao.Reacao;
import com.example.redesocial.usuario.Usuario;

import java.io.Serializable;

import javax.persistence.*;
import java.util.List;

@Entity
public class Postagem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2500)
    private String conteudo;

    @ManyToOne
    private Comunidade comunidade;
    @ManyToOne
    private Usuario usuario;

    @OneToMany
    @JoinColumn(name = "postagem_pai_id")
    private List<Postagem> respostas;

    @OneToMany
    @JoinColumn(name = "postagem_id")
    private List<Reacao> reacoes;

    // <editor-folder  defaultstate="collapsed" desc="Getters/Setters" >
    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Comunidade getComunidade() {
        return comunidade;
    }

    public void setComunidade(Comunidade comunidade) {
        this.comunidade = comunidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Postagem> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Postagem> respostas) {
        this.respostas = respostas;
    }

    public List<Reacao> getReacoes() {
        return reacoes;
    }

    public void setReacoes(List<Reacao> reacoes) {
        this.reacoes = reacoes;
    }

    public Long getId() {
        return id;
    }

    // </editor-folder >
}
