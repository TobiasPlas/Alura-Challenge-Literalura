package com.Literalura.Challenge2.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;


@Entity
@JsonIgnoreProperties(ignoreUnknown = true )
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonAlias("title")
    private String titulo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonAlias("authors")
    private List<Autor> autores;

    @JsonAlias("subjects")
    private List<String> asignaturas;

    @JsonAlias("languages")
    private List<String> lenguaje;

    @JsonAlias("download_count")
    private long cantidadDeDescargas;

    @OneToOne()
    @JsonAlias("formats")
    private Formatos formato;



    public Libro(Long id, String titulo, List<Autor> autores, List<String> asignaturas, List<String> lenguaje,
                 long cantidadDeDescargas, Formatos formato, String portada, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
        this.asignaturas = asignaturas;
        this.lenguaje = lenguaje;
        this.cantidadDeDescargas = cantidadDeDescargas;
        this.formato = formato;

    }


    public Libro() {
    }



    public Formatos getFormato() {
        return formato;
    }

    public void setFormato(Formatos formato) {
        this.formato = formato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<String> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<String> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public List<String> getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(List<String> lenguaje) {
        this.lenguaje = lenguaje;
    }

    public long getCantidadDeDescargas() {
        return cantidadDeDescargas;
    }

    public void setCantidadDeDescargas(long cantidadDeDescargas) {
        this.cantidadDeDescargas = cantidadDeDescargas;
    }


    @Override
    public String toString() {
        return "\n"+"Libro" + "\n"+
                "id=" + id +"\n"+
                "Titulo='" + titulo + "\n"+
                "Autores=" + autores +"\n"+
                "Asignaturas=" + asignaturas +"\n"+
                "Lenguaje=" + lenguaje +"\n"+
                "CantidadDeDescargas=" + cantidadDeDescargas +"\n"+
                "Formato=" + formato +"\n"+
                "*******************************************";
    }
}
