/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.example.redesocial.postagem;

import com.example.redesocial.comunidade.Comunidade;
import com.example.redesocial.dtos.PostagemDTO;
import com.example.redesocial.usuario.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;

/**
 *
 * @author felipe
 */
@Stateless
public class PostagemService implements PostagemServiceLocal {

    @PersistenceContext
    private EntityManager em;
    
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
    }
    
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
    public List<PostagemDTO> postagensMaisPopulares() {
       String consulta = "SELECT p.id as id, p.conteudo as conteudo, u.id as usuarioId, u.nickname as usuarioNickName, CAST(FUNCTION('json_agg', m.link) as text) as midiasLinks, p.usuariosCurtiram.size as qtdCurtidas, p.respostas.size as qtdRespostas FROM Postagem p LEFT JOIN p.usuario u LEFT JOIN p.midias m where p.comunidade is null group by p.id, p.conteudo, u.id, u.nickname order by p.usuariosCurtiram.size, p.respostas.size DESC";

       List<Tuple> postagens = em.createQuery(consulta, Tuple.class).getResultList();

       return postagens.stream().map(PostagemDTO::new).collect(Collectors.toList());
    }

    public List<PostagemDTO> findUserPostFeed(Usuario usuario) {
        String consulta = "SELECT p, s FROM Usuario u LEFT JOIN u.seguindo s LEFT JOIN s.postagens p WHERE u.id = :usuarioId and (p.comunidade is null) order by p.dataPostagem DESC";

        List<Postagem> postagens = em.createQuery(consulta, Postagem.class).getResultList();

        return null;
    }

    @Override
    public List<PostagemDTO> postagensMaisPopulares(List<Comunidade> comunidades) {
//        String consulta = "SELECT new com.example.redesocial.dtos.PostagemDTO(p.id, p.conteudo, COUNT(u.id), COUNT(r.id)) FROM Postagem p LEFT JOIN p.usuariosCurtiram u LEFT JOIN p.respostas r where p.comunidade in :comunidadesIds group by p.id, p.conteudo order by COUNT(u.id) DESC";
//        return em.createQuery(consulta, PostagemDTO.class)
//                .setParameter("comunidadesIds", comunidades)
//                .getResultList();
        return null;
    }
}
