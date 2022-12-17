/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.example.redesocial.postagem;

import com.example.redesocial.comunidade.Comunidade;
import com.example.redesocial.dtos.PostagemDTO;
import com.example.redesocial.usuario.Usuario;
import com.example.redesocial.usuario.UsuarioServiceLocal;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author felipe
 */
@Stateless
public class PostagemService implements PostagemServiceLocal {

    @PersistenceContext
    private EntityManager em;

    @Inject
    UsuarioServiceLocal usuarioService;
    
    @Override
    public void salvar(Postagem postagem) {
        // Inserção de entidade
        em.persist(postagem);
    }

    @Override
    public Postagem localizarPorId(long id) {
        // Recuperação de entidade via ID
        return em.find(Postagem.class, id);
    }

    @Override
    public List<Postagem> findPostagens() {
        // Recuperação de todas as entidades
        return em.createNamedQuery("findPostagens", Postagem.class).getResultList();
    }

    @Override
    public void update(Postagem postagem) {
        // Atualização de entidade preexistente
        em.merge(postagem);
        em.flush();
    }
    
    // TODO envio da entidade para a lixeira
    
    @Override
    public void remover(Postagem postagem) {
        // Exclusão permanente de entidade
        em.remove(postagem);
    }

    @Override
    public List<Object[]> findRespostasPosts(Postagem postagem) {
        String consulta = "SELECT r FROM Postagem p JOIN p.respostas r WHERE p.id = :idPostagem";
        return em.createQuery(consulta, Object[].class)
                .setParameter("idPostagem", postagem.getId())
                .getResultList();
    }

    @Override
    public List<Object[]> findUsuariosCurtiram(Postagem postagem) {
        String consulta = "SELECT  u.id, u.nickname FROM Postagem p JOIN p.usuariosCurtiram u WHERE p.id = :idPostagem";
        return em.createQuery(consulta, Object[].class)
                .setParameter("idPostagem", postagem.getId())
                .getResultList();
    }

    @Override
    public List<PostagemDTO> getPostagemFeed() {
        String consulta = "SELECT new com.example.redesocial.dtos.PostagemDTO(p, p.usuariosCurtiram.size, p.respostas.size, u.nickname, p.dataPostagem) FROM Postagem p LEFT JOIN p.usuario u where p.comunidade is null group by p, u.nickname order by p.usuariosCurtiram.size desc, p.respostas.size desc";
        return em.createQuery(consulta, PostagemDTO.class).getResultList();
    }

    @Override
    public List<PostagemDTO> getPostagemFeed(Usuario u) {
        List<Comunidade> comunidades = usuarioService.getComunidades(u);
        List<Usuario> seguindo = usuarioService.getSeguindo(u);
        String consulta = "SELECT new com.example.redesocial.dtos.PostagemDTO(p, p.usuariosCurtiram.size, p.respostas.size, u.nickname, p.dataPostagem) FROM Postagem p LEFT JOIN p.usuario u where p.comunidade in :comunidades or u in :seguindo group by p, u.nickname order by p.dataPostagem";
        return em.createQuery(consulta, PostagemDTO.class)
                .setParameter("comunidades", comunidades)
                .setParameter("seguindo", seguindo)
                .getResultList();
    }

    @Override
    public List<PostagemDTO> getPostagemPerfil(Usuario u) {
        String consulta = "SELECT new com.example.redesocial.dtos.PostagemDTO(p, p.usuariosCurtiram.size, p.respostas.size, u.nickname, p.dataPostagem) FROM Postagem p LEFT JOIN p.usuario u where u = :usuario group by p, u.nickname order by p.dataPostagem desc";
        return em.createQuery(consulta, PostagemDTO.class)
                .setParameter("usuario", u)
                .getResultList();
    }
    @Override
    public List<PostagemDTO> getPostagensComunidade(Comunidade c) {
        String consulta = "SELECT new com.example.redesocial.dtos.PostagemDTO(p, p.usuariosCurtiram.size, p.respostas.size, u.nickname, p.dataPostagem) FROM Postagem p LEFT JOIN p.usuario u LEFT JOIN p.comunidade c where c = :comunidade group by p, u.nickname order by p.dataPostagem desc";
        return em.createQuery(consulta, PostagemDTO.class)
                .setParameter("comunidade", c)
                .getResultList();
    }


}