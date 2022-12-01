package com.example.redesocial.dadosInicias;
import com.example.redesocial.comunidade.Comunidade;
import com.example.redesocial.comunidade.ComunidadeServiceLocal;
import com.example.redesocial.usuario.Usuario;
import com.example.redesocial.usuario.credencial.Credencial;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.logging.Logger;
import com.example.redesocial.usuario.UsuarioServiceLocal;
import com.example.redesocial.usuario.credencial.TipoPerfil;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Singleton
@Startup
public class DadosIniciais {
    @Inject
    UsuarioServiceLocal usuarioService;
    @Inject
    ComunidadeServiceLocal comunidadeService;
    private static final Logger LOG = Logger.getLogger(DadosIniciais.class.getName());
    @PostConstruct
    public void preencherDados() {
        // dados de usuario (Usuario, telefone, credencial, posts sem comunidade)
       //List<Usuario> usuarios = JsonUtils.jsonb.fromJson(FakeData.getFakeData(), new ArrayList<Usuario>(){}.getClass().getGenericSuperclass());
       // usuarios.forEach(usuario -> usuarioBean.persist(usuario));
        // fazer relações
        
        Credencial thiagoCR = new Credencial(TipoPerfil.ADMINISTRADOR,"thigas@gmail.com","senha123");
        Usuario thiago = new Usuario(
                "thigas",
                "Estudante de CC pelo IFNMG",
                LocalDate.of(2000, Month.FEBRUARY, 7),
                thiagoCR
        );
        
        usuarioService.persist(thiago);
        
        Credencial rafaelCR = new Credencial(TipoPerfil.ADMINISTRADOR,"rafael@gmail.com","senha1234");
        Usuario rafael = new Usuario(
                "dePaula",
                "Estudante da Trybe",
                LocalDate.of(1999, Month.MAY, 12),
                rafaelCR
        );
        
        usuarioService.persist(rafael);
        
        Credencial felipeCR = new Credencial(TipoPerfil.ADMINISTRADOR,"boasorte@gmail.com","senha125");
        Usuario felipe = new Usuario(
                "BoaSorte",
                "Estudante e otaku",
                LocalDate.of(2000, Month.MARCH, 15),
                felipeCR
        );
        
        usuarioService.persist(felipe);
        
        Credencial andreCR = new Credencial(TipoPerfil.ADMINISTRADOR,"andre@gmail.com","12345");
        Usuario andre = new Usuario(
                "AndreV",
                "Data Scientist",
                LocalDate.of(2000, Month.MARCH, 20),
                andreCR
        );
        
        usuarioService.persist(andre);
        
        Credencial juninhoCR = new Credencial(TipoPerfil.USUARIO_PADRAO,"juninho2002@gmail.com","1452");
        Usuario juninho = new Usuario(
                "Juninho_2002",
                "VASP",
                LocalDate.of(2002, Month.DECEMBER, 9),
                juninhoCR
        );
        
        usuarioService.persist(juninho);
        
        Credencial marcosCR = new Credencial(TipoPerfil.USUARIO_PADRAO,"marcosdapizzaria@gmail.com","1452");
        Usuario marcos = new Usuario(
                "MarquinhoPizzas",
                "Pizzaria mais gostosa da cidade",
                LocalDate.of(2002, Month.DECEMBER, 9),
                marcosCR
        );
        
        usuarioService.persist(marcos);
        
        Comunidade comunidade1 = new Comunidade(
                "AmantesDePizza",
                "Comunidade das pessoas que mais gostam de pizzas, cheio de memes e tambem sempre informando os melhores lugares",
                LocalDate.of(2022, Month.MARCH, 15),
                marcos,
                List.of(rafael,thiago,felipe)
        );
        
        comunidadeService.salvar(comunidade1);
    }
}
