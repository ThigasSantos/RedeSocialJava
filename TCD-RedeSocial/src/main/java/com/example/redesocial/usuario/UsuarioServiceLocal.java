package com.example.redesocial.usuario;

import com.example.redesocial.comunidade.Comunidade;
import com.example.redesocial.dtos.SearchItemDTO;
import com.example.redesocial.usuario.credencial.Credencial;

import javax.ejb.Local;
import javax.persistence.Tuple;
import java.util.List;

@Local
public interface UsuarioServiceLocal {

    void persist(Usuario usuario);
    
    Usuario buscarUsuario(Long id);

    List<Object[]> findPostsSeguidores(Usuario usuario);

    Usuario buscarPorCredencial(String email, String senha);

    List<Credencial> getCredencial(Usuario usuario);
    
    public Usuario buscarPorEmail(String email);

    List<Comunidade> getComunidades(Usuario u);

    List<Usuario> getSeguindo(Usuario u);

    List<Usuario> getUsuariosEmComum(Usuario u);

    List<SearchItemDTO> search(String like);

    List<Usuario> getSeguidoPor(Usuario usuario);
}
