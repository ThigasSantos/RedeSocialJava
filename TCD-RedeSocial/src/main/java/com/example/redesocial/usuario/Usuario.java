package com.example.redesocial.usuario;

import com.example.redesocial.comunidade.Atuacao;
import com.example.redesocial.comunidade.Comunidade;
import com.example.redesocial.postagem.reacao.Reacao;
import com.example.redesocial.usuario.credencial.Credencial;
import com.example.redesocial.usuario.telefone.Telefone;
import com.example.redesocial.postagem.Postagem;
import java.io.Serializable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String nome;
    @Column(length = 150)
    private String sobrenome;
    private String avatar;
    private String sobre;
    private LocalDate dataNascimento;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private List<Telefone> telefones;

    @ManyToMany
    @JoinTable(name="seguir")
    private List<Usuario> seguindo;

    @ManyToMany(mappedBy="seguindo")
    private List<Usuario> seguidoPor;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private List<Postagem> postagens;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private List<Atuacao> atuacoes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "dono_id")
    private List<Comunidade> comunidades;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private List<Reacao> reacoes;

    @OneToOne(cascade = CascadeType.ALL)
    private Credencial credencial;

    // <editor-folder  defaultstate="collapsed" desc="Getters/Setters" >
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    public List<Usuario> getSeguindo() {
        return seguindo;
    }

    public void setSeguindo(List<Usuario> seguindo) {
        this.seguindo = seguindo;
    }

    public List<Usuario> getSeguidoPor() {
        return seguidoPor;
    }

    public void setSeguidoPor(List<Usuario> seguidoPor) {
        this.seguidoPor = seguidoPor;
    }

    public List<Postagem> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagem> postagens) {
        this.postagens = postagens;
    }

    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        this.atuacoes = atuacoes;
    }

    public List<Comunidade> getComunidades() {
        return comunidades;
    }

    public void setComunidades(List<Comunidade> comunidades) {
        this.comunidades = comunidades;
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
    // </editor-folder>
}
