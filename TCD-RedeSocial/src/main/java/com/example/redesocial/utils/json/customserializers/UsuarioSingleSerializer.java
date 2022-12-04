package com.example.redesocial.utils.json.customserializers;

import com.example.redesocial.usuario.Usuario;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UsuarioSingleSerializer extends StdSerializer<Usuario> {

    public UsuarioSingleSerializer() {
        this(null);
    }

    protected UsuarioSingleSerializer(Class<Usuario> t) {
        super(t);
    }

    @Override
    public void serialize(Usuario usuario, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Map<String, Object> item = new HashMap<>() {{
           put("id", usuario.getId());
           put("nickname", usuario.getNickname());
        }};

        jsonGenerator.writeObject(item);
    }
}
