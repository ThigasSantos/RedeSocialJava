package controllers;

import com.example.redesocial.usuario.Usuario;
import com.example.redesocial.usuario.UsuarioServiceLocal;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class UsuarioController implements Serializable {

    @Inject
    UsuarioServiceLocal usuarioService;
    private String nickname;

    private Usuario usuario;


    public Usuario getUsuario() {
        if(usuario == null) usuario = usuarioService.getUsuarioByNickname(nickname);
        return usuario;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
