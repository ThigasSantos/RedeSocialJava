/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.example.redesocial.usuario.telefone;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author andre-barros
 */
@Local
public interface TelefoneServiceLocal {

    void salvar(Telefone telefone);

    Telefone localizarPorId(long id);

    List<Telefone> findTelefones();

    void update(Telefone telefone);

    void remover(Telefone telefone);
    
}
