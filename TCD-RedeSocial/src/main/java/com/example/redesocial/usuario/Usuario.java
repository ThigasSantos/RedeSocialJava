package com.example.redesocial.usuario;

import com.example.redesocial.comunidade.Comunidade;
import com.example.redesocial.usuario.credencial.Credencial;
import com.example.redesocial.usuario.telefone.Telefone;
import com.example.redesocial.postagem.Postagem;
import com.example.redesocial.utils.json.customserializers.ComunidadeSingleSerializer;
import com.example.redesocial.utils.json.customserializers.LocalDateSerializer;
import com.example.redesocial.utils.json.customserializers.PostagemListSerializer;
import com.example.redesocial.utils.json.customserializers.UsuarioListSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NamedQueries({
    @NamedQuery(
            name = "Usuario.all", 
            query = "select u from Usuario u "
                    + "order by u.id"),
    @NamedQuery(
            name = "Usuario.byNickname",
            query = "select u from Usuario u "
                    + "where u.nickname = :nickname"),
    @NamedQuery(
            name = "Credencial.byUsuario", 
            query = "select u.credencial from Usuario u "
                    + "where u.id = :id")
})
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String nickname;
    private String sobre;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataNascimento;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private List<Telefone> telefones;

    @ManyToMany
    @JoinTable(name="segue",
    joinColumns = @JoinColumn(name = "usuario_seguidor_id"),
    inverseJoinColumns = @JoinColumn(name = "usuario_seguido_id"))
    @JsonSerialize(using = UsuarioListSerializer.class)
    private List<Usuario> seguindo;

    @ManyToMany(mappedBy="seguindo")
    @JsonSerialize(using = UsuarioListSerializer.class)
    private List<Usuario> seguidoPor;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    @JsonSerialize(using = PostagemListSerializer.class)
    private List<Postagem> postagens;

    @ManyToMany(mappedBy = "usuariosCurtiram")
    @JsonSerialize(using = PostagemListSerializer.class)
    private List<Postagem> postagensCurtidas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dono", orphanRemoval = true)
    @JsonSerialize(using = ComunidadeSingleSerializer.class)
    private List<Comunidade> comunidadesLideradas;

    @ManyToMany(mappedBy = "membros")
    @JsonSerialize(using = ComunidadeSingleSerializer.class)
    private List<Comunidade> comunidades;


    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Credencial credencial;

    public Usuario() {
    }
    
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
