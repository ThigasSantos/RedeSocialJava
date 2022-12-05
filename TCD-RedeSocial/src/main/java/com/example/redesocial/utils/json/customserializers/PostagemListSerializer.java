package com.example.redesocial.utils.json.customserializers;

import com.example.redesocial.dtos.RespostaDTO;
import com.example.redesocial.postagem.Postagem;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PostagemListSerializer extends StdSerializer<List<Postagem>> {

    public PostagemListSerializer() {
        this(null);
    }
    public PostagemListSerializer(Class<List<Postagem>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Postagem> postagens, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<RespostaDTO> respostas = new ArrayList<>();

        postagens.forEach(postagem -> respostas.add(new RespostaDTO(
                postagem.getId(),
                postagem.getConteudo(),
                postagem.getUsuario().getNickname()
        )));

        jsonGenerator.writeObject(respostas);
    }
}
