package com.example.redesocial.utils.json.customserializers;

import com.example.redesocial.usuario.Usuario;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioListSerializer extends StdSerializer<List<Usuario>> {

    public UsuarioListSerializer() {
        this(null);
    }
    public UsuarioListSerializer(Class<List<Usuario>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Usuario> usuarios, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            List<Map<String, Object>> itens = new ArrayList<>();
            for (Usuario item : usuarios) {
                itens.add(new HashMap<>(){{
                    put("id", item.getId());
                    put("nickname", item.getNickname());
                }});
            }
            jsonGenerator.writeObject(itens);
    }
}
