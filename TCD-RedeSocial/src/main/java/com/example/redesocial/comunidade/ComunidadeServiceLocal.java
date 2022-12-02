/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.example.redesocial.comunidade;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author andre-barros
 */
@Local
public interface ComunidadeServiceLocal {

    void salvar(Comunidade comunidade);

    Comunidade localizarPorId(long id);

    List<Comunidade> findComunidades();

    void remover(Comunidade comunidade);

    void update(Comunidade comunidade);
    
}
