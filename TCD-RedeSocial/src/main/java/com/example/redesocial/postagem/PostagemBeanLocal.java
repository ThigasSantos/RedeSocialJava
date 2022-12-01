/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.example.redesocial.postagem;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author felipe
 */
@Local
public interface PostagemBeanLocal {
    void salvar(Postagem postagem);

    Postagem localizarPorId(long id);

    List<Postagem> findPostagens();

    void remover(Postagem postagem);

    void update(Postagem postagem);
}
