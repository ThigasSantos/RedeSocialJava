/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.redesocial.dtos;

import com.example.redesocial.usuario.Usuario;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Tygsv
 */
public class UsuarioDTO {
    
    private Long id;
    private String nickname;
    private String email;
    private String sobre;
    private LocalDate dataNascimento;
    private List<Usuario> seguindo;
    private List<Usuario> seguidoPor;
    
    public UsuarioDTO() {
    }
    
    public UsuarioDTO(String nickname, String sobre, Long id) {
        this.nickname = nickname;
        this.sobre = sobre;
        this.id = id;
    }

    public UsuarioDTO(Long id, String nickname, String email, String sobre, LocalDate dataNascimento) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.sobre = sobre;
        this.dataNascimento = dataNascimento;
    }
    
    public UsuarioDTO(Long id, String nickname, String email, String sobre, LocalDate dataNascimento, List<Usuario> seguindo, List<Usuario> seguidoPor) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.sobre = sobre;
        this.dataNascimento = dataNascimento;
        this.seguindo = seguindo;
        this.seguidoPor = seguidoPor;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Usuario> getSeguindo() {
        return seguindo;
    }

    public void setSeguindo(List<Usuario> seguindo) {
        this.seguindo = seguindo;
    }

    public List<Usuario> getSeguidoPor() {
        return seguidoPor;
    }

    public void setSeguidoPor(List<Usuario> seguidoPor) {
        this.seguidoPor = seguidoPor;
    }
    
    
}
