package edu.it.repository;

import edu.it.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pelicularepository extends JpaRepository<Pelicula, String> {

}
