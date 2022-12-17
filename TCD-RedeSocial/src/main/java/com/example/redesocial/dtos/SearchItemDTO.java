package com.example.redesocial.dtos;

import java.io.Serializable;

public class SearchItemDTO implements Serializable, Comparable<SearchItemDTO> {
    private String nome;
    private String type;

    public SearchItemDTO() {
    }

    public SearchItemDTO(String nome, String type) {
        this.nome = nome;
        this.type = type;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int compareTo(SearchItemDTO o) {
        return 0;
    }
}
