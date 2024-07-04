package com.Literalura.Challenge2.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Formatos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonAlias("text/html")
    private String text;

    @JsonAlias("image/jpeg")
    private String imagen;

    @OneToOne()
    @JoinColumn(name = "id_libro")
    private Libro libroid;

    public Formatos(String text, String imagen) {
        this.text = text;
        this.imagen = imagen;
    }

    public Formatos() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    @Override
    public String toString() {
        return
                "Text=" + text +
                ", Imagen='" + imagen + "\n";
    }
}
