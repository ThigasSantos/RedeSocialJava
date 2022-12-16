package controllers;

import com.example.redesocial.comunidade.ComunidadeServiceLocal;
import com.example.redesocial.dtos.SearchItemDTO;
import com.example.redesocial.usuario.Usuario;
import com.example.redesocial.usuario.UsuarioServiceLocal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Tuple;
import java.util.List;

@Named
@RequestScoped
public class SearchController {
    private SearchItemDTO item;
    @Inject
    UsuarioServiceLocal usuarioService;
    @Inject
    ComunidadeServiceLocal comunidadeService;

    public List<SearchItemDTO> search(String value) {
        List<SearchItemDTO> usuarios = usuarioService.search(value.toLowerCase());
        List<SearchItemDTO> comunidades = comunidadeService.search(value.toLowerCase());
        usuarios.addAll(comunidades);
        return usuarios;
    }

    public SearchItemDTO getItem() {
        return item;
    }

    public void setItem(SearchItemDTO item) {
        this.item = item;
    }
    
    public List<Usuario> getUsuarioHome(){
        return usuarioService.findUsuariosHome();
    }
}
