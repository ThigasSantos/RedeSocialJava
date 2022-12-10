/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package services;

import com.example.redesocial.usuario.Usuario;
import com.example.redesocial.usuario.credencial.Credencial;
import com.example.redesocial.usuario.credencial.TipoPerfil;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author andre-barros
 */
@Stateless
public class DataServiceBean implements DataServiceBeanLocal {

    @PersistenceContext(unitName = "secureApp")
    EntityManager em;
    
    @Inject
    Pbkdf2PasswordHash passwordHasher;

    
    @Override
    public Credencial criarCredencial(TipoPerfil perfil, String email, String senha) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("Pbkdf2PasswordHash.Iterations", "3071");
        parameters.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
        parameters.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
        passwordHasher.initialize(parameters);

        Credencial newCredential = new Credencial(
                perfil,
                email,
                passwordHasher.generate(senha.toCharArray()));
        em.persist(newCredential);
        return newCredential;
    }

    @Override
    public Usuario criarUsuario(String nickname, LocalDate nascimento, String sobre, Credencial credencial) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("Pbkdf2PasswordHash.Iterations", "3071");
        parameters.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
        parameters.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
        passwordHasher.initialize(parameters);

        Usuario newUser = new Usuario(
                nickname,
                sobre,
                nascimento,
                credencial);
        em.persist(newUser);
        return newUser;
    }

    @Override
    public List<Usuario> getAllUsers() {
         return em.createNamedQuery("Usuario.all", Usuario.class).getResultList();
    }

    @Override
    public Optional<Usuario> getUsuario(String nickname) {
        return em.createNamedQuery("Usuario.byNickname", Usuario.class)
                .setParameter("nickname", nickname)
                .getResultList()
                .stream()
                .findFirst(); // Can be null (Optional)...
    }

    @Override
    public List<Credencial> getCredencial(Usuario usuario) {
        return em.createNamedQuery("Credencial.byUsuario", Credencial.class)
                .setParameter("id", usuario.getId())
                .getResultList();
    }
    
    
    
}
