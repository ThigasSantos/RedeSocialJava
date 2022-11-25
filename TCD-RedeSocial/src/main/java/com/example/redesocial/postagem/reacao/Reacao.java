package com.example.redesocial.postagem.reacao;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Reacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private TipoReacao tipoReacao;


    // <editor-folder  defaultstate="collapsed" desc="Getters/Setters" >

    public Long getId() {
        return id;
    }

    public TipoReacao getTipoReacao() {
        return tipoReacao;
    }

    public void setTipoReacao(TipoReacao tipoReacao) {
        this.tipoReacao = tipoReacao;
    }

    // </editor-folder>
}
