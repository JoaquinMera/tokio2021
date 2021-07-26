package edu.it;

import edu.it.ejemplos.FormatoEjemplo;
import edu.it.ejemplos.InsertarPeliculasDirectores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClasePrincipal implements CommandLineRunner {

    @Autowired
    FormatoEjemplo formatoEjemplo;

    @Autowired
    InsertarPeliculasDirectores insertarPeliculasDirectores;

    public void run(String... args) throws Exception {
        insertarPeliculasDirectores.run();
    }
}
