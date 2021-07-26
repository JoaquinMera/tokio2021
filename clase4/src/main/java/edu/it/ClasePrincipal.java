package edu.it;

import edu.it.ejemplos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClasePrincipal implements CommandLineRunner {

    @Autowired
    FormatoEjemplo formatoEjemplo;

    @Autowired
    InsertarPeliculasDirectores insertarPeliculasDirectores;

    @Autowired
    Queries queries;

    public void run(String... args) throws Exception {
        queries.run();
    }
}
