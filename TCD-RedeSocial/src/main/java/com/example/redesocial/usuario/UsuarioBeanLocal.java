package com.example.redesocial.usuario;

import javax.ejb.Local;

@Local
public interface UsuarioBeanLocal {

    void persist(Usuario usuario);
    
    Usuario buscarUsuario(Long id);
}
