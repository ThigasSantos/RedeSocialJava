package com.example.redesocial.servlets;
import com.example.redesocial.comunidade.Comunidade;
import com.example.redesocial.comunidade.ComunidadeServiceLocal;
import com.example.redesocial.postagem.Postagem;
import com.example.redesocial.postagem.PostagemServiceLocal;
import com.example.redesocial.usuario.Usuario;
import com.example.redesocial.usuario.UsuarioServiceLocal;
import com.example.redesocial.utils.HTMLGenerator;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Queries", value = "/testes/queries")
@Transactional
public class Servlet extends HttpServlet {

    @Inject
    ComunidadeServiceLocal comunidadeService;

    @Inject
    PostagemServiceLocal postagemService;

    @Inject
    UsuarioServiceLocal usuarioService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><head>" +
                "<link rel=\"stylesheet\" href=\"./static/css/relatorios.css\">" +
                "<style>" +
                "body { padding: 30px }" +
                "h1 { text-align: center }" +
                "details[open] { font-size: 1.3em }" +
                "details > pre{ " +
                "overflow-x: scroll;" +
                "background-color: rgb(252, 252, 252);" +
                "border-radius: 20px;" +
                "padding: 10 50px;" +
                "box-shadow: 2px 2px grey;" +
                "border-left: 1px solid gray;" +
                "border-top: 1px solid gray;}; </style></head><body>");

        out.println("<h1> Testes de Queries: </h1>");

        out.println(HTMLGenerator.testQuery(
                "Todas as Comunidades",
                comunidadeService.findComunidades()
                ));

        out.println(HTMLGenerator.testQuery(
                "Todos as Postagens",
                postagemService.findPostagens()
        ));

        out.println(HTMLGenerator.testQuery(
                "Feed",
                usuarioService.findPostsSeguidores(new Usuario() {{ setId(1L); }})
        ));

        out.println(HTMLGenerator.testQuery(
                "Respostas Postagem",
                postagemService.findRespostasPosts(new Postagem() {{ setId(4L); }})
        ));

        out.println(HTMLGenerator.testQuery(
                "Usuarios que curtiram a Postagem",
                postagemService.findUsuariosCurtiram(new Postagem() {{ setId(1L); }})
        ));

        out.println(HTMLGenerator.testQuery(
                "Postagens da Comunidade",
                comunidadeService.findPostsComunidades(new Comunidade() {{ setId(2L); }})
        ));

        out.println(HTMLGenerator.testQuery(
                "Postagens mais curtidas",
                postagemService.postagensMaisPopulares()
        ));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
