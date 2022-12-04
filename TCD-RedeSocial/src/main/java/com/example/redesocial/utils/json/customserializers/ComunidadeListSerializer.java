package com.example.redesocial.utils.json.customserializers;

import com.example.redesocial.comunidade.Comunidade;
import com.example.redesocial.usuario.Usuario;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComunidadeListSerializer extends StdSerializer<List<Comunidade>> {

    public ComunidadeListSerializer() {
        this(null);
    }

    protected ComunidadeListSerializer(Class<List<Comunidade>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Comunidade> comunidades, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        List<Map<String, Object>> itens = new ArrayList<>();

        comunidades.forEach(comunidade -> itens.add(
                new HashMap<>() {{
                    put("id", comunidade.getId());
                    put("nickname", comunidade.getNome());
                }}));

        jsonGenerator.writeObject(itens);
    }
}