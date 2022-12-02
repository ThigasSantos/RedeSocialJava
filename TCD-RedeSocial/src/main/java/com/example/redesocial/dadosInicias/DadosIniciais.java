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
import com.example.redesocial.usuario.telefone.Telefone;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.logging.Level;

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
        
        Telefone thiagoTel1 = new Telefone(12345651,(short)38);
        Telefone thiagoTel2 = new Telefone(17635651,(short)38);
        thiago.setTelefones(List.of(thiagoTel1,thiagoTel2));
        
        
        Credencial rafaelCR = new Credencial(TipoPerfil.ADMINISTRADOR,"rafael@gmail.com","senha1234");
        Usuario rafael = new Usuario(
                "dePaula",
                "Estudante da Trybe",
                LocalDate.of(1999, Month.MAY, 12),
                rafaelCR
        );
        
        Telefone rafaelTel1 = new Telefone(12135456,(short)38);
        Telefone rafaelTel2 = new Telefone(85239632,(short)23);
        rafael.setTelefones(List.of(rafaelTel1,rafaelTel2));
        
        
        Credencial felipeCR = new Credencial(TipoPerfil.ADMINISTRADOR,"boasorte@gmail.com","senha125");
        Usuario felipe = new Usuario(
                "BoaSorte",
                "Estudante e otaku",
                LocalDate.of(2000, Month.MARCH, 15),
                felipeCR
        );
        
        Telefone felipeTel1 = new Telefone(85471236,(short)38);
        Telefone felipeTel2 = new Telefone(96164748,(short)35);
        felipe.setTelefones(List.of(felipeTel1,felipeTel2));
        
        
        Credencial andreCR = new Credencial(TipoPerfil.ADMINISTRADOR,"andre@gmail.com","12345");
        Usuario andre = new Usuario(
                "AndreV",
                "Data Scientist",
                LocalDate.of(2000, Month.MARCH, 20),
                andreCR
        );
        
        Telefone andreTel1 = new Telefone(99166789,(short)38);
        Telefone andreTel2 = new Telefone(94315345,(short)41);
        andre.setTelefones(List.of(andreTel1,andreTel2));
        
        
        Credencial juninhoCR = new Credencial(TipoPerfil.USUARIO_PADRAO,"juninho2002@gmail.com","1452");
        Usuario juninho = new Usuario(
                "Juninho_2002",
                "VASP",
                LocalDate.of(2002, Month.DECEMBER, 9),
                juninhoCR
        );
        
        Telefone juninhoTel = new Telefone(20568192,(short)11);
        juninho.setTelefones(List.of(juninhoTel));
        
        
        Credencial marcosCR = new Credencial(TipoPerfil.USUARIO_PADRAO,"marcosdapizzaria@gmail.com","1452");
        Usuario marcos = new Usuario(
                "MarquinhoPizzas",
                "Pizzaria mais gostosa da cidade",
                LocalDate.of(2002, Month.DECEMBER, 9),
                marcosCR
        );
        
        Telefone marcosTel = new Telefone(20552692,(short)11);
        marcos.setTelefones(List.of(marcosTel));
        
        
        Comunidade comunidade1 = new Comunidade(
                "AmantesDePizza",
                "Comunidade das pessoas que mais gostam de pizzas, cheio de memes e tambem sempre informando os melhores lugares",
                LocalDate.of(2022, Month.MARCH, 15),
                marcos,
                List.of(rafael,thiago,felipe)
        );
        
        
        Comunidade comunidade2 = new Comunidade(
                "Gosto de Animes",
                "Comunidade das pessoas que assistem animes, cheio de memes",
                LocalDate.of(2022, Month.MARCH, 19),
                felipe,
                List.of(rafael,marcos)
        );
        
        
        Comunidade comunidade3 = new Comunidade(
                "Estudantes de Web",
                "Comunidade das pessoas que estão estudando web",
                LocalDate.of(2022, Month.MARCH, 22),
                andre,
                List.of(rafael,marcos,thiago,juninho,felipe)
        );
        
        
        thiago.setSeguindo(List.of(felipe,rafael,andre));
        felipe.setSeguindo(List.of(andre,felipe,juninho,marcos));
        andre.setSeguindo(List.of(thiago,felipe,juninho,marcos));
        rafael.setSeguindo(List.of(thiago,felipe,juninho));
        juninho.setSeguindo(List.of(marcos));
        marcos.setSeguindo(List.of(thiago,felipe,andre,rafael,juninho));
        
        usuarioService.persist(thiago);
        usuarioService.persist(rafael);
        usuarioService.persist(felipe);
        usuarioService.persist(andre);
        usuarioService.persist(juninho);
        usuarioService.persist(marcos);
        
        comunidadeService.salvar(comunidade1);
        comunidadeService.salvar(comunidade2);
        comunidadeService.salvar(comunidade3);
        
    }
}
