package com.example.redesocial.usuario.credencial;

public interface CredencialServiceLocal {

    Credencial criarCredencial(TipoPerfil perfil, String email, String senha);

    Credencial criarCredencial(Credencial credencial);
    
    
}
