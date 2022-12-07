package com.example.redesocial.usuario;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UsuarioServiceLocal {

    void persist(Usuario usuario);
    
    Usuario buscarUsuario(Long id);

    List<Object[]> findPostsSeguidores(Usuario usuario);

    Usuario buscarPorCredencial(String email, String senha);
}
