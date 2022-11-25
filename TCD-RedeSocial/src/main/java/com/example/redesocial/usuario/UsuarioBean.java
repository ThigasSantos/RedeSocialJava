package com.example.redesocial.usuario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UsuarioBean implements UsuarioBeanLocal{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void persist(Usuario usuario) {
        em.persist(usuario);
    }

}
