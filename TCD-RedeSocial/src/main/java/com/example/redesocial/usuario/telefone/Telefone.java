package com.example.redesocial.usuario.telefone;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(
            name = "findTelefones",
            query = "SELECT t FROM Telefone t"
    )
})
public class Telefone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private Short ddd;

    public Telefone() {
    }
   
    public Telefone(Integer numero, Short ddd) {
        this.numero = numero;
        this.ddd = ddd;
    } 
      
    // <editor-fold  defaultstate="collapsed" desc="Getters/Setters" >
    public Long getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Short getDdd() {
        return ddd;
    }

    public void setDdd(Short ddd) {
        this.ddd = ddd;
    }

    // </editor-fold>
}
