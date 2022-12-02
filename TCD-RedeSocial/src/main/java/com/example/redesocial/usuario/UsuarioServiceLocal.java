package com.example.redesocial.usuario;

import javax.ejb.Local;

@Local
public interface UsuarioServiceLocal {

    void persist(Usuario usuario);
    
    Usuario buscarUsuario(Long id);
}
