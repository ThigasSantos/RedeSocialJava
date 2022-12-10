package com.example.redesocial.usuario;

import com.example.redesocial.dtos.PostagemDTO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
public class UsuarioService implements Serializable, UsuarioServiceLocal{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void persist(Usuario usuario) {
        em.persist(usuario);
    }

     @Override
    public Usuario buscarUsuario(Long id) {
        Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.id = :id").setParameter("id", id);
        return (Usuario) q.getSingleResult();
        
//        Query q = em.createQuery(
//                "SELECT u, comunidades, comunidadesLideradas, postagens, seguidoPor, seguindo, telefones"
//                        + "FROM Usuario u, IN (u.comunidades) comunidades, "
//                        + "IN (u.comunidadesLideradas) comunidadesLideradas, "
//                        + "IN (u.postagens) postagens, IN (u.seguidoPor) seguidoPor, "
//                        + "IN (u.seguindo) seguindo, "
//                        + "IN (u.telefones) telefones "
//                        + "WHERE u.id = :id").setParameter(":id", id);
//        
//        return (Object[]) q.getSingleResult();
    }

    @Override
    public List<Object[]> findPostsSeguidores(Usuario usuario) {
        String consulta = "SELECT s.postagens FROM Usuario u JOIN u.seguindo s WHERE u.id = :idUsuario";
        return em.createQuery(consulta, Object[].class)
                .setParameter("idUsuario", usuario.getId())
                .getResultList();
    }

    @Override
    public Usuario buscarPorCredencial(String email, String senha) {
        String consulta = "SELECT u FROM Usuario u JOIN u.credencial c WHERE c.email = :email AND c.senha = :senha";
        try {
            return (Usuario) em.createQuery(consulta)
                    .setParameter("email", email)
                    .setParameter("senha", senha)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
