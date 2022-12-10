/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package services;

import com.example.redesocial.usuario.Usuario;
import com.example.redesocial.usuario.credencial.Credencial;
import com.example.redesocial.usuario.credencial.TipoPerfil;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;

/**
 *
 * @author andre-barros
 */
@Local
public interface DataServiceBeanLocal {

    Credencial criarCredencial(TipoPerfil perfil, String email, String senha);

    Usuario criarUsuario(String nickname, LocalDate nascimento, String sobre, Credencial credencial);

    List<Usuario> getAllUsers();

    Optional<Usuario> getUsuario(String nickname);

    List<Credencial> getCredencial(Usuario usuario);
    
}
