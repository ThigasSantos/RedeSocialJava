package com.example.redesocial.servlets;

import com.example.redesocial.comunidade.ComunidadeServiceLocal;
import com.example.redesocial.utils.HTMLGenerator;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Queries", value = "/testes/queries")
public class Servlet extends HttpServlet {

    @Inject
    ComunidadeServiceLocal comunidadeService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><head>" +
                "<link rel=\"stylesheet\" href=\"./static/css/relatorios.css\">" +
                "<style>" +
                "body { padding: 30px }" +
                "h1 { text-align: center }" +
                "details > pre{ " +
                "background-color: rgb(252, 252, 252);" +
                "border-radius: 20px;" +
                "padding: 10 50px;" +
                "box-shadow: 2px 2px grey;" +
                "border-left: 1px solid gray;" +
                "border-top: 1px solid gray;}; </style></head><body>");

        out.println("<h1> Testes de Queries: </h1>");

        out.println(HTMLGenerator.testQuery(
                "Retornar todas as comunidades",
                comunidadeService.findComunidades()
                ));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
