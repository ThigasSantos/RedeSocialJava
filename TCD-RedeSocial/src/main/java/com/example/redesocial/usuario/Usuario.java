package com.example.redesocial.usuario;

import com.example.redesocial.comunidade.Comunidade;
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
    private String nickname;
    private String sobre;
    private LocalDate dataNascimento;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private List<Telefone> telefones;

    @ManyToMany
    @JoinTable(name="segue",
    joinColumns = @JoinColumn(name = "usuario_seguidor_id"),
    inverseJoinColumns = @JoinColumn(name = "usuario_seguido_id"))
    private List<Usuario> seguindo;

    @ManyToMany(mappedBy="seguindo")
    private List<Usuario> seguidoPor;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private List<Postagem> postagens;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dono")
    private List<Comunidade> comunidadesLideradas;

    @ManyToMany(mappedBy = "membros")
    private List<Comunidade> comunidades;

    @ManyToMany(mappedBy = "usuariosCurtiram")
    private List<Postagem> postagensCurtidas;

    @OneToOne(cascade = CascadeType.ALL)
    private Credencial credencial;

    public Usuario(String nickname, String sobre, LocalDate dataNascimento, Credencial credencial) {
        this.nickname = nickname;
        this.sobre = sobre;
        this.dataNascimento = dataNascimento;
        this.credencial = credencial;
    }

    
    
   
// <editor-fold  defaultstate="collapsed" desc="Getters/Setters" >

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public List<Comunidade> getComunidadesLideradas() {
        return comunidadesLideradas;
    }

    public void setComunidadesLideradas(List<Comunidade> comunidadesLideradas) {
        this.comunidadesLideradas = comunidadesLideradas;
    }

    public List<Postagem> getPostagensCurtidas() {
        return postagensCurtidas;
    }

    public void setPostagensCurtidas(List<Postagem> postagensCurtidas) {
        this.postagensCurtidas = postagensCurtidas;
    }

    public List<Comunidade> getComunidades() {
        return comunidades;
    }

    public void setComunidades(List<Comunidade> comunidades) {
        this.comunidades = comunidades;
    }

    // </editor-fold>
}
