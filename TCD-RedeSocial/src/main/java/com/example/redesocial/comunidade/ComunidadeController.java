/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.redesocial.comunidade;

import com.example.redesocial.client.UsuarioSessionBean;
import com.example.redesocial.dtos.ComunidadeDTO;
import com.example.redesocial.usuario.Usuario;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;
import javax.transaction.Transactional;

/**
 *
 * @author felipe
 */
@Named
@Transactional
@RequestScoped
public class ComunidadeController {
    
    @Inject
    ComunidadeServiceLocal comunidadeService;
    @Inject
    UsuarioSessionBean usuarioSession;
    
    public List<ComunidadeDTO> getComunidades() {
        Usuario usuario = usuarioSession.getUsuario();
        return comunidadeService.findComunidades(usuario);
    }
}
