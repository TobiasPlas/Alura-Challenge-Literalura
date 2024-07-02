package com.Literalura.Challenge2.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

public class ConvierteDatos implements IConvierteDatos{

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json,Class<T> clase) {
        try {
            // Verificar si jsonData está vacío antes de intentar convertirlo
            if (json == null || json.trim().isEmpty()) {
                // Manejar el caso de JSON vacío o nulo según sea necesario
                System.out.println("El JSON está vacío o nulo.");

            }
        } catch (Exception e) {
            // Manejar otras excepciones generales
            e.printStackTrace();
        }

        try {
            return objectMapper.readValue(json,clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
