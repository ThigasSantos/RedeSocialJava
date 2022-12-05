package com.example.redesocial.utils.json.customserializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeSerializer  extends StdSerializer<LocalDateTime> {

public LocalDateTimeSerializer() {
        this(null);
        }

protected LocalDateTimeSerializer(Class<LocalDateTime> t) {
        super(t);
        }

@Override
public void serialize(LocalDateTime localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, IOException {

        jsonGenerator.writeObject(
        localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        );
        }
}