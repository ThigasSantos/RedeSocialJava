/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.example.redesocial.postagem;

import com.example.redesocial.dtos.PostagemDTO;
import com.example.redesocial.usuario.Usuario;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author felipe
 */
@Local
public interface PostagemServiceLocal {
    void salvar(Postagem postagem);

    Postagem localizarPorId(long id);

    List<Postagem> findPostagens();

    void remover(Postagem postagem);

    void update(Postagem postagem);

    List<Object[]> findRespostasPosts(Postagem postagem);

    List<Object[]> findUsuariosCurtiram(Postagem postagem);

    List<PostagemDTO> getPostagemFeed();

    List<PostagemDTO> getPostagemFeed(Usuario u);
    
     public List<PostagemDTO> getPostagemPerfil(Usuario u);
     
     public void atualizarCurtidas(Long id, Usuario u);
}
