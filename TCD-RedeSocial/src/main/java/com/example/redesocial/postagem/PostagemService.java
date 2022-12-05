/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.example.redesocial.postagem;

import java.util.List;
import javax.ejb.Stateless;
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
    
    
}
