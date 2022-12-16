package com.example.redesocial.client;


import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class PageController {

    private final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

    public void goToHome() throws IOException {
        redirect("/");
    }

    public void goToLogin() throws IOException {
        redirect("/login");
    }

    public void goToCadastrar() throws IOException {
        redirect("/cadastrar");
    }
    
    public void goToPerfil() throws IOException {
        redirect("/app/perfil");
    }
    
    public void goToEditarPerfil() throws IOException{
        redirect("/app/perfil/editarPerfil");
    }

    public void goToComunidades() throws IOException {
        redirect("/comunidades");
    }
    
    public void goToSeguidoPor() throws IOException{
        redirect("/app/perfil/seguidores");
    }
    
    public void goToSeguindo() throws IOException{
        redirect("/app/perfil/seguindo");
    }
    
    public void goToPerfilName(String user) throws IOException{
        redirect("/perfil/perfil.xhtml?perfil="+user);
    }

    public void goToComunidade(String comunidade) throws IOException {
        redirect("/comunidades/comunidade.xhtml?comunidade="+comunidade);
    }
    
    public void redirect(String url) throws IOException {
        externalContext.redirect(
                externalContext.getApplicationContextPath() + url
        );
    }
}
