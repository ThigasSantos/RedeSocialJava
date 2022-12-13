package com.example.redesocial.client.login;

import com.example.redesocial.client.UsuarioSessionBean;
import com.example.redesocial.usuario.Usuario;
import com.example.redesocial.usuario.UsuarioServiceLocal;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class LoginBean {
    @Inject
    UsuarioSessionBean usuarioSession;
    @Inject
    UsuarioServiceLocal usuarioService;
    private String email = "thigas@gmail.com";
    private String senha = "senha123";
    private final ExternalContext externalContext =  FacesContext.getCurrentInstance().getExternalContext();
    private Boolean falha = false;

    public void login() throws IOException {
        Usuario usuario = usuarioService.buscarPorCredencial(email, senha);
        if (usuario == null) {
            falha = true;
            return;
        }

        usuarioSession.conectar(usuario);
        redirectToHome();
    }

    public void redirectToHome() throws IOException {
        String path = externalContext.getApplicationContextPath();
        externalContext.redirect(path);
    }

    public String falhaHandler() {
        falha = false;
        return "Email ou Senha incorretos, Tente Novamente";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getFalha() {
        return falha;
    }
}
