/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.example.redesocial.usuario.Usuario;
import com.example.redesocial.usuario.credencial.Credencial;
import java.util.List;
import java.util.Optional;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.resource.spi.work.SecurityContext;
import services.DataServiceBeanLocal;

/**
 *
 * @author andre-barros
 */
public class UsuarioController {
    @Inject
    DataServiceBeanLocal dataService;

    @Inject
    SecurityContext securityContext;

    @Inject
    FacesContext facesContext;

    private Optional<Usuario> currentUser;
    private List<Credencial> currentQualities;
}
