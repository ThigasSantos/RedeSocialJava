/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.example.redesocial.usuario.telefone;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andre-barros
 */
@Stateless
public class TelefoneService implements TelefoneServiceLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void salvar(Telefone telefone) {
        em.persist(telefone);
    }

    @Override
    public Telefone localizarPorId(long id) {
        return em.find(Telefone.class, id);
    }

    @Override
    public List<Telefone> findTelefones() {
        return em.createNamedQuery("Telefone.findTelefones",Telefone.class).getResultList();
    }

    @Override
    public void update(Telefone telefone) {
        em.merge(telefone);
    }

    @Override
    public void remover(Telefone telefone) {
        em.remove(telefone);
    }
    
    
}
