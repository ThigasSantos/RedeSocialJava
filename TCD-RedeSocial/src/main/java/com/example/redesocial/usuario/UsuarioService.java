package com.example.redesocial.usuario;

import com.example.redesocial.comunidade.Comunidade;
import com.example.redesocial.dtos.SearchItemDTO;
import com.example.redesocial.dtos.UsuarioDTO;
import com.example.redesocial.usuario.credencial.Credencial;
import com.example.redesocial.usuario.credencial.CredencialServiceLocal;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
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
        usuario.setCredencial(credencialService.criarCredencial(cr));
        em.persist(usuario);
    }

    @Override
    public void remover(Usuario usuario) {

        em.remove(usuario);

    }

    @Override
    public Usuario merge(Usuario usuario) {
        Usuario updated = em.merge(usuario);
        updated.setDataNascimento(usuario.getDataNascimento());
        updated.setNickname(usuario.getNickname());
        updated.setSobre(usuario.getSobre());
        return updated;
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
    
    @Override
    public Usuario buscarPorEmail(String email) {
        String consulta = "SELECT u FROM Usuario u JOIN u.credencial c WHERE c.email = :email";
        try {
            return (Usuario) em.createQuery(consulta)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    @Override
    public List<Comunidade> getComunidades(Usuario u) {
        return em.createQuery("SELECT c from Usuario u left join u.comunidades c where u = :usuario", Comunidade.class)
                .setParameter("usuario", u).getResultList();
    }

    @Override
    public List<Usuario> getSeguindo(Usuario u) {
        return em.createQuery("SELECT s from Usuario u left join u.seguindo s where u = :usuario", Usuario.class)
                .setParameter("usuario", u).getResultList();
    }

    @Override
    public List<Usuario> getSeguidoPor(Usuario u) {
        return em.createQuery("SELECT s from Usuario u left join u.seguidoPor s where u = :usuario", Usuario.class)
                .setParameter("usuario", u).getResultList();
    }

    @Override
    public List<Usuario> getUsuariosEmComum(Usuario u) {
        String consulta = "SELECT u.nickname, COUNT(sp.id) FROM Usuario u LEFT JOIN u.seguidoPor sp WHERE u <> :usuario and (sp IN (SELECT uss FROM Usuario us LEFT JOIN us.seguindo uss WHERE us = :usuario)) ORDER BY u.nickname";
        return em.createQuery(consulta, Usuario.class)
                .setParameter("usuario", u)
                .getResultList();
    }

    @Override
    public Usuario getUsuarioByNickname(String nickname) {
        String consulta = "SELECT u FROM Usuario u where u.nickname = :nickname";
        return em.createQuery(consulta, Usuario.class)
                .setParameter("nickname", nickname).getSingleResult();
    }

    @Override
    public List<SearchItemDTO> search(String name) {
        em.flush();
        String consulta = "SELECT new com.example.redesocial.dtos.SearchItemDTO(u.nickname, 'usuario') FROM Usuario u WHERE LOWER(u.nickname) LIKE :nickname";
        return em.createQuery(consulta, SearchItemDTO.class)
                .setParameter("nickname", '%' + name + '%')
                .getResultList();
    }

    @Override
    public List<Usuario> findUsuariosHome(){
        return em.createQuery("SELECT u FROM Usuario u").setMaxResults(5).getResultList();
    }
    
    @Override
    public List<UsuarioDTO> findUsuarioEmail(String nick){
        String consulta = "SELECT new com.example.redesocial.dtos.UsuarioDTO(u.id, u.nickname, c.email, u.sobre, u.dataNascimento) FROM Usuario u WHERE u.nickname = :nick"
                +"LEFT JOIN u.credencial c";
        return em.createQuery(consulta,UsuarioDTO.class).setParameter("nick", nick).getResultList();
    }
    
}
