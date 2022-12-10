package com.example.redesocial.utils.json.customserializers;

import com.example.redesocial.postagem.Postagem;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.HashMap;

public class PostagemSingleSerializer extends StdSerializer<Postagem> {

    public PostagemSingleSerializer() {
        this(null);
    }
    public PostagemSingleSerializer(Class<Postagem> t) {
        super(t);
    }

    @Override
    public void serialize(Postagem postagem, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(new HashMap<>() {{
            put("id", postagem.getId());
            put("conteudo", postagem.getConteudo());
            put("nickname", postagem.getUsuario().getNickname());
        }});
    }
}