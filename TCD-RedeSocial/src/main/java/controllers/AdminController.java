package controllers;

import com.example.redesocial.comunidade.Comunidade;
import com.example.redesocial.comunidade.ComunidadeServiceLocal;
import com.example.redesocial.dtos.PostagemDTO;
import com.example.redesocial.dtos.SearchItemDTO;
import com.example.redesocial.postagem.Postagem;
import com.example.redesocial.postagem.PostagemServiceLocal;
import com.example.redesocial.usuario.Usuario;
import com.example.redesocial.usuario.UsuarioServiceLocal;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AdminController implements Serializable {
    @Inject
    UsuarioServiceLocal usuarioService;

    @Inject
    ComunidadeServiceLocal comunidadeService;

    @Inject
    PostagemServiceLocal postagemService;

    @Inject
    PostagemController pc;

    private Usuario usuario;

    private Comunidade comunidade;

    private Postagem postagemToDelete;

    private List<PostagemDTO> postagemDTOList;

    private SearchItemDTO item = new SearchItemDTO();

    public void info() {
        usuario = null;
        comunidade = null;

        if (item == null)
            return;

        if (item.getType().equals("usuario")) {
            usuario = usuarioService.getUsuarioByNickname(item.getNome());
            pc.getFeedFromUser(usuario);
        }
        if(item.getType().equals("comunidade"))
            comunidade = comunidadeService.getFromName(item.getNome());

        item = null;
    }

    public Comunidade getComunidade() {
        return comunidade;
    }

    public void setComunidade(Comunidade comunidade) {
        this.comunidade = comunidade;
    }

    public void editarUsuario() {
        this.usuario = usuarioService.merge(this.usuario);
        this.usuario = usuarioService.merge(this.usuario);
    }

    public void removerUsuario() {
        usuarioService.remover(usuario);
    }

    public void removerPostagem() {
        postagemService.remover(postagemToDelete);
    }

    public SearchItemDTO getItem() {
        return item;
    }

    public void setItem(SearchItemDTO item) {
        this.item = item;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public Postagem getPostagemToDelete() {
        return postagemToDelete;
    }

    public void setPostagemToDelete(Postagem postagemToDelete) {
        this.postagemToDelete = postagemToDelete;
    }


    public List<PostagemDTO> getPostagemDTOList() {
        return postagemDTOList;
    }

    public void setPostagemDTOList(List<PostagemDTO> postagemDTOList) {
        this.postagemDTOList = postagemDTOList;
    }
}
