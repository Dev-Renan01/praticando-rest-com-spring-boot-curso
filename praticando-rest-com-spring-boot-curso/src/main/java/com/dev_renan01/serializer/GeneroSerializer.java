package com.dev_renan01.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class GeneroSerializer extends JsonSerializer<String> {
    //Formatar o campo de gênero para M / F
    @Override
    public void serialize(String genero, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

        // Se o valor recebido for exatamente "macho", converter para "M" senao "F"
        String formatarGenero = "macho".equals(genero) ? "M":"F";
        jsonGenerator.writeString(formatarGenero); // Seta o valor no Json
    }
}
