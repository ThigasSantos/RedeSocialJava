package com.example.redesocial.usuario;

import com.example.redesocial.usuario.credencial.Credencial;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UsuarioServiceLocal {

    void persist(Usuario usuario);
    
    Usuario buscarUsuario(Long id);

    List<Object[]> findPostsSeguidores(Usuario usuario);

    Usuario buscarPorCredencial(String email, String senha);

    List<Credencial> getCredencial(Usuario usuario);
    
    public Usuario buscarPorEmail(String email);

    Usuario findComunidadesPorUsuario(Usuario usuario);
}
