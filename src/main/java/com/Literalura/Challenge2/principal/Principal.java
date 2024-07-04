package com.Literalura.Challenge2.principal;


import com.Literalura.Challenge2.model.DatosRecibidos;
import com.Literalura.Challenge2.model.Formatos;
import com.Literalura.Challenge2.model.Libro;
import com.Literalura.Challenge2.repository.LiborRepository;
import com.Literalura.Challenge2.service.ConsumoApi;
import com.Literalura.Challenge2.service.ConvierteDatos;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private String url = "https://gutendex.com/books/";
    private LiborRepository repository;
    private String nom;


    public Principal(LiborRepository repository) {
        this.repository = repository;
    }

    public void ejecutar() {
        int eleccion = -1;


        while (eleccion != 0) {
            System.out.println("""
                    *******************************************
                    ******         LIBRERIA NOBY        *******
                    *******************************************
                                    
                    01_Mostrar todos los libros colgados en la red
                    02_Buscar libro por nombre 
                                        
                    00_Salir
                                    
                    """);

            eleccion = teclado.nextInt();
            teclado.nextLine();
            if (eleccion < -2 || eleccion > 6) {
                System.out.println("Valor no valido");
                break;
            }

            switch (eleccion) {

                case 1:
                    mostrarLibros(url);
                    break;
                case 2:
                    System.out.println("hola");
                    //                 buscarLibroPorNombre();
                    break;
                case 0:
                    break;
            }


        }


        //   System.out.println(datos.getLibros().toString());


    }

    //   private void buscarLibroPorNombre() {
    //     List<Libro>libros=buscarLibro();
    //       System.out.println(nom);
    //   }

    private List<Libro> buscarLibro() {
        System.out.println("Ingrese el nombre del autor a buscar: ");
        String nom = teclado.nextLine();

        System.out.println("Como entra aca?");
        url = url + "?search=" + nom.toLowerCase().replace(" ", "%20");
        DatosRecibidos datos = obtenerDatos(url);
        List<Libro> libros = datos.getLibros().stream().collect(Collectors.toList());
        return libros;

    }


    private DatosRecibidos obtenerDatos(String url) {
        String json = consumoApi.ConsumirApi(url);
        DatosRecibidos datos = convierteDatos.obtenerDatos(json, DatosRecibidos.class);
        return datos;
    }

    private void mostrarLibros(String url) {
        DatosRecibidos datos = obtenerDatos(url);
        List<Libro> libros = datos.getLibros().stream().collect(Collectors.toList());
        System.out.println(libros.toString());
        int aux = 0;
        System.out.println(datos.getSiguiente());
        if (datos.getSiguiente() != null && datos.getAnterior() == null) {
            System.out.println("""
                    1_Pasar a la siguiente pagina
                    0_Volver al menu
                    """);
            aux = teclado.nextInt();
            url = datos.getSiguiente();
        } else if (datos.getSiguiente() != null && datos.getAnterior() != null) {
            System.out.println("""
                    1_Pasar a la siguiente pagina
                    2_Volver a la pagina anterior
                    0_Volver al menu
                    """);
            aux = teclado.nextInt();

        } else if (datos.getSiguiente() == null && datos.getAnterior() != null) {
            System.out.println("""
                    2_Volver a la pagina anterior
                    0_Volver al menu
                    """);
        } else {
            System.out.println("Precione 0 para volver al menu");
        }

        switch (aux) {
            case 1:
                url = datos.getSiguiente();
                mostrarLibros(url);
                break;
            case 2:
                url = datos.getAnterior();
                mostrarLibros(url);
                break;
            case 0:

                break;


        }


    }


}
