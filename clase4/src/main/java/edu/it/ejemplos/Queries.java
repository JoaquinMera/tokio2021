package edu.it.ejemplos;

import edu.it.repository.Pelicularepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import edu.it.entities.*;

@Component
public class Queries {
    @Autowired
    Pelicularepository peliRepo;

    public void run() {
        /*
        var optPeli = peliRepo.findById("100000002bis");
        if (optPeli.isPresent()) {
            System.out.println("SE ENCONTRO !!");
        }
        else {
            System.out.println("NO SE ENCONTRO !!!!");
        }
        */

        for (Pelicula p : peliRepo.noImportaElNombre("Plata quemada")) {
            System.out.println(p);
        }
    }
}
