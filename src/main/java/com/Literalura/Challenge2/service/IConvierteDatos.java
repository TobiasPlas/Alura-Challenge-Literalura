package com.Literalura.Challenge2.service;

public interface IConvierteDatos {

    <T> T obtenerDatos(String json,Class<T>clase);
}
