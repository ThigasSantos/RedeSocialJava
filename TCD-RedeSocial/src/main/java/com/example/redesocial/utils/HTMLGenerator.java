package com.example.redesocial.utils;

import com.example.redesocial.utils.json.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;

public final class HTMLGenerator {
    public static String testQuery(String title, Object relatorio) throws JsonProcessingException {
        return "<h2>" + title + "</h2>"
                + "<details> " +
                "<summary style=\"cursor: pointer\">Respostas</summary> " +
                "<p><pre class=\"language-json\"> " + JsonUtils.toJackson(relatorio) + "</pre></p></details>";
    }
}
