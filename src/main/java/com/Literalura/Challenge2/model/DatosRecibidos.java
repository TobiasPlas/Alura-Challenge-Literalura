package com.Literalura.Challenge2.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatosRecibidos {


    @JsonAlias("count")
    private int cantidadDeLibros;

    @JsonAlias("next")
    private String siguiente;

    @JsonAlias("previous")
    private String anterior;

    @JsonAlias("results")
    private List<Libro> libros;


    public DatosRecibidos(int cantidadDeLibros, List<Libro> libros) {
        this.cantidadDeLibros = cantidadDeLibros;
        this.libros = libros;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public DatosRecibidos() {
    }

    public int getCantidadDeLibros() {
        return cantidadDeLibros;
    }

    public void setCantidadDeLibros(int cantidadDeLibros) {
        this.cantidadDeLibros = cantidadDeLibros;
    }

    public String getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(String siguiente) {
        this.siguiente = siguiente;
    }

    public String getAnterior() {
        return anterior;
    }

    public void setAnterior(String anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "DatosRecibidos{" +
                "cantidadDeLibros=" + cantidadDeLibros +
                ", siguiente='" + siguiente + '\'' +
                ", anterior='" + anterior + '\'' +
                '}';
    }
}
