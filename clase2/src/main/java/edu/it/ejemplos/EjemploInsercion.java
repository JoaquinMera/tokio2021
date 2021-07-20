package edu.it.ejemplos;

import edu.it.components.ConectorJPA;
import edu.it.components.GeneradorUsuarios;
import javax.persistence.EntityTransaction;

public class EjemploInsercion implements Runnable {
    public void run() {
        var em = new ConectorJPA().getEntityManager();

        for (;;) {
            var usu = GeneradorUsuarios.generarUsuario();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(usu);
            tx.commit();
        }
    }
}
