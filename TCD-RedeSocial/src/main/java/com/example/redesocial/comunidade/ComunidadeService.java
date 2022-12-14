/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.example.redesocial.comunidade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andre-barros
 */
@Stateless
public class ComunidadeService implements ComunidadeServiceLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void salvar(Comunidade comunidade) {
        // Inserção de entidade
        em.persist(comunidade);
    }

    @Override
    public Comunidade localizarPorId(long id) {
        // Recuperação de entidade via ID
        return em.find(Comunidade.class, id);
    }

    @Override
    public List<Comunidade> findComunidades() {
        // Recuperação de todas as entidades
        return em.createNamedQuery("findComunidades",Comunidade.class).getResultList();
    }

    @Override
    public void update(Comunidade comunidade) {
        // Atualização de entidade preexistente
        em.merge(comunidade);
    }
    
    // TODO envio da entidade para a lixeira
    
    @Override
    public void remover(Comunidade comunidade) {
        // Exclusão permanente de entidade
        em.remove(comunidade);
    }

    @Override
    public List<Object[]> findPostsComunidades(Comunidade comunidade) {
        String consulta = "SELECT c.postagens FROM Comunidade c WHERE c.id = :IdComunidade";
        return em.createQuery(consulta, Object[].class)
                .setParameter("IdComunidade", comunidade.getId())
                .getResultList();
    }

    @Override
    public List<Object[]> findMembros(Comunidade comunidade) {
        String consulta = "SELECT c.membros FROM Comunidade c WHERE c.id = :IdComunidade";
        return em.createQuery(consulta, Object[].class)
                .setParameter("IdComunidade", comunidade.getId())
                .getResultList();
    }
    
    
}
