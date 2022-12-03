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
        return em.createNamedQuery("Postagem.findPostagens", Postagem.class).getResultList();
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
    public Postagem findRespostasPosts(Postagem postagem) {
        String consulta = "SELECT p.respostas FROM Postagem p, IN (p.respostas) WHERE p.id = :idPostagem";
        return em.createQuery(consulta, Postagem.class).getSingleResult();
    }

    @Override
    public Postagem findUsuariosCurtiram(Postagem postagem) {
        String consulta = "SELECT p.usuariosCurtiram FROM Postagem p, IN (p.usuariosCurtiram) WHERE p.id = :idPostagem";
        return em.createQuery(consulta, Postagem.class).getSingleResult();
    }
    
    
}
