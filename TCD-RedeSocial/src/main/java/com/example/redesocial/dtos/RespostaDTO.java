package com.example.redesocial.dtos;

public class RespostaDTO {
    private Long id;
    private String conteudo;
    private String nickname;

    public RespostaDTO() {
    }

    public RespostaDTO(Long id, String conteudo, String nickname) {
        this.id = id;
        this.conteudo = conteudo;
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
