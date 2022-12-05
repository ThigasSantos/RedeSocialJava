package com.example.redesocial.utils.json.customserializers;

import com.example.redesocial.comunidade.Comunidade;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ComunidadeSingleSerializer extends StdSerializer<Comunidade> {

    public ComunidadeSingleSerializer() {
        this(null);
    }

    protected ComunidadeSingleSerializer(Class<Comunidade> t) {
        super(t);
    }

    @Override
    public void serialize(Comunidade comunidade, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Map<String, Object> item = new HashMap<>() {{
            put("id", comunidade.getId());
            put("nickname", comunidade.getNome());
        }};

        jsonGenerator.writeObject(item);
    }
}
