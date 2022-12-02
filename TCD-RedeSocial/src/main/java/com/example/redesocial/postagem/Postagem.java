package com.example.redesocial.postagem;

import com.example.redesocial.comunidade.Comunidade;
import com.example.redesocial.usuario.Usuario;

import java.io.Serializable;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
    @NamedQuery(
            name = "findPostagens",
            query = "SELECT p FROM Postagem p"
    )
})
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

    @OneToMany(mappedBy = "postagemPai")
    private List<Postagem> respostas;

    @ManyToOne
    @JoinColumn(name = "postagem_pai_id")
    private Postagem postagemPai;

    @ManyToMany
    @JoinTable(name = "curte",
    joinColumns = @JoinColumn(name = "postagem_id"),
    inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> usuariosCurtiram;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "postagem_id")
    private List<Midia> midias;

    public Postagem() {
    }

    public Postagem(String conteudo, Usuario usuario, List<Usuario> usuariosCurtiram, List<Midia> midias) {
        this.conteudo = conteudo;
        this.usuario = usuario;
        this.usuariosCurtiram = usuariosCurtiram;
        this.midias = midias;
    }

    public Postagem(String conteudo, Usuario usuario, List<Usuario> usuariosCurtiram) {
        this.conteudo = conteudo;
        this.usuario = usuario;
        this.usuariosCurtiram = usuariosCurtiram;
    }

    public Postagem(String conteudo, Usuario usuario, Postagem postagemPai, List<Usuario> usuariosCurtiram) {
        this.conteudo = conteudo;
        this.usuario = usuario;
        this.postagemPai = postagemPai;
        this.usuariosCurtiram = usuariosCurtiram;
    }
    
    
    public Postagem(String conteudo, Usuario usuario, Postagem postagemPai, List<Usuario> usuariosCurtiram, List<Midia> midias) {
        this.conteudo = conteudo;
        this.usuario = usuario;
        this.postagemPai = postagemPai;
        this.usuariosCurtiram = usuariosCurtiram;
        this.midias = midias;
    }

    public Postagem(String conteudo, Comunidade comunidade, Usuario usuario, List<Usuario> usuariosCurtiram) {
        this.conteudo = conteudo;
        this.comunidade = comunidade;
        this.usuario = usuario;
        this.usuariosCurtiram = usuariosCurtiram;
    }

    
    
    
    // <editor-fold  defaultstate="collapsed" desc="Getters/Setters" >
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

    public List<Usuario> getUsuariosCurtiram() {
        return usuariosCurtiram;
    }

    public void setUsuariosCurtiram(List<Usuario> usuariosCurtiram) {
        this.usuariosCurtiram = usuariosCurtiram;
    }

    public List<Midia> getMidias() {
        return midias;
    }

    public void setMidias(List<Midia> midias) {
        this.midias = midias;
    }

    public Long getId() {
        return id;
    }

    public Postagem getPostagemPai() {
        return postagemPai;
    }

    public void setPostagemPai(Postagem postagemPai) {
        this.postagemPai = postagemPai;
    }
    
    // </editor-fold >
}
