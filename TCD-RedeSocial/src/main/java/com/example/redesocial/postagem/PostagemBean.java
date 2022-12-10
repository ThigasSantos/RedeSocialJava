package com.example.redesocial.postagem;

import com.example.redesocial.dtos.PostagemDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named
@RequestScoped
@Transactional
public class PostagemBean {
    @Inject
    PostagemServiceLocal postagemService;

    public List<PostagemDTO> getPostagensPopulares() {
        return postagemService.postagensMaisPopulares();
    }
}
