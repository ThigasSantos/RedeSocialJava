package com.example.redesocial.postagem.reacao;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Reacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // <editor-folder  defaultstate="collapsed" desc="Getters/Setters" >

    public Long getId() {
        return id;
    }

    // </editor-folder>
}
