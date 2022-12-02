package com.example.redesocial.usuario.credencial;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Credencial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private TipoPerfil tipoPerfil;
    private String email;
    private String senha;

    public Credencial(TipoPerfil tipoPerfil, String email, String senha) {
        this.tipoPerfil = tipoPerfil;
        this.email = email;
        this.senha = senha;
    }

    
    // <editor-folder  defaultstate="collapsed" desc="Getters/Setters" >

    public Long getId() {
        return id;
    }

    public TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(TipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // </editor-folder>
}
