/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.redesocial.dtos;

/**
 *
 * @author Tygsv
 */
public class UsuarioDTO {
    
    private Long id;
    private String nickname;
    private String sobre;

    public UsuarioDTO() {
    }
    
    public UsuarioDTO(String nickname, String sobre, Long id) {
        this.nickname = nickname;
        this.sobre = sobre;
        this.id = id;
    }
    
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }
    
    
}
