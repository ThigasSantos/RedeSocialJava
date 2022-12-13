/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.example.redesocial.client.UsuarioSessionBean;
import com.example.redesocial.postagem.Postagem;
import com.example.redesocial.postagem.PostagemServiceLocal;
import com.example.redesocial.usuario.Usuario;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Tygsv
 */
@Named
@RequestScoped
public class PostagemController {
    
    @Inject PostagemServiceLocal postagemService;
    
    @Inject UsuarioSessionBean usuarioSession;
    
    private String conteudo;
    
    public String getConteudo(){
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
    public void postar(){
        Postagem post = new Postagem();
        post.setConteudo(conteudo);
        post.setUsuario(usuarioSession.getUsuario());
        postagemService.salvar(post);
    }
}
