package com.Literalura.Challenge2.repository;

import com.Literalura.Challenge2.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LiborRepository extends JpaRepository<Libro,Long> {
    @Query("SELECT l FROM Libro l WHERE l.titulo ILIKE %:nom")
    List<Libro> buscarLibroPorNombre(String nom);


}
