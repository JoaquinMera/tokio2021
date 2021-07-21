package edu.it.ejemplos;

import edu.it.components.ConectorJPA;
import edu.it.entities.*;
import org.apache.log4j.Logger;

public class EagerVsLazy implements Runnable {
    Logger logger = Logger.getLogger(EagerVsLazy.class);

    public void run() {
        var em = new ConectorJPA().getEntityManager();

        var tq = em.createQuery("SELECT d FROM Director d", Director.class);
        var xs = tq.getResultList();

        for (var director : xs) {
            logger.info(director);
            try {
                for (var i : new int[100]) {
                    System.out.print(".");
                    Thread.sleep(80);
                }
                System.out.println("");
            }
            catch (Exception ex) {}

            for (var pelicula : director.peliculas) {
                logger.info("       " + pelicula.nombre);
            }
        }
    }
}
