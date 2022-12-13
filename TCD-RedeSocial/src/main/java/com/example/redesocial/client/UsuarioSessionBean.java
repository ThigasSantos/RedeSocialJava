package com.example.redesocial.client;
import com.example.redesocial.usuario.Usuario;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import javax.inject.Inject;

@Named
@SessionScoped
public class UsuarioSessionBean implements Serializable {
    
    @Inject
    FacesContext facesContext;

    private Usuario usuario;

    private Boolean conectado = false;
    
    private Boolean darkMode = false;

    public Boolean getDarkMode() {
        return darkMode;
    }

    public void setDarkMode(Boolean darkMode) {
        this.darkMode = darkMode;
    }

    public void conectar(Usuario u) {
        conectado = true;
        setUsuario(u);
    }

    public void desconectar() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String path = externalContext.getApplicationContextPath();
        externalContext.redirect(path + "/login");
        externalContext.invalidateSession();
    }

    // <editor-fold  defaultstate="collapsed" desc="Getters/Setters" >
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

    // </editor-fold>

    private ExternalContext getExternalContext() {
        return facesContext.getExternalContext();
    }

}