/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.example.redesocial.client.UsuarioSessionBean;
import com.example.redesocial.usuario.Usuario;
import com.example.redesocial.usuario.UsuarioServiceLocal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
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
public class PerfilController {
    
  @Inject UsuarioServiceLocal userService;
  @Inject UsuarioSessionBean userBean;  
  @Inject FacesContext facesContext;
   
    public List<Usuario> getSeguindo(){
        return userService.getSeguindo(userBean.getUsuario());
    }
    
    public List<Usuario> getSeguidoPor(){
        return userService.getSeguidoPor(userBean.getUsuario());
    }      
    
    public String exibirPerfil(){
        ExternalContext externalContext = facesContext.getExternalContext();
        Map<String, String> parameterMap = (Map<String, String>) externalContext.getRequestParameterMap();
        String param = parameterMap.get("perfil");
        return param;
    }
    
}
