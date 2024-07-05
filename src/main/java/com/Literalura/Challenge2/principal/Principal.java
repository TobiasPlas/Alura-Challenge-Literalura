package com.Literalura.Challenge2.principal;


import com.Literalura.Challenge2.model.Autor;
import com.Literalura.Challenge2.model.DatosRecibidos;
import com.Literalura.Challenge2.model.Libro;
import com.Literalura.Challenge2.repository.LiborRepository;
import com.Literalura.Challenge2.service.ConsumoApi;
import com.Literalura.Challenge2.service.ConvierteDatos;
import org.yaml.snakeyaml.scanner.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    static String URL = "https://gutendex.com/books/";
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
                                    
                     1_Mostrar todos los libros colgados en la red
                     2_Filtrar libro por titulo 
                     3_Filtrar libro por autor
                     4_Filtrar por idioma 
                     5_Mostrar lista de autores guardados               
                     6_Mostrar autores vivos en determinado año 
                     7_Exhibir cantidad de libros guardados en un determinado idioma
                     0_Salir
                                    
                    """);

            eleccion = teclado.nextInt();
            teclado.nextLine();
            if (eleccion < -2 || eleccion > 6) {
                System.out.println("Valor no valido");
                break;
            }

            switch (eleccion) {

                case 1:
                    mostrarLibros(URL);
                    break;
                case 2:
                    buscarLibroTitulo();
                    break;
                case 3:
                    buscarLibroAutor();
                    break;
                case 4:
                    filtrarIdioma();
                    break;
                case 5:
                    mostrarAutoresGuardados();
                    break;
                case 6:
                    mostrarAutoresPorAnio();
                    break;
                case 7:
                mostrarLibrosIdioma();

                case 0:
                    break;
            }


        }


        //   System.out.println(datos.getLibros().toString());


    }

    private void mostrarLibrosIdioma() {

    }

    private void mostrarAutoresGuardados() {
        List<Autor>list=repository.getAllAutores();
        System.out.println(list.toString());
    }

    private void mostrarAutoresPorAnio() {

        System.out.println("""
                *******************************************
                ********       Elija el año       *********
                *******************************************
                """);
            int ano=teclado.nextInt();

            List<Autor>autors=repository.getAutoresAnio(ano);
        System.out.println(autors.toString());
    }

    private void filtrarIdioma() {
        String idioma = "";
        System.out.println("""
                *******************************************
                *******  Que idioma desea leer?    ********
                *******************************************
                01_Español
                02_English
                """);
        int i = teclado.nextInt();
        teclado.nextLine();
        switch (i) {
            case 1:
                idioma = "es";
                break;
            case 2:
                idioma = "en";
                break;
            default:
                System.out.println("Opcion invalida! :(");
        }

        if (i==1||i==2){
            String urlIdioma=URL+"?languages="+idioma;
            DatosRecibidos datos = obtenerDatos(urlIdioma);

            List<Libro>listaIdioma=datos.getLibros();

            System.out.println(listaIdioma.toString());
            menuSecundario(datos);
        }


    }

    private void buscarLibroAutor() {
        System.out.println("""
                *******************************************
                *****  Ingrese el nombre del autor   ******
                *******************************************
                """);
        String nom = teclado.nextLine().trim();
        List<Libro> libros = buscarLibro(nom);
        List<Libro> librosPorAutor = libros.stream()
                .filter(libro -> libro.getAutores().stream().anyMatch(autor -> autor.getNombre().toLowerCase().contains(nom.toLowerCase()))).collect(Collectors.toList());

        System.out.println(librosPorAutor);
        guardarLibro();
    }

    private void buscarLibroTitulo() {
        System.out.println("Ingrese el nombre del titulo: ");
        String nom = teclado.nextLine().trim();
        List<Libro> libros = buscarLibro(nom);
        List<Libro> librosPorTitulo = libros.stream()
                .filter(libro -> libro.getTitulo().toLowerCase().contains(nom.toLowerCase()))
                .collect(Collectors.toList());
        if (libros!=null){
            System.out.println(librosPorTitulo);
            guardarLibro();
        }else {
            System.out.println("Libro no encontrado");
        }

    }

    private List<Libro> buscarLibro(String nom) {


        URL = URL + "?search=" + nom.toLowerCase().replace(" ", "%20");
        DatosRecibidos datos = obtenerDatos(URL);

            try {
                List<Libro> libros = datos.getLibros().stream().collect(Collectors.toList());
                System.out.println(libros.toString());
            }catch (Exception e){

                System.out.println("Libro no encontrado");
            }
        List<Libro> libros= new ArrayList<>();
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
        menuSecundario(datos);
    }

    private void guardarLibro() {
        System.out.println("""
                Desea guardar algun libro mostrado?
                01_Guardar
                00_Salir
                """);
        int aux = teclado.nextInt();
        teclado.nextLine();
        switch (aux) {
            case 1:
                System.out.println("Ingrese el id del libro a guardar: ");
                long id = teclado.nextLong();
                teclado.nextLine();
                buscarLibroPorId(id);
                break;

        }
    }

    private void buscarLibroPorId(Long id) {
        String aux = "https://gutendex.com/books/?ids=" + id;
        Libro libroEncontrado = obtenerDatos(aux).getLibros().get(0);
        System.out.println(libroEncontrado.toString());
        repository.save(libroEncontrado);

    }

    private void menuSecundario(DatosRecibidos datos) {

        int aux = 0;

        if (datos.getSiguiente() != null && datos.getAnterior() == null) {
            System.out.println("""
                    1_Pasar a la siguiente pagina
                    0_Volver al menu
                    """);
            aux = teclado.nextInt();
            URL = datos.getSiguiente();
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
                URL = datos.getSiguiente();
                mostrarLibros(URL);
                break;
            case 2:
                URL = datos.getAnterior();
                mostrarLibros(URL);
                break;
            case 0:

                break;


        }

    }
}
