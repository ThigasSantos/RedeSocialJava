package com.example.redesocial.utils.json.customserializers;

import com.example.redesocial.dtos.RespostaDTO;
import com.example.redesocial.postagem.Postagem;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import javax.persistence.Tuple;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostagemListSerializer extends StdSerializer<List<Postagem>> {

    public PostagemListSerializer() {
        this(null);
    }
    public PostagemListSerializer(Class<List<Postagem>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Postagem> postagens, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<Map<String, Object>> itens = new ArrayList<>();
        postagens.forEach(p -> new HashMap<>() {{
            put("id", p.getId());
            put("conteudo", p.getConteudo());
            put("nickname", p.getUsuario().getNickname());
        }});

        jsonGenerator.writeObject(itens);
    }
}
