package com.Literalura.Challenge2.principal;


import com.Literalura.Challenge2.model.DatosRecibidos;
import com.Literalura.Challenge2.model.Libro;
import com.Literalura.Challenge2.service.ConsumoApi;
import com.Literalura.Challenge2.service.ConvierteDatos;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

public class Principal {


    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private String url = "https://gutendex.com/books/";

    public void ejecutar() {
        DatosRecibidos datos = new DatosRecibidos();

        String json = consumoApi.ConsumirApi(url);
        
        datos = convierteDatos.obtenerDatos(json, DatosRecibidos.class);
        System.out.println(datos.getLibros().toString());
        System.out.println("");
        System.out.println("**************************");
        System.out.println("");
        System.out.println(datos.getSiguiente());

        json=consumoApi.ConsumirApi(datos.getSiguiente());
        datos = convierteDatos.obtenerDatos(json, DatosRecibidos.class);
        System.out.println(datos.getLibros().toString());





    }


}
