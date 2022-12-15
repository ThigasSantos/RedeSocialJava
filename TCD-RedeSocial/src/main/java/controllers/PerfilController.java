/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.example.redesocial.client.UsuarioSessionBean;
import com.example.redesocial.usuario.Usuario;
import com.example.redesocial.usuario.UsuarioServiceLocal;
import com.example.redesocial.usuario.telefone.Telefone;
import com.example.redesocial.usuario.telefone.TelefoneServiceLocal;
import java.util.List;
import javax.enterprise.context.RequestScoped;
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
  @Inject TelefoneServiceLocal telService;
  
    public List<Usuario> getSeguindo(){
        return userService.getSeguindo(userBean.getUsuario());
    }
    
    public List<Usuario> getSeguidoPor(){
        return userService.getSeguidoPor(userBean.getUsuario());
    }   
    
}
