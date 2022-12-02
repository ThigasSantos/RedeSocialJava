package com.example.redesocial.utils;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyOrderStrategy;
import java.util.Locale;

public final class JsonUtils {
    public static final Jsonb jsonb = JsonbBuilder.create(new JsonbConfig()
            .withFormatting(true)
            .withDateFormat("dd/MM/yyyy", Locale.forLanguageTag("pt_BR"))
            .withPropertyOrderStrategy(PropertyOrderStrategy.LEXICOGRAPHICAL));

    public static String toJson(Object object) {
        return jsonb.toJson(object);
    }

}
