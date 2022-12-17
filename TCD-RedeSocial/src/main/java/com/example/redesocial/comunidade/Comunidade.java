package com.example.redesocial.comunidade;

import com.example.redesocial.postagem.Postagem;
import com.example.redesocial.usuario.Usuario;
import com.example.redesocial.utils.json.customserializers.LocalDateSerializer;
import com.example.redesocial.utils.json.customserializers.PostagemListSerializer;
import com.example.redesocial.utils.json.customserializers.UsuarioListSerializer;
import com.example.redesocial.utils.json.customserializers.UsuarioSingleSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NamedQueries({
    @NamedQuery(
            name = "findComunidades",
            query = "SELECT c FROM Comunidade c"
    )
})
public class Comunidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, unique = true)
    private String nome;
    @Column(length = 400)
    private String descricao;

    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataCriacao;

    @ManyToOne
    @JsonSerialize(using = UsuarioSingleSerializer.class)
    private Usuario dono;

    @OneToMany
    @JoinColumn(name = "comunidade_id")
    @JsonSerialize(using = PostagemListSerializer.class)
    private List<Postagem> postagens;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "participa")
    @JsonSerialize(using = UsuarioListSerializer.class)
    private List<Usuario> membros;

    public Comunidade() {

    }

    public Comunidade(String nome, String descricao, LocalDate dataCriacao, Usuario dono, List<Usuario> membros) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dono = dono;
        this.membros = membros;
    }

    // <editor-fold  defaultstate="collapsed" desc="Getters/Setters" >

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
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

    public List<Usuario> getMembros() {
        return membros;
    }

    public void setMembros(List<Usuario> membros) {
        this.membros = membros;
    }

    // </editor-fold>
}
