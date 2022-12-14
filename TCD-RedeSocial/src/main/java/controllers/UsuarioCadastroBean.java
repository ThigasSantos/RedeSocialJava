/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.example.redesocial.usuario.Usuario;
import com.example.redesocial.usuario.UsuarioServiceLocal;
import com.example.redesocial.usuario.credencial.Credencial;
import com.example.redesocial.usuario.credencial.TipoPerfil;
import com.example.redesocial.usuario.telefone.Telefone;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Tygsv
 */
@Named
@RequestScoped
public class UsuarioCadastroBean {
    
    @Inject UsuarioServiceLocal usuarioService;
    
    @Inject
    FacesContext facesContext;
    
    private String nickname;
    private String email;
    private String password;
    private String nascimento;
    private String telefone;
    private short ddd = 38;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getNickname() {
        return nickname;
    }
    public short getDdd() {
        return ddd;
    }

    public void setDdd(short ddd) {
        this.ddd = ddd;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    //</editor-fold>
    
    public void cadastrar() throws IOException{
        Credencial user = new Credencial(TipoPerfil.USUARIO_PADRAO, email, password);
        Telefone userTel = new Telefone(Integer.parseInt(telefone),ddd);
        Usuario novo = new Usuario(nickname,LocalDate.parse(nascimento), List.of(userTel), user);
        
        usuarioService.persist(novo);
        
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String path = externalContext.getApplicationContextPath();
        externalContext.redirect(path + "/login");
        externalContext.invalidateSession();
        
    }
    
}
