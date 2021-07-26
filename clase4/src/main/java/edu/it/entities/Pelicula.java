package edu.it.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    public String id;
    public String nombre;
    public String genero;

    @ManyToOne(cascade=CascadeType.ALL)
    public Director director;

    @ManyToMany(mappedBy = "peliculas", cascade = CascadeType.ALL)
    public List<Actor> actores = new ArrayList<Actor>();

    public Pelicula(String id, String nombre, String genero, Director director) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.director = director;
        director.peliculas.add(this);
    }

    public void agregarActor(Actor a) {
        actores.add(a);
        a.peliculas.add(this);
    }

    public Pelicula() {
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id=" + id + ", nombre=" + nombre + ", genero=" + genero + ", director=" + director + '}';
    }
}
