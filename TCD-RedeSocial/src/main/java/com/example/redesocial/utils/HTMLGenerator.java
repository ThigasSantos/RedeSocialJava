package com.example.redesocial.utils;

public final class HTMLGenerator {
    public static String testQuery(String title, Object relatorio) {
        return "<h2>" + title + "</h2>"
                + "<details style=\" font-size: 1.3em\"> " +
                "<summary style=\"cursor: pointer\">Respostas</summary> " +
                "<p><pre class=\"language-json\"> " + JsonUtils.toJson(relatorio) + "</pre></p></details>";
    }
}
