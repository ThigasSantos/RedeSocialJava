package com.example.redesocial.dadosInicias;
import com.example.redesocial.usuario.Usuario;
import com.example.redesocial.usuario.UsuarioBeanLocal;
import com.example.redesocial.utils.FakeData;
import com.example.redesocial.utils.JsonUtils;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Singleton
@Startup
public class DadosIniciais {
    @Inject
    UsuarioBeanLocal usuarioBean;
    private static final Logger LOG = Logger.getLogger(DadosIniciais.class.getName());
    @PostConstruct
    public void preencherDados() {
        // dados de usuario (Usuario, telefone, credencial, posts sem comunidade)
        List<Usuario> usuarios = JsonUtils.jsonb.fromJson(FakeData.getFakeData(), new ArrayList<Usuario>(){}.getClass().getGenericSuperclass());
        usuarios.forEach(usuario -> usuarioBean.persist(usuario));
        // fazer relações
    }
}
