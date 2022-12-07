package com.example.redesocial.usuario.login;
import com.example.redesocial.usuario.Usuario;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class UsuarioSession implements Serializable {

    private Usuario usuario;

    private Boolean conectado = false;

    public void connect(Usuario u) {
        conectado = true;
        setUsuario(u);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean getConectado() {
        return conectado;
    }

    public void setConectado(Boolean conectado) {
        this.conectado = conectado;
    }
}