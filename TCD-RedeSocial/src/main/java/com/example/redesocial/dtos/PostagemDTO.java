package com.example.redesocial.dtos;

import com.example.redesocial.postagem.Postagem;

import java.time.LocalDateTime;

import java.time.temporal.ChronoUnit;

public class PostagemDTO {
    private Postagem postagem;
    private Long qtdCurtidas;
    private Long qtdRespostas;
    private String username;

    private String dataPostagem;

    public PostagemDTO() {
    }


    public PostagemDTO(Postagem postagem, Long qtdCurtidas, Long qtdRespostas, String username) {
        this.postagem = postagem;
        this.qtdCurtidas = qtdCurtidas;
        this.qtdRespostas = qtdRespostas;
        this.username = username;
    }

    public PostagemDTO(Postagem postagem, int qtdCurtidas, int qtdRespostas, String username) {
        this.postagem = postagem;
        this.qtdCurtidas = (long) qtdCurtidas;
        this.qtdRespostas = (long) qtdRespostas;
        this.username = username;
    }

    public PostagemDTO(Postagem postagem, int qtdCurtidas, int qtdRespostas, String username, LocalDateTime dataPostagem) {
        this.postagem = postagem;
        this.qtdCurtidas = (long) qtdCurtidas;
        this.qtdRespostas = (long) qtdRespostas;
        this.username = username;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    public Long getQtdCurtidas() {
        return qtdCurtidas;
    }

    public void setQtdCurtidas(Long qtdCurtidas) {
        this.qtdCurtidas = qtdCurtidas;
    }

    public Long getQtdRespostas() {
        return qtdRespostas;
    }

    public void setQtdRespostas(Long qtdRespostas) {
        this.qtdRespostas = qtdRespostas;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(String dataPostagem) {
        this.dataPostagem = dataPostagem;
    }
    
}
