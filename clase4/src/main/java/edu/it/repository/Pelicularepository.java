package edu.it.repository;

import edu.it.entities.Pelicula;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Pelicularepository extends JpaRepository<Pelicula, String> {
    public List<Pelicula> findAllByOrderByGeneroDesc();
    public List<Pelicula> findAllByOrderByNombre();
    public List<Pelicula> findByNombreStartingWith(String n);
    public List<Pelicula> findTop1ByNombreStartingWith(String n);
    public List<Pelicula> findAllByNombreAndGenero(String n, String g);
    @Query("select p from Pelicula p where p.nombre = :param1")
    public List<Pelicula> noImportaElNombre(String param1);

}
