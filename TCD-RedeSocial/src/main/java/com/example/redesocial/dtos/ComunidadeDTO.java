/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.redesocial.dtos;

/**
 *
 * @author felipe
 */
public class ComunidadeDTO {
    
    private String nome;

    private Long qtdMembros;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public ComunidadeDTO() {
    }

    public ComunidadeDTO(String nome, Long qtdMembros) {
        this.nome = nome;
        this.qtdMembros = qtdMembros;
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
//</editor-fold>
    
}
