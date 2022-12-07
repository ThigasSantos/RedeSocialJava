package com.example.redesocial.usuario.login;

import com.example.redesocial.usuario.Usuario;
import com.example.redesocial.usuario.UsuarioServiceLocal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBean {
    @Inject
    UsuarioSession usuarioSession;

    @Inject
    UsuarioServiceLocal usuarioService;
    private String email;
    private String senha;

    private Boolean falha = false;

    public void login() {
        Usuario usuario = usuarioService.buscarPorCredencial(this.email, this.senha);

        if (usuario == null) {
            falha = true;
            return;
        }

        usuarioSession.connect(usuario);
        /// redirecionar para home
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

    public void setFalha(Boolean falha) {
        this.falha = falha;
    }
}
