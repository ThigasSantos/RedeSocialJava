package com.example.redesocial.dtos;


import com.example.redesocial.utils.json.JsonUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

public class PostagemDTO {
    private Long id;
    private String conteudo;
    private Long usuarioId;
    private String usuarioNickName;
    private List<String> midiasLinks;
    private Integer qtdCurtidas;
    private Integer qtdRespostas;

    // <editor-fold  defaultstate="collapsed" desc="Constructors" >
    public PostagemDTO(Tuple t) {
        this.id = (Long) t.get("id");
        this.conteudo = (String) t.get("conteudo");
        this.usuarioId = (Long) t.get("usuarioId");
        this.usuarioNickName = (String) t.get("usuarioNickName");
        this.qtdCurtidas = (Integer) t.get("qtdCurtidas");
        this.qtdRespostas = (Integer) t.get("qtdRespostas");
        try {
            this.midiasLinks = List.of(
                    new ObjectMapper()
                            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                            .readValue((String) t.get("midiasLinks"), String[].class));
        } catch (Exception ignored) {
            this.midiasLinks = new ArrayList<>();
        }
    }

    public PostagemDTO() {}

    // </editor-fold>

    // <editor-fold  defaultstate="collapsed" desc="Getters/Setters" >
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

    public List<String> getMidiasLinks() {
        return midiasLinks;
    }

    public void setMidiasLinks(List<String> midiasLinks) {
        this.midiasLinks = midiasLinks;
    }

    public Integer getQtdCurtidas() {
        return qtdCurtidas;
    }

    public void setQtdCurtidas(Integer qtdCurtidas) {
        this.qtdCurtidas = qtdCurtidas;
    }

    public Integer getQtdRespostas() {
        return qtdRespostas;
    }

    public void setQtdRespostas(Integer qtdRespostas) {
        this.qtdRespostas = qtdRespostas;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNickName() {
        return usuarioNickName;
    }

    public void setUsuarioNickName(String usuarioNickName) {
        this.usuarioNickName = usuarioNickName;
    }

    // </editor-fold>
}
