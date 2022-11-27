package com.example.redesocial.comunidade;

import com.example.redesocial.postagem.Postagem;
import com.example.redesocial.usuario.Usuario;
import java.io.Serializable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Comunidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;
    @ManyToOne
    private Usuario dono;

    @OneToMany
    @JoinColumn(name = "comunidade_id")
    private List<Postagem> postagens;

    @ManyToMany(mappedBy = "comunidades")
    private List<Usuario> membros;

    public Comunidade() {
        this.dataCriacao = LocalDate.now();
    }


    // <editor-folder  defaultstate="collapsed" desc="Getters/Setters" >

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getDono() {
        return dono;
    }

    public void setDono(Usuario dono) {
        this.dono = dono;
    }

    public List<Postagem> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagem> postagens) {
        this.postagens = postagens;
    }



    // </editor-folder>
}
