package com.example.redesocial.utils.json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;

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

    public static String toJackson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // StdDateFormat is ISO8601 since jackson 2.9
        objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
        return objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(object);
    }

}
