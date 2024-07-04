package com.Literalura.Challenge2.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonAlias("name")
    private String nombre;

    @JsonProperty("birth_year")
    private int nacimiento;

    @JsonProperty("death_year")
    private int defuncion;


    public Autor(long id, String nombre, int nacimiento, int defuncion) {
        this.id = id;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.defuncion = defuncion;
    }

    public Autor() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(int nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getDefuncion() {
        return defuncion;
    }

    public void setDefuncion(int defuncion) {
        this.defuncion = defuncion;
    }

    @Override
    public String toString() {
        return
                "Nombre=" + nombre + '\n' +
                "         Nacimiento=" + nacimiento +'\n' +
                "         Defuncion=" + defuncion
                ;
    }
}
