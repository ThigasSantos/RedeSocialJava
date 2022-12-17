/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.redesocial.dtos;

import java.util.List;

/**
 *
 * @author felipe
 */
public class ComunidadeDTO {
    
    private String nome;

    private Long qtdMembros;
    
    private List<PostagemDTO> postagens;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public ComunidadeDTO() {
    }

    public ComunidadeDTO(String nome, Long qtdMembros) {
        this.nome = nome;
        this.qtdMembros = qtdMembros;
    }
    
    public ComunidadeDTO(String nome, Long qtdMembros, List<PostagemDTO> postagens) {
        this.nome = nome;
        this.qtdMembros = qtdMembros;
        this.postagens = postagens;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Long getQtdMembros() {
        return qtdMembros;
    }

    public void setQtdMembros(Long qtdMembros) {
        this.qtdMembros = qtdMembros;
    }
    
    public List<PostagemDTO> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<PostagemDTO> postagens) {
        this.postagens = postagens;
    }
//</editor-fold>
    
}
