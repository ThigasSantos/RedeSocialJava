package com.example.redesocial.usuario;

import com.example.redesocial.usuario.credencial.Credencial;
import com.example.redesocial.usuario.credencial.CredencialServiceLocal;

import javax.ejb.Stateless;
import javax.inject.Inject;
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

    @Inject
    CredencialServiceLocal credencialService;

    @Override
    public void persist(Usuario usuario) {
        Credencial cr = usuario.getCredencial();

        usuario.setCredencial(
                credencialService.criarCredencial(cr)
        );

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

    @Override
    public List<Credencial> getCredencial(Usuario usuario) {
        return em.createNamedQuery("Credencial.byUsuario", Credencial.class)
                .setParameter("id", usuario.getId())
                .getResultList();
    }
    
}
