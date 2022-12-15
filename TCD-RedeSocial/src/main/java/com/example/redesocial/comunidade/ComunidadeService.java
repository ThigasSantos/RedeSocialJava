/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.example.redesocial.comunidade;

import com.example.redesocial.dtos.ComunidadeDTO;
import com.example.redesocial.usuario.Usuario;
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
        em.persist(comunidade);
    }

    @Override
    public Comunidade localizarPorId(long id) {
        return em.find(Comunidade.class, id);
    }

    @Override
    public List<Comunidade> findComunidades() {
        return em.createNamedQuery("findComunidades",Comunidade.class).getResultList();
    }

    @Override
    public void update(Comunidade comunidade) {
        em.merge(comunidade);
    }
      
    @Override
    public void remover(Comunidade comunidade) {
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
    
    @Override
    public List<ComunidadeDTO> findComunidades(Usuario u) {
        String consulta = "SELECT new com.example.redesocial.dtos.ComunidadeDTO(c.nome, COUNT(m.id)) FROM Usuario u "
                + "LEFT JOIN u.comunidades c "
                + "LEFT JOIN c.membros m WHERE u.id = :IdMembro "
                + "GROUP BY c.nome";
            
        return em.createQuery(consulta, ComunidadeDTO.class)
                .setParameter("IdMembro", u.getId())
                .getResultList();
    }
}
